package abstractFactory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import widget.button.CoolButton;
import widget.label.CoolLabel;
import widget.menubar.CoolMenuBar;
import widget.panel.CoolPanel;

public class CoolSkinFactory implements AbstractSkinFactory{

	@Override
	public JButton createButton(String text) {
		// TODO Auto-generated method stub
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
		
		if(icon != null) {
			label = new JLabel(icon);
			return new CoolButton(label);
		}
		return new CoolButton(text);
	}

	@Override
	public JPanel createPanel() {
		// TODO Auto-generated method stub
		return new CoolPanel();
	}

	@Override
	public JLabel createLabel(String text) {
		// TODO Auto-generated method stub
		return new CoolLabel(text);
	}

	@Override
	public JLabel createLabel(String text, int aligment) {
		// TODO Auto-generated method stub
		return new CoolLabel(text, aligment);
	}

	@Override
	public JMenuBar createMenuBar() {
		// TODO Auto-generated method stub
		return new CoolMenuBar();
	}

}
