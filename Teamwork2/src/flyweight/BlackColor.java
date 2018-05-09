package flyweight;

import java.awt.Color;

public class BlackColor implements ColorFlyweight{

	private int r = 0;
	private int g = 40;
	private int b = 40;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
