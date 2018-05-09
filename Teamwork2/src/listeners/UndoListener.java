package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class UndoListener implements ActionListener{
	
	private View vMdtr = View.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.undoClick(e);
		//vMdtr.repaint();
	}

}