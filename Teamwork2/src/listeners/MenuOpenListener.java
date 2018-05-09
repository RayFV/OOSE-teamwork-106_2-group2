package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.View;

public class MenuOpenListener implements ActionListener{
	private View vMdtr = View.getInstance();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		vMdtr.openFileBtnClicked();
	}

}
