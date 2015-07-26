package org.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.gui.CreatObjectGui;


public class CreateObjectListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CreatObjectGui gui = new CreatObjectGui();
		gui.setVisible(true);
	}

	
}
