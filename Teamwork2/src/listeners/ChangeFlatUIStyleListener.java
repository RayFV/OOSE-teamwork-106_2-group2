package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import strategy.FlatUI;
import view.View;

public class ChangeFlatUIStyleListener implements ActionListener{

	View vMdtr = View.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.changeGuiStrategy(new FlatUI());
	}

}
