package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class ProxyState implements Circle{

	
	private float line;
	private int size;
	private int x;
	private int y;
	private boolean enable;
	//Singleton
	private static ProxyState instance = new ProxyState();
	
	private ProxyState() {
		setSize(50);
		line = 2.0f;
		enable = false;
	}
	
	public static ProxyState getInstance() {
		return instance;
	}
	
	public String getClassName() {
		return "Proxy State";
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		System.out.println("Drawing Proxy State");
		g.setColor(Color.GRAY);
		
		
		((Graphics2D)g).setStroke(new BasicStroke(line, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//�ϥΨ������ﵽ��ܽ�q
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawOval((int)(getX() - getSize()), (int)(getY() - getSize()), (int)Math.round(2.0*getSize()), (int)Math.round(2.0*getSize()));		//�e��
		g.setColor(new Color(0,0,0,0));	
        

	}

	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		System.out.println("Changing Proxy State point");
		setX((int)p.getX());
		setY((int)p.getY());
	}

	public void setEnable(boolean b) {
		// TODO Auto-generated method stub
		this.enable = b;
	}
	
	public boolean isEnable() {
		return this.enable;
	}
	
	private int getSize() {
		return size;
	}


	private void setSize(int size) {
		this.size = size;
	}
	

	private int getX() {
		return x;
	}


	private void setX(int x) {
		this.x = x;
	}


	private int getY() {
		return y;
	}


	private void setY(int y) {
		this.y = y;
	}


}
