package widget.widget;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import widget.skin.WidgetSkin;

public class Button extends JButton implements Widget {
	private WidgetSkin skin;

    public Button(String text, WidgetSkin widgetSkin) {
		super(text);
		this.setSkin(widgetSkin);
	}
	public Button(JLabel label, WidgetSkin widgetSkin) {
		super("");
		this.setSkin(widgetSkin);
		this.setLayout(new BorderLayout());
		this.add(label);
	}

    @Override
    public void setSkin(WidgetSkin widgetSkin) {
		this.skin = widgetSkin;
        this.skin.skinSetting(this);
    }
}
