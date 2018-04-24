package strategy;

import java.awt.Color;
import java.util.Date;

public class DarkUI implements GuiStrategy{

	@Override
	public Color changeButton() {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis( );
		int red = (int)(now % 256);
		System.out.println("Button red color: " + red);
		return new Color(red, 96, 96);
	}

	@Override
	public Color changePanel() {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis( );
		int red = (int)(now % 256);
		System.out.println("Panel red color: " + red);
		return new Color(red, 32, 32);
	}

	@Override
	public Color changeButtonFont() {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis( );
		int red = (int)(now % 256);
		System.out.println("Button font red color: " + red);
		return new Color(red, 255, 255);
	}

}
