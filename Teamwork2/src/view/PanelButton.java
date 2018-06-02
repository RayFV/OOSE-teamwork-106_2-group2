package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import abstractFactory.AbstractSkinFactory;
import listeners.DeleteListener;
import listeners.EditListener;
import listeners.BtnAddNoteListener;
import listeners.BtnSelectListener;
import listeners.BtnStateListener;
import listeners.BtnTransListener;

public class PanelButton{
	
	private JButton btnState;
	private JButton btnTransition;
	private JButton btnSelect;
	private JButton btnAddNote;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnCopy;
	private View view = View.getInstance();
	
	public PanelButton(AbstractSkinFactory skinFactory, JPanel panel){
		
		panel.setLayout(new GridLayout(0, 1, 1, 3));
		
		btnState = skinFactory.createButton("State");
		btnTransition = skinFactory.createButton("Transition");
		btnSelect = skinFactory.createButton("Select");
		btnAddNote = skinFactory.createButton("Add Note");
		btnDelete = skinFactory.createButton("Delete");
		btnEdit = skinFactory.createButton("Edit");
		btnCopy = skinFactory.createButton("Copy");
		
		panel.add(btnState);
		panel.add(btnTransition);
		panel.add(btnSelect);
		panel.add(btnAddNote);
		panel.add(btnDelete);
		panel.add(btnEdit);
		panel.add(btnCopy);
		
		btnState.addActionListener(new BtnStateListener());
		btnTransition.addActionListener(new BtnTransListener());
		btnSelect.addActionListener(new BtnSelectListener());
		btnAddNote.addActionListener(new BtnAddNoteListener());
		btnDelete.addActionListener(new DeleteListener());
		btnEdit.addActionListener(new EditListener());
		btnCopy.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        view.copyState();
		    }
		});
		
		view.registerButtonDelete(btnDelete);
		view.registerButtonEdit(btnEdit);
		view.registerButtonSelect(btnSelect);
		view.registerButtonAddNote(btnAddNote);
		view.registerButtonState(btnState);
		view.registerButtonTransition(btnTransition);
		view.registerButtonCopy(btnCopy);
		
		
	}
}
