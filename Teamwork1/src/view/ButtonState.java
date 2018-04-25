package view;

import javax.swing.JButton;

public class ButtonState extends JButton{
	View mdtr = View.getInstance();
	public ButtonState(String name){
		super(name);
		mdtr.registerButtonState(this);
	}
}
