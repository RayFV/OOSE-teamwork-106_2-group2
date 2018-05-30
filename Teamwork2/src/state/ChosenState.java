package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.Circle;
import statediagram.Component;
import statediagram.ProxyState;
import statediagram.State;
import statediagram.StateDiagram;
import view.View;

public class ChosenState implements MouseState{
	//singleton
	private static ChosenState instance = null;
	private String text = "State";
	private ChosenState() {}
	private static ProxyState proxyState = ProxyState.getInstance();

	public static ChosenState getInstance() {
		System.out.println("Curernt Mouse State: state");
		if (instance == null) {
			instance = new ChosenState();
		}

		proxyState.setEnable(true);
		return instance;
	}

	@Override
	public void mouseClicked(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		proxyState.setEnable(false);
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

	@Override
	public void mouseMove(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		proxyState.changePoint(e.getPoint());
		vMdtr.repaint();
	}

	@Override
	public void stateButtonClicked(View vMdtr) {
		// TODO Auto-generated method stub
	}

	@Override
	public void transButtonClicked(View vMdtr) {
		// TODO Auto-generated method st
		proxyState.setEnable(false);
		vMdtr.repaint();
		vMdtr.changeState(ChosenTransition.getInstance());
		
	}

	@Override
	public void selectButtonClicked(View vMdtr) {
		// TODO Auto-generated method stub
		proxyState.setEnable(false);
		vMdtr.repaint();
		vMdtr.changeState(ChosenSelect.getInstance());
	}

}
