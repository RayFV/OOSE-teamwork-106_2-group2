

import javax.swing.SwingUtilities;

import abstractFactory.CoolSkinFactory;
import abstractFactory.NormalSkinFactory;
import abstractFactory.Skin;
import controller.Controller;
import statediagram.Decorator;
import statediagram.Note;
import view.StateDiagramEditor;
import view.View;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	runApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
	}
	
	public static void runApp(){
        
		View view = View.getInstance();
		Controller controller = new Controller();

		//Get skin from Skin.txt
		String skin = Skin.getInstance().getSkin();
		if(skin.toLowerCase().equals("normal")) {
			view.setSkinFactory(new NormalSkinFactory());
		}else if(skin.toLowerCase().equals("cool")) {
			view.setSkinFactory(new CoolSkinFactory());
		}
		
		view.init();
		//view.initSettingComboBox();
        
    }
}
