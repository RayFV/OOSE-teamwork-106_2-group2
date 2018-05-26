

import javax.swing.SwingUtilities;

import controller.Controller;
import statediagram.Decorator;
import statediagram.Note;
import view.StateDiagramEditor;

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
        StateDiagramEditor stateDiagramEditor = new StateDiagramEditor();
        stateDiagramEditor.pack();
        stateDiagramEditor.setLocationRelativeTo(null);
        Controller ctrl = new Controller();
        ctrl.settingColor();
        //view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        stateDiagramEditor.setVisible(true);
        
    }
}
