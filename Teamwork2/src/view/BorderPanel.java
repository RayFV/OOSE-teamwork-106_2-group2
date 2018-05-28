package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import abstractFactory.AbstractSkinFactory;

public class BorderPanel{
	
	private Border bdr;
	
	public BorderPanel(JPanel panel) {
		bdr = init(panel);
		panel.setBorder(bdr);
	}
	
	public BorderPanel(String text, JPanel panel) {
		bdr = init(panel);
		Border titlebdr = BorderFactory.createTitledBorder(bdr, text, 0, 0, null, Color.BLACK);
		panel.setBorder(titlebdr);
	}
	
	public Border init(JPanel panel) {
		panel.setLayout(new BorderLayout());
		Border bdr = BorderFactory.createEtchedBorder(Color.WHITE,Color.WHITE);
		return bdr;
	}
}
