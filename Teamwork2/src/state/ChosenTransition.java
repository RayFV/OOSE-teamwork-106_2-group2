package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.Decorator;
import statediagram.StateDiagram;
import view.View;

public class ChosenTransition implements MouseState{
	//singleton
	private static ChosenTransition instance = null;
	private boolean PointCheck = false;
	private Component s1;
	private Component s2;
	private String text = "Transition";
	
	private ChosenTransition() {}

	public static ChosenTransition getInstance() {

		System.out.println("Curernt Mouse State: transition");
		if (instance == null) {
			instance = new ChosenTransition();
		}

		return instance;

	}

	@Override
	public void mouseClicked(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		this.clickedLoopCheck(vMdtr, sd, e);

		if (PointCheck) {
			vMdtr.addTranstion(e, s1, s2);
			PointCheck = false;

			vMdtr.changeState(ChosenSelect.getInstance());
		}
	}
	private void clickedCheck(View vMdtr, Component de, MouseEvent e) {
		if (de instanceof StateDiagram) {
			this.clickedLoopCheck(vMdtr, de, e);
		}
		else if (de instanceof Decorator) {
			this.clickedCheck(vMdtr, ((Decorator) de).getComponent(), e);
		}
		else {
			if (de.checkPoint(e.getPoint())) {
				if(s1 == null) {
					s1 = de;
					System.out.println("Clicked state 1: " + s1.getClassName());
				}
				else if(s1.getPoint() != de.getPoint()) {
					s2 = de;
					System.out.println("Clicked state 2: " + s2.getClassName());
					PointCheck = true;
				}
			}
		}
	}
	private void clickedLoopCheck(View vMdtr, Component sd, MouseEvent e) {
		for(Component de : sd.getComponentList()) {
			this.clickedCheck(vMdtr, de, e);
		}
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
