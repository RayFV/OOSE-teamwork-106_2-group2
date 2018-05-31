package abstractFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import widget.skin.NormalSkin;
import widget.skin.WidgetSkin;
import widget.widget.Button;
import widget.widget.Label;
import widget.widget.MenuBar;
import widget.widget.Panel;

public class NormalSkinFactory implements AbstractSkinFactory{
	private WidgetSkin normalSkin;
	public NormalSkinFactory() {
		this.normalSkin = new NormalSkin();
	}

	@Override
	public JButton createButton(String text) {
		return new Button(text, normalSkin);
	}

	@Override
	public JPanel createPanel() {
		return new Panel(normalSkin);
	}

	@Override
	public JLabel createLabel(String text) {
		return new Label(text, normalSkin);
	}

	@Override
	public JLabel createLabel(String text, int alignment) {
		return new Label(text, alignment, normalSkin);
	}

	@Override
	public JMenuBar createMenuBar() {
		return new MenuBar(normalSkin);
	}
	
}
