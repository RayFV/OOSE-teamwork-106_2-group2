package widget.widget;

import javax.swing.JMenuBar;

import widget.skin.WidgetSkin;

public class MenuBar extends JMenuBar implements Widget {
    private WidgetSkin skin;

    public MenuBar(WidgetSkin widgetSkin) {
        this.setSkin(widgetSkin);
    }

    @Override
    public void setSkin(WidgetSkin widgetSkin) {
        this.skin = widgetSkin;
        this.skin.skinSetting(this);
    }
}
