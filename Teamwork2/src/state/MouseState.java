package state;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;
import view.View;

public interface MouseState {
	public String getMouseStateText();
	public void mousePressed(View vMdtr, MouseEvent e);
	public void mouseReleased(View vMdtr, MouseEvent e);
	//public void mouseReleased(MouseEvent e, DrawDiagram d, AbstractFactory f, Caretaker c);
	public void mouseDragged(View vMdtr, MouseEvent e);
	public void mouseClicked(View vMdtr, MouseEvent e);
	public void mouseMove(View vMdtr, MouseEvent e);
	
	public void stateButtonClicked(View vMdtr);
	public void transButtonClicked(View vMdtr);
	public void selectButtonClicked(View vMdtr);
}

