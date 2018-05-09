package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import listeners.MousePositionsListener;
import listeners.MyMouseListener;
import mediator.ModelMediator;
import statediagram.Component;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;

public class DrawCanvas extends JPanel{
	View vMdtr = View.getInstance();
	private Component components;
	private float radius = 10;
	
	public DrawCanvas() {
		this.setBackground(Color.white);
		vMdtr.registerDrawCanvas(this);

		this.addMouseMotionListener(new MousePositionsListener());
		this.addMouseListener(new MyMouseListener());
	}
	public void paintComponent(Graphics g) {
		System.out.println("DrawCanvas.paintComponent()");
		components = vMdtr.getStateDiagram();
		super.paintComponent(g);

		System.out.println(components.getColor().toString());
		
		components.draw(g);
	}
	
}
