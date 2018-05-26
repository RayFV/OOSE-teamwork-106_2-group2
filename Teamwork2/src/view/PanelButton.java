package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import listeners.DeleteListener;
import listeners.EditListener;
import listeners.BtnAddNoteListener;
import listeners.BtnSelectListener;
import listeners.BtnStateListener;
import listeners.BtnTransListener;

@SuppressWarnings("serial")
public class PanelButton extends JPanel{
	private JButton btnState;
	private JButton btnTransition;
	private JButton btnSelect;
	private JButton btnAddNote;
	private JButton btnDelete;
	private JButton btnEdit;
	private View view = View.getInstance();
	
	public PanelButton(){
		this.setLayout(new GridLayout(0, 1, 5, 5));
		
		btnState = new JButton("State");
		btnTransition = new JButton("Transition");
		btnSelect = new JButton("Select");
		btnAddNote = new JButton("Add Note");
		btnDelete = new JButton("Delete");
		btnEdit = new JButton("Edit");
		
		this.add(btnState);
		this.add(btnTransition);
		this.add(btnSelect);
		this.add(btnAddNote);
		this.add(btnDelete);
		this.add(btnEdit);
		
		btnState.addActionListener(new BtnStateListener());
		btnTransition.addActionListener(new BtnTransListener());
		btnSelect.addActionListener(new BtnSelectListener());
		btnAddNote.addActionListener(new BtnAddNoteListener());
		btnDelete.addActionListener(new DeleteListener());
		btnEdit.addActionListener(new EditListener());
		
		view.registerButtonDelete(btnDelete);
		view.registerButtonEdit(btnEdit);
		view.registerButtonSelect(btnSelect);
		view.registerButtonAddNote(btnAddNote);
		view.registerButtonState(btnState);
		view.registerButtonTransition(btnTransition);
		
		
	}
}
