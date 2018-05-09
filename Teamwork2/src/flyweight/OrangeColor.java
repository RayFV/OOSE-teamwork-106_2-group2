package flyweight;

import java.awt.Color;

public class OrangeColor implements ColorFlyweight{

	private int r = 255;
	private int g = 165;
	private int b = 40;
	
	@Override
	public Color handle() {
		// TODO Auto-generated method stub
		return new Color(r, g, b);
	}

}
