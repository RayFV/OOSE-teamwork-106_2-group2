package flyweight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import mediator.ModelMediator;
import strategy.*;

// Color Strategy is flyweight
public class ColorFactory {
	private static ColorFactory instance = new ColorFactory();
	private HashMap<String, Color> ColorList = new HashMap<>();
	private Color result = null;
	private ArrayList<String> colorStringList = new ArrayList<String>();

	private ModelMediator mMdtr = ModelMediator.getInstance();

	public ColorFactory() {
		this.colorStringList.add("Black");
		this.colorStringList.add("MikuGreen");
		this.colorStringList.add("Yellow");
		this.colorStringList.add("Pink");
		this.colorStringList.add("Red");
		this.colorStringList.add("Blue");
		this.colorStringList.add("Orange");
	}

	public static ColorFactory getInstance() {
		return instance;
	}
	
	public ArrayList<String> getColorStringList() {
		return this.colorStringList;
	}
	

	public Color getColor(String color) {
		result = null;
		result = ColorList.get(color);

		if (result == null) {
			result = createNewColor(color);
			ColorList.put(color, result);
		}
		System.out.println(result.toString());
		return result;
	}

	public Color createNewColor(String color) {
		ColorFlyweight colorStrategy = null;
		switch (color.toLowerCase().trim()) {
			case "black":
				colorStrategy = new BlackColor();
				break;
			case "mikugreen":
				colorStrategy = new MikuGreenColor();
				break;
			case "yellow":
				colorStrategy = new YellowColor();
				break;
			case "pink":
				colorStrategy = new PinkColor();
				break;
			case "red":
				colorStrategy = new RedColor();
				break;
			case "blue":
				colorStrategy = new BlueColor();
				break;
			case "orange":
				colorStrategy = new OrangeColor();
				break;
			default:
				colorStrategy = new BlackColor();
				break;
		}
		result = colorStrategy.handle();

		return result;
	}
}
