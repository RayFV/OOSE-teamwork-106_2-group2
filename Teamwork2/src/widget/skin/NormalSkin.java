package widget.skin;

import java.awt.Color;

import widget.widget.Button;
import widget.widget.Label;
import widget.widget.MenuBar;
import widget.widget.Panel;

public class NormalSkin implements WidgetSkin {
    public NormalSkin() {}

    @Override
    public void skinSetting(Button button) {
        button.setBackground(new Color(178, 190, 195));
		button.setForeground(new Color(12, 23, 22));
    }
    @Override
    public void skinSetting(Label label) {
        label.setForeground(new Color(12, 23, 22));
    }
    @Override
    public void skinSetting(MenuBar menuBar) {
        menuBar.setBackground(new Color(99, 110, 114));
    }
    @Override
    public void skinSetting(Panel panel) {
        panel.setBackground(new Color(99, 110, 114));
    }
}
