package widget.button;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class NormalButton extends JButton{
	
	public NormalButton(String text) {
		super(text);
		this.setBackground(new Color(178, 190, 195));
		this.setForeground(new Color(12, 23, 22));
	}
	
	
}
