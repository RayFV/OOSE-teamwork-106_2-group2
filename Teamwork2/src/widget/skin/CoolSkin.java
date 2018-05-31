package widget.skin;

import java.awt.Color;

import widget.widget.Button;
import widget.widget.Label;
import widget.widget.MenuBar;
import widget.widget.Panel;

public class CoolSkin implements WidgetSkin {
    public CoolSkin() {}

    @Override
    public void skinSetting(Button button) {
        button.setBackground(new Color(228,241,254));
    }
    @Override
    public void skinSetting(Label label) {
        label.setForeground(new Color(12, 23, 22));
    }
    @Override
    public void skinSetting(MenuBar menuBar) {
        menuBar.setBackground(new Color(129, 207, 224));
    }
    @Override
    public void skinSetting(Panel panel) {
        panel.setBackground(new Color(129, 207, 224));
    }
}
