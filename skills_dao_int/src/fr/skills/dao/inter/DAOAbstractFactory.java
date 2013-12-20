package fr.skills.dao.inter;

import java.util.logging.Logger;

public abstract class DAOAbstractFactory {

	public static final int DAO_FACTORY = 0;
	private static Logger LOGGER = Logger.getLogger(DAOAbstractFactory.class.getName());

	public static FactoryDAO getFactory(int type)
	{
		switch (type)
		{
		case DAO_FACTORY:
			try
			{
				return (FactoryDAO) Class.forName("fr.skills.dao.impl.FactoryDAOPg").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
			{
				LOGGER.severe(e.toString());
			}

		default:
			return null;
		}
	}
}
