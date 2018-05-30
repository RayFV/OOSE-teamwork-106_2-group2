package memento;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import statediagram.Component;

public class NoteStatusMemento extends DecoratorStatusMemento {
    private Rectangle b;
	private float line;
	private int width;
	private int height;
    private Line2D line2D;
    public NoteStatusMemento(String className, int id, int group,
        Color color, float size, String text, int x, int y, Point p,
        Component component,
        Rectangle b, float line, int width, int height, Line2D line2D
    ) {
        super(className, id, group, color, size, text, x, y, p, component);
        this.b = b;
        this.line = line;
        this.width = width;
        this.height = height;
        this.line2D = line2D;
    }

    public Rectangle getB() {
        return this.b;
    }
    public float getLine() {
        return this.line;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public Line2D getLine2D() {
        return this.line2D;
    }
}
