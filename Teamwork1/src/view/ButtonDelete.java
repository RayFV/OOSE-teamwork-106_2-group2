package view;

import javax.swing.JButton;

public class ButtonDelete extends JButton{
	View mdtr = View.getInstance();
	
	public ButtonDelete(String name){
		super(name);
		mdtr.registerButtonDelete(this);
	}
}
