package widget.label;

import java.awt.Color;

import javax.swing.JLabel;

public class CoolLabel extends JLabel{
	public CoolLabel(String text) {
		this.setText(text);
		this.setForeground(new Color(12, 23, 22));
	}
	
	public CoolLabel(String text, int alignment) {
		this.setText(text);
		this.setHorizontalAlignment(alignment);
		this.setForeground(new Color(12, 23, 22));
	}
}
