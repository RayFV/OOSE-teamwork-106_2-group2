package abstractFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public interface AbstractSkinFactory {
	JButton createButton(String text);
	JPanel createPanel();
	JLabel createLabel(String text);
	JLabel createLabel(String text, int aligment);
	JMenuBar createMenuBar();

}
