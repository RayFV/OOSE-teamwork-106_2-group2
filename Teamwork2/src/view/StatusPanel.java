package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import abstractFactory.AbstractSkinFactory;

public class StatusPanel{
	private JLabel posText;
	private JLabel coordX;
	private JLabel coordY ;
	private JLabel wall ; //區隔用
	private JLabel itemText;
	private JLabel selectedItem ;
	private JLabel wall2; //區隔用
	private JLabel stateText;
	private JLabel selectedState;
	
	private View mdtr = View.getInstance();

	public StatusPanel(AbstractSkinFactory skinFactory, JPanel panel) {
		
		posText = skinFactory.createLabel("Position: ");
		coordX = skinFactory.createLabel("0", JLabel.RIGHT);
		coordY = skinFactory.createLabel("0", JLabel.RIGHT);
		wall = skinFactory.createLabel("   ||   "); //區隔用
		itemText = skinFactory.createLabel("Selected Item: ");
		selectedItem = skinFactory.createLabel("None", JLabel.LEFT);
		wall2 = skinFactory.createLabel("   ||   "); //區隔用
		stateText = skinFactory.createLabel("Mouse State: ");
		selectedState = skinFactory.createLabel("Select", JLabel.LEFT);
		
		panel.setLayout(new FlowLayout());
		panel.add(posText);
		panel.add(coordX);
		panel.add(coordY);
		panel.add(wall);
		panel.add(itemText);
		selectedItem.setForeground(Color.red);
		panel.add(selectedItem);
		panel.add(wall2);
		panel.add(stateText);
		selectedState.setForeground(Color.red);
		panel.add(selectedState);
		mdtr.registerStatusPanel(this);
	}
	
	public void setCoordinates(int x, int y) {
		coordX.setText(Integer.toString(x));
		coordY.setText(Integer.toString(y));
	}
	
	public void setSelectedItem(String s) {
		selectedItem.setText(s);
	}
	
	public void setSelectedState(String s) {
		selectedState.setText(s);
	}
}
