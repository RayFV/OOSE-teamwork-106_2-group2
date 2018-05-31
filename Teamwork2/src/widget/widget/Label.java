package widget.widget;

import javax.swing.JLabel;

import widget.skin.WidgetSkin;

public class Label extends JLabel implements Widget {
	private WidgetSkin skin;

    public Label(String text, WidgetSkin widgetSkin) {
		this.setText(text);
		this.setSkin(widgetSkin);
	}
	public Label(String text, int alignment, WidgetSkin widgetSkin) {
		this.setText(text);
		this.setHorizontalAlignment(alignment);
		this.setSkin(widgetSkin);
	}

    @Override
    public void setSkin(WidgetSkin widgetSkin) {
        this.skin = widgetSkin;
        this.skin.skinSetting(this);
    }
}
