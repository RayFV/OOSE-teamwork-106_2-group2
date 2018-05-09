package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import strategy.SomethingCool;
import view.View;


public class ChangeDarkUIStyleListener implements ActionListener{

	View vMdtr = View.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.changeGuiStrategy(new SomethingCool());
	}


}
