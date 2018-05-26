package statediagram;

import java.awt.Graphics;

public abstract class Decorator extends Component{
	Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	public void draw(Graphics g) {
		component.draw(g);
	}
	
	public String getClassName() {
		return component.getClassName() + " + ";
	}
}
