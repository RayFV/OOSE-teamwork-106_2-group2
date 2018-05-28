package widget.label;

import java.awt.Color;

import javax.swing.JLabel;

public class NormalLabel extends JLabel{
	public NormalLabel(String text) {
		this.setText(text);
		this.setForeground(new Color(12, 23, 22));
	}
	
	public NormalLabel(String text, int alignment) {
		this.setText(text);
		this.setHorizontalAlignment(alignment);
		this.setForeground(new Color(12, 23, 22));
	}
}
