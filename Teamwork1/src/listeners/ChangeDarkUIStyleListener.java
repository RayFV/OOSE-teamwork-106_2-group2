package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mediator.ViewMediator;
import strategy.DarkUI;


public class ChangeDarkUIStyleListener implements ActionListener{

	ViewMediator vMdtr = ViewMediator.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.changeGuiStrategy(new DarkUI());
	}


}
