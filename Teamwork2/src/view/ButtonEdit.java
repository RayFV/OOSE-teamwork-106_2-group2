package view;

import javax.swing.JButton;

public class ButtonEdit extends JButton{
	View mdtr = View.getInstance();
	public ButtonEdit(String name){
		super(name);
		mdtr.registerButtonEdit(this);
	}
}
