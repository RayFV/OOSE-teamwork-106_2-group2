package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import memento.NoteStatusMemento;
import memento.ObjectStatusMemento;

public class Note extends Decorator{
	private Rectangle b;
	private float line;
	private int width;
	private int height;
	private Line2D line2D;

	public Note() {
		super(null);
	}
	
	public Note(String text, Point p, Component comp) {
		super(comp);
		setText(text);
		setPoint(p);
		setX(p.x);
		setY(p.y);
		width = 200;
		height = 100;
		line = 2;
		setBoundary();
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		drawNote(g);
	}
	
	private void drawNote(Graphics g) {
		setBoundary();
		
		g.setColor(getColor());
		
		((Graphics2D)g).setStroke(new BasicStroke(line));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//�ϥΨ������ﵽ��ܽ�q
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawRect(getX(), getY(), width, height);
		
		Point p1 = this.getPoint();
		Point p2 = super.component.getPoint();
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));							//�u���ʲ�
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);		//�ϥΨ������ﵽ��ܽ�q
  
        g2.setPaint(getColor());
        
        double x;													//�N�����ন���צA�i��p��Ap1�Mp2�p��ۤϡA���̵u�Z��
        double y = p1.y + 30 *  Math.sin(Math.toRadians(getangles()));		
        double x2;
        double y2 = p2.y - 30 *  Math.sin(Math.toRadians(getangles()));
        
        if(p1.x < p2.x) {
        	x = p1.x + 30 *  Math.cos(Math.toRadians(getangles()));
        	x2 = p2.x - 30 *  Math.cos(Math.toRadians(getangles()));
        }
        else {
        	x = p1.x - 30 *  Math.cos(Math.toRadians(getangles()));
        	x2 = p2.x + 30 *  Math.cos(Math.toRadians(getangles()));
        }
        
        line2D = new Line2D.Double(x, y, x2, y2); 
        g2.draw(line2D);
        
        int xm = (int)((x + x2) / 2);
        int ym = (int)((y + y2) / 2);
        g2.setPaint(Color.black);
        g2.drawString(this.getText(), xm, ym);		//�u���W��
		
		
	}
	
	public double getangles()		//�p����I��������
	{
		Point p1 = this.getPoint();
		Point p2 = super.component.getPoint();
		
	    double x = p2.x - p1.x;
	    double y = p2.y - p1.y;    
	    double z = Math.sqrt(x * x + y * y);	    
	    double angle = (Math.asin(y / z) / Math.PI * 180);

	    return angle;
	}

	public void setBoundary() {
		b = new Rectangle();
        b.setBounds(getX(), getY(), width, height);
    }
	
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return super.getClassName() + "Note";
	}

	@Override
	public void attachSubject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkPoint(Point p) {
		// TODO Auto-generated method stub
		return this.b.contains(p);
	}

	@Override
	public boolean checkLinePoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePoint(Point p) {
		// TODO Auto-generated method stub
		this.setPoint(p);
		this.setX((int)p.getX());
		this.setY((int)p.getY());
	}


	@Override
	public ObjectStatusMemento save() {
		return new NoteStatusMemento(this.getClassName(), this.getId(), this.getGroup(), this.getColor(),
			this.getSize(), this.getText(), this.getX(), this.getY(), this.getPoint(),
			this.getComponent(), b, line, width, height, line2D
		);
	}

	@Override
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);
		this.b = ((NoteStatusMemento) previousMemento).getB();
		this.line = ((NoteStatusMemento) previousMemento).getLine();
		this.width = ((NoteStatusMemento) previousMemento).getWidth();
		this.height = ((NoteStatusMemento) previousMemento).getHeight();
		this.line2D = ((NoteStatusMemento) previousMemento).getLine2D();
	}
}
