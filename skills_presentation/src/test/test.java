package test;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;

import fr.skills.prensentation.ListProject;

public class test {

	public static void main(String[] args)
	{
		// FactoryDAO afd =
		// DAOAbstractFactory.getFactory(DAOAbstractFactory.DAO_FACTORY);
		//
		// TaskService taskService = new TaskService(afd);
		// ProjectService projectService = new ProjectService();
		// projectService.create(new ProjectDTO(null, "Project 1"));

		// TaskDTO aTask = new TaskDTO();
		// aTask.setEstimatedDurationTask((long) 179555515);
		// aTask.setIdProjet(1);
		// aTask.setNameTask("AZEZDE");
		// aTask.setStatusTask(Status.Annuler);
		// taskService.create(aTask);
		//
		// ArrayList<TaskDTO> aListeTask = (ArrayList<TaskDTO>)
		// taskService.findAll();
		//
		// System.out.println(aListeTask.size());

		GUIScreen textGUI = TerminalFacade.createGUIScreen();
		if (textGUI == null)
		{
			System.err.println("Couldn't allocate a terminal!");
			return;
		}
		textGUI.getScreen().startScreen();

		// textGUI.showWindow(new AddProject(), GUIScreen.Position.FULL_SCREEN);
		textGUI.showWindow(new ListProject(), GUIScreen.Position.FULL_SCREEN);
		textGUI.getScreen().stopScreen();

	}
}
