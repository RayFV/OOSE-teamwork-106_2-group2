package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class ChangeGroupColorListener implements ActionListener{

	private View vMdtr = View.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
    	vMdtr.changeGroupColor();
    }

}
