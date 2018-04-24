package flyweight;

import java.awt.Color;

public class PinkColor implements ColorFlyweight{

	private int r = 255;
	private int g = 192;
	private int b = 203;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
