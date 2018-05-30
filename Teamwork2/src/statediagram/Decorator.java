package statediagram;

import java.awt.Graphics;

import memento.DecoratorStatusMemento;
import memento.ObjectStatusMemento;

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

	public Component getComponent() {
		return this.component;
	}

	@Override
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);
		this.component = ((DecoratorStatusMemento) previousMemento).getComponent();
	}
}
