package view;

import javax.swing.JButton;

public class ButtonSelect extends JButton{
	View mdtr = View.getInstance();
	public ButtonSelect(String name){
		super(name);
		mdtr.registerButtonSelect(this);
	}
}
