package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class RedoListener implements ActionListener{
	
	private View vMdtr = View.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vMdtr.redoClick(e);
	}

}
