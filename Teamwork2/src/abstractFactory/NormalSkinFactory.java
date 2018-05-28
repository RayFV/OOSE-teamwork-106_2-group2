package abstractFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import widget.button.NormalButton;
import widget.label.NormalLabel;
import widget.menubar.NormalMenuBar;
import widget.panel.NormalPanel;

public class NormalSkinFactory implements AbstractSkinFactory{

	@Override
	public JButton createButton(String text) {
		// TODO Auto-generated method stub
		return new NormalButton(text);
	}

	@Override
	public JPanel createPanel() {
		// TODO Auto-generated method stub
		return new NormalPanel();
	}

	@Override
	public JLabel createLabel(String text) {
		// TODO Auto-generated method stub
		return new NormalLabel(text);
	}

	@Override
	public JLabel createLabel(String text, int aligment) {
		// TODO Auto-generated method stub
		return new NormalLabel(text, aligment);
	}

	@Override
	public JMenuBar createMenuBar() {
		// TODO Auto-generated method stub
		return new NormalMenuBar();
	}
	
}
