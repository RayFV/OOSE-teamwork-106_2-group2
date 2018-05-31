package widget.widget;

import javax.swing.JPanel;

import widget.skin.WidgetSkin;

public class Panel extends JPanel implements Widget {
    private WidgetSkin skin;

    public Panel(WidgetSkin widgetSkin) {
        this.setSkin(widgetSkin);
    }

    @Override
    public void setSkin(WidgetSkin widgetSkin) {
        this.skin = widgetSkin;
        this.skin.skinSetting(this);
    }
}
