package view;

import javax.swing.JButton;

public class ButtonTransition extends JButton{
	View mdtr = View.getInstance();
	public ButtonTransition(String name){
		super(name);
		mdtr.registerButtonTransition(this);
	}
}
