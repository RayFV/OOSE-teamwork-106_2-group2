package widget.button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CoolButton extends JButton{
	public CoolButton(String text) {
		super(text);
		this.setBackground(new Color(228,241,254));
	}
	
	public CoolButton(JLabel label) {
		super("");
		this.setBackground(new Color(228,241,254));
		this.setLayout(new BorderLayout());
		this.add(label);
	}
	
}
