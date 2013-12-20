package fr.skills_dao_impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ConnectionPool implements Runnable {
	private static Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());

	private final String userName = "postgres";
	private final String password = "ayumi1987";
	private final String urlString = "jdbc:postgresql://localhost/imie";

	private static ConnectionPool INSTANCE = new ConnectionPool();

	private final int initialConnectionCount = 5;

	private final List<Connection> availableConnections = Collections.synchronizedList(new ArrayList<Connection>());

	private final List<Connection> usedConnections = Collections.synchronizedList(new ArrayList<Connection>());

	// The cleanup thread
	private Thread cleanupThread = null;

	private ConnectionPool()
	{
		for (int cnt = 0; cnt < initialConnectionCount; cnt++)
		{
			// Add a new connection to the available list.
			availableConnections.add(getConnection());
		}

		// Create the cleanup thread
		cleanupThread = new Thread(this);
		cleanupThread.start();
	}

	public static ConnectionPool getInstance()
	{
		return INSTANCE;
	}

	private Connection getConnection()
	{
		Connection vRet = null;
		try
		{
			vRet = DriverManager.getConnection(urlString, userName, password);
		} catch (SQLException e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
		return vRet;
	}

	public synchronized Connection checkout() throws SQLException
	{
		Connection newConnxn = null;

		if (availableConnections.size() == 0)
		{
			newConnxn = getConnection();
			usedConnections.add(newConnxn);
		} else
		{
			newConnxn = availableConnections.get(availableConnections.size() - 1);
			availableConnections.remove(newConnxn);
			usedConnections.add(newConnxn);
		}

		return newConnxn;
	}

	public synchronized void checkin(Connection c)
	{
		if (c != null)
		{
			usedConnections.remove(c);
			availableConnections.add(c);
		}
	}

	public int availableCount()
	{
		return availableConnections.size();
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				synchronized (this)
				{
					while (availableConnections.size() > initialConnectionCount)
					{
						Connection c = availableConnections.get(availableConnections.size() - 1);
						availableConnections.remove(c);
						c.close();
					}
				}
				Thread.sleep(60 * 1);
			}
		} catch (SQLException sqle)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("SQL ERROR : ");
			vMessageErreur.append(sqle);
			LOGGER.severe(vMessageErreur.toString());
		} catch (Exception e)
		{
			StringBuilder vMessageErreur = new StringBuilder();
			vMessageErreur.append("ERROR : ");
			vMessageErreur.append(e);
			LOGGER.severe(vMessageErreur.toString());
		}
	}
}
