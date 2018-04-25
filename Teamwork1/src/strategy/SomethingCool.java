package strategy;

import java.awt.Color;
import java.util.Date;

public class SomethingCool implements GuiStrategy{

	@Override
	public Color changeButton() {
		// TODO Auto-generated method stub
		Date now = new Date();
		//long now = System.currentTimeMillis( );
		int red = (int)(now.getTime() % 256);
		int green = (int)(now.getTime() % 130);
		int blue = (int)(now.getTime() % 130);
		System.out.println("Button red color: " + red);
		return new Color(red, green, blue);
	}

	@Override
	public Color changePanel() {
		// TODO Auto-generated method stub
		Date now = new Date();
		int red = (int)(now.getTime() % 256);
		System.out.println("Panel red color: " + red);
		return new Color(red, 32, 32);
	}

	@Override
	public Color changeButtonFont() {
		// TODO Auto-generated method stub
		Date now = new Date();
		int red = (int)(now.getTime() % 256);
		System.out.println("Button font red color: " + red);
		return new Color(red, 255, 255);
	}

}
