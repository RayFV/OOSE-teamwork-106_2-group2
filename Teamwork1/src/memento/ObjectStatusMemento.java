package memento;

import java.awt.Color;
import java.util.*;


public class ObjectStatusMemento{
    private int id;
    private int group;
    private Color color;
    private float size;
    private String text;
    private int x;
    private int y;

    public ObjectStatusMemento(int id, int group, Color color, float size, String text, int x, int y){
        this.id = id;
        this.group = group;
        this.color = color;
        this.size = size;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public int getId(){
        return this.id;
    }

    public int getGroup() {
        return this.group;
    }

    public Color getColor() {
        return this.color;
    }

    public String getText() {
        return this.text;
    }

    public float getSize() {
        return this.size;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
