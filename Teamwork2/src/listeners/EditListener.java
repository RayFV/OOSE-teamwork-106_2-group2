package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class EditListener implements ActionListener{

	private View vMdtr = View.getInstance();

	
	public EditListener() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.editClick(e);
	}
}
