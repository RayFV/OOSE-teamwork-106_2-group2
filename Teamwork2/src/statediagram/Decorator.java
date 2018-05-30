package statediagram;

import java.awt.Graphics;

import memento.DecoratorStatusMemento;
import memento.ObjectStatusMemento;

public abstract class Decorator extends Component{
	Component component;
	
	public Decorator(Component component) {
		super();
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
	/**
	 * 將符合id的Component回傳
	 * @param id =要尋找的component的id
	 */
	public Component getComponent(int id) {
		if (component.getId() == id) {
			return component;
		}
		else {
			Component cc = component.getComponent(id);
			if (cc != null) {
				return cc;
			}
		}

		return null;
	}

	@Override
	public void restore(ObjectStatusMemento previousMemento) {
		super.restore(previousMemento);
		this.component = ((DecoratorStatusMemento) previousMemento).getComponent();
	}
}
