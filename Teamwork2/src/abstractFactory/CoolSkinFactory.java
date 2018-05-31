package abstractFactory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import widget.skin.CoolSkin;
import widget.skin.WidgetSkin;
import widget.widget.Button;
import widget.widget.Label;
import widget.widget.MenuBar;
import widget.widget.Panel;

public class CoolSkinFactory implements AbstractSkinFactory{
	private WidgetSkin coolSkin;
	public CoolSkinFactory() {
		this.coolSkin = new CoolSkin();
	}

	@Override
	public JButton createButton(String text) {
		String path = "Skin/coolSkin/";
		Icon icon = null;
		JLabel label;
		
		String text_ = text.toLowerCase();
		
		//to get Icon
		if(text_.equals("state")) {
			icon = new ImageIcon(path+"circle.png");
		}else if(text_.equals("transition")) {
			icon = new ImageIcon(path+"transition.png");
		}else if(text_.equals("select")) {
			icon = new ImageIcon(path+"select.png");
		}
		
		Button newButton = null;
		if(icon != null) {
			label = new JLabel(icon);
			newButton = new Button(label, coolSkin);
		}
		else {
			newButton = new Button(text, coolSkin);
		}

		return newButton;
	}

	@Override
	public JPanel createPanel() {
		return new Panel(coolSkin);
	}

	@Override
	public JLabel createLabel(String text) {
		return new Label(text, coolSkin);
	}

	@Override
	public JLabel createLabel(String text, int alignment) {
		return new Label(text, alignment, coolSkin);
	}

	@Override
	public JMenuBar createMenuBar() {
		return new MenuBar(coolSkin);
	}
}
