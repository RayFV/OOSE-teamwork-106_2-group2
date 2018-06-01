package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import command.AddMementoCmd;
import command.RedoCmd;
import command.UndoCmd;
import mediator.ModelMediator;
import statediagram.Component;
import statediagram.Note;
import statediagram.State;
import statediagram.StateDiagram;
import statediagram.Transition;
import view.View;

public class Controller {
	View vMdtr = View.getInstance();
	ModelMediator mMdtr = ModelMediator.getInstance();
	
	public Controller() {
		mMdtr.setController(this);
		vMdtr.setController(this);
	}
	
	//*********************Diagram*********************//
	
	
	//Set Selected Component Text
	public void setComponentText(String text) {
		mMdtr.setComponentText(text, vMdtr.getSelectedItemID());
		vMdtr.setSelectedItemText();
		vMdtr.repaint();
	}

	//Get Selected Component Text
	public String getSelectedItemText() {
		return mMdtr.getSelectedItemText(vMdtr.getSelectedItemID());
	}
	

	//remove component from state diagram by ID
	public void removeComponent() {
		int selectedItemID = vMdtr.getSelectedItemID();
		if(selectedItemID != -1) {
			mMdtr.removeComponent(selectedItemID);
			vMdtr.setSelectedItemID(-1);
		}
		vMdtr.repaint();
	}

	public StateDiagram getStateDiagram() {
		// TODO Auto-generated method stub
		return mMdtr.getStateDiagram();
	}

	public Component getComponent(int id) {
        StateDiagram stateDiagram = mMdtr.getStateDiagram();
        return stateDiagram.getComponent(id);
    }

	
	//****************Memento****************//

    public void saveAction() {
        mMdtr.setCommand(new AddMementoCmd());
        mMdtr.doCommand();
        System.out.println("saveAction()");
    }

    public void detachAllSubject() {
        mMdtr.detachAllStateSubject();
        mMdtr.detachAllTransitionSubject();
    }
    private void restoreAction() {
        this.detachAllSubject();
        mMdtr.doCommand();
        mMdtr.fixTransitionRelationship();
        vMdtr.repaintWithoutSave();
    }
    public void undoAction() {
    	System.out.println("undoAction()");
        mMdtr.setCommand(new UndoCmd());
        restoreAction();
    }
    public void redoAction() {
        System.out.println("redoAction()");
        mMdtr.setCommand(new RedoCmd());
        restoreAction();
    }

    //********************************//

	public void setStateSubject(String color) {
		mMdtr.setStateSubject(color);
		vMdtr.repaint();
	}
	public void setTransitionSubject(String color) {
		mMdtr.setTransitionSubject(color);
		vMdtr.repaint();
	}

	public ArrayList<String> getColorStringList() {
		return mMdtr.getColorStringList();
	}
	

	public void changeColor(String color) {
		// TODO Auto-generated method stub
		int id = vMdtr.getSelectedItemID();
		mMdtr.changeColor(color, id);

		System.out.println(color + "   " + id);
	}
	
    /**
     * change a Component's color with another Component's color
     * @param changeC =which will change color
     * @param colorSource =color will same as this
     */
    public void changeComponentToSameColor(Component changeC, Component colorSource) {
        changeC.setColor(colorSource.getColor());
    }
    
    /**
     * create a new group
     * @param group =組別代號
     * @return new group
     */
    public Component addNewGroup(int group) {
        Component newGroup = mMdtr.newStateDiagram();
        newGroup.setGroup(group);
        mMdtr.addComponent(newGroup);

        return newGroup;
    }
    /**
     * create a new State
     * @return new State
     */
    public int addNewState(Point p) {
        Component newState = new State("", p);
        Component group1 = mMdtr.getGroup(1);
        group1.add(newState);
        this.changeComponentToSameColor(newState, group1);

        return newState.getId();
    }
    /**
     * create a new Transition
     * @return new Transition
     */
    public int addNewTransition(Point p, Component s1, Component s2) {
        Component newTransition = new Transition("", s1, s2);
        Component group1 = mMdtr.getGroup(1);
        group1.add(newTransition);
        this.changeComponentToSameColor(newTransition, group1);

        return newTransition.getId();
    }
    
	public int addNote(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		Component comp = this.getComponent(id);
		Component decorator = new Note("", comp.getPoint(), comp);
        Component group1 = mMdtr.getGroup(1);
        group1.add(decorator);
        mMdtr.removeComponent(id);
        System.out.println(decorator.getId());
		return decorator.getId();
    }
    
    public int copyState(int id) {
        System.out.println("copy item" + id);

        Component originState = mMdtr.getComponent(id);
        if (! (originState instanceof State)) {
            System.out.println("copy error: only can copy State!!");
            return -1;
        }
        State newState = ((State) originState).copy();
        newState.setId((new Date()).hashCode());
        mMdtr.getGroup(newState.getGroup()).add(newState);

        System.out.println("new item" + newState.getId());
        return newState.getId();
    }
    

    /**
     * change group
     * @param id =component's id which you want change group
     * @param newGroupNumber =it's new group number
     */
    public void changeGroup(int id, int newGroupNumber) {
        Component c = this.getComponent(id);
        int oldGroupNumber = c.getGroup();
        Component oldGroup = mMdtr.getGroup(oldGroupNumber);
        Component newGroup = mMdtr.getGroup(newGroupNumber);
        if (newGroup == null) {
            this.addNewGroup(newGroupNumber);
            newGroup = mMdtr.getGroup(newGroupNumber);
        }
        oldGroup.remove(id);
        newGroup.add(c);
        this.changeComponentToSameColor(c, newGroup);
        c.setGroup(newGroupNumber);
    }
    /**
     * change group's color
     * @param groupNumber =group's number
     * @param color =new color
     */
    public void changeGroupColor(int groupNumber, String color) {
    	System.out.println("controller.changeGroupColor");
        Component group = mMdtr.getGroup(groupNumber);
        group.changeColor(color);
    }

	public void changeStateSize(int size) {
		// TODO Auto-generated method stub
		mMdtr.changeSize(size, vMdtr.getSelectedItemID());
	}
	
    
    /**
     * get group list
     * @return a ArrayList<int> which have all group number
     */
    public ArrayList<Integer> getGroupList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        StateDiagram sd = mMdtr.getStateDiagram();
        for (Component c: sd.getComponentList()) {
            list.add(c.getGroup());
        }

        return list;
    }
    
    public int getGroupByID() {
		return mMdtr.getGroupByID(vMdtr.getSelectedItemID());
	}

}

