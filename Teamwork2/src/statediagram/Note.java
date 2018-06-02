package statediagram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
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
		setX(p.x + 30);
		setY(p.y + 30);
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
		
		g.setColor(new Color(255, 253, 227));
		
		((Graphics2D)g).setStroke(new BasicStroke(line));
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,		//�ϥΨ������ﵽ��ܽ�q
                RenderingHints.VALUE_ANTIALIAS_ON);

       // g.fillRect(getX(), getY(), width, height);
        g.setColor(getColor());
		g.drawRect(getX(), getY(), width, height);
		
		//Text
		FontMetrics fm = g.getFontMetrics();
		String texts = getText();
		System.out.println(texts);
		g.setColor(Color.black);
		int x;
		int y = (int)b.getY() + 2;
		for(String line :texts.split(";")) {
			System.out.println(line);
			double textWidth = fm.getStringBounds(line, g).getWidth();
			x = (int)((b.getX()+width/2-textWidth/2));
			y += 10;
			g.drawString(line, x, y);//�e��ron middle
		}
		
		
		//Line
		Point p1 = this.getPoint();
		Point p2 = super.component.getPoint();
		String p2Name = super.component.getClassName();
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(1));							
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);		
  
        g2.setPaint(getColor());
        
        double x1 = p1.x;													
        double y1 = p1.y;			
        double x2 = p2.x + Math.cos(Math.toRadians(getangles()));
        double y2 = p2.y;
        
        if(p1.x + this.width < p2.x ) {
    		x1 = p1.x + this.width;
    		x2 = p2.x;
    		if(p2.y < p1.y) {
        		y1 = p1.y;
        		y2 = p2.y + this.height;
        	}
        	else if( p1.y <= p2.y && p2.y <= p1.y + this.height)
        	{
            	y1 = p1.y + this.height / 2;
        		y2 = p2.y + this.height / 2;
        	}else{
        		y1 = p1.y + this.height;
        		y2 = p2.y;
        	}
        	if(p2Name.equals("State")) {
        		x2 = p2.x - 30 *  Math.cos(Math.toRadians(getangles()));
        	}
        }else if(p1.x + this.width >= p2.x && p2.x >= p1.x){
        	x1 = p1.x + this.width / 2;
        	x2 = p2.x + this.width / 2;
        	if(p2.y < p1.y)
        	{
            	y1 = p1.y;
            	y2 = p2.y + this.height;
        	}
        	else{
        		y1 = p1.y + this.height;
            	y2 = p2.y;
        	}
        	if(p2Name.equals("State")) {
            	x2 = p2.x + Math.cos(Math.toRadians(getangles()));
        	}
        }
        else if(p2.x < p1.x){
        	x1 = p1.x;
        	x2 = p2.x + this.width;
        	if(p2.y < p1.y) {
        		y1 = p1.y;
        		y2 = p2.y + this.height;
        	}
        	else if( p1.y <= p2.y && p2.y <= p1.y + this.height)
        	{
            	y1 = p1.y + this.height / 2;
        		y2 = p2.y + this.height / 2;
        	}else{
        		y1 = p1.y + this.height;
        		y2 = p2.y;
        	}
        	if(p2Name.equals("State")) {
            	x2 = p2.x + 30 *  Math.cos(Math.toRadians(getangles()));
        	}
        }

        if(p2Name.equals("State")) {
        	y2 = p2.y - 30 *  Math.sin(Math.toRadians(getangles()));
        }
        
        if(p2Name.equals("Transition")) {
        	x2 = p2.x;
        	y2 = p2.y;
        }
        
        line2D = new Line2D.Double(x1, y1, x2, y2); 
        g2.draw(line2D);
		

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
		setBoundary();
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
