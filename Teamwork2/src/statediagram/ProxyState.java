package statediagram;

import java.awt.Graphics;

public class ProxyState implements Circle{

	private State state;
	private boolean clicked;
	
	public ProxyState(){
		setClicked(false);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

}
