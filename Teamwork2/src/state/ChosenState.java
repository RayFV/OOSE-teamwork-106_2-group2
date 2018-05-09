package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;
import view.View;

public class ChosenState implements MouseState{
	//singleton
	private static ChosenState instance = null;
	private String text = "State";
	private ChosenState() {}

	public static ChosenState getInstance() {
		System.out.println("Curernt Mouse State: state");
		if (instance == null) {
			instance = new ChosenState();
		}
		return instance;
	}

	@Override
	public void mouseClicked(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		vMdtr.addState(e);
		vMdtr.changeState(ChosenSelect.getInstance());
	}

	@Override
	public void mousePressed(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMouseStateText() {
		// TODO Auto-generated method stub
		return text;
	}

}
