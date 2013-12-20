package fr.skills.prensentation;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;

import fr.skills.controller.ProjectController;
import fr.skills.dto.ProjectDTO;

public class AddProject extends Window {

	public AddProject()
	{
		super("Ajout de projet :");
		Panel horisontalPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
		horisontalPanel.addComponent(new Label("Nom du projet : "));
		final TextBox vName = new TextBox();
		horisontalPanel.addComponent(vName);

		addComponent(horisontalPanel);
		addComponent(new Button("Soumettre le forumlaire", new Action() {
			@Override
			public void doAction()
			{
				System.out.println(vName.getText());
				ProjectDTO vProjectDTO = new ProjectDTO(null, vName.getText());
				ProjectController.create(vProjectDTO);
				MessageBox.showMessageBox(getOwner(), "", "Formulaire envoyé!");
			}
		}));
	}
}
