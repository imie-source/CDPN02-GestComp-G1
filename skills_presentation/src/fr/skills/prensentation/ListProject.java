package fr.skills.prensentation;

import java.util.ArrayList;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;

import fr.skills.controller.ProjectController;
import fr.skills.dto.ProjectDTO;

public class ListProject extends Window {

	public ListProject()
	{
		super("Liste des projets :");
		Panel horisontalPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
		ArrayList<ProjectDTO> vListe = ProjectController.listAll();

		StringBuilder vChaine = new StringBuilder();
		for (ProjectDTO element : vListe)
		{
			vChaine.append(element.getName());
			vChaine.append("\n");
		}
		horisontalPanel.addComponent(new Label(vChaine.toString()));
		addComponent(horisontalPanel);
	}

}
