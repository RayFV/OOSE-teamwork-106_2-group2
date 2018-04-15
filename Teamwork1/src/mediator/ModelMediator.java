package mediator;

import java.util.ArrayList;
import java.awt.Color;

import flyweight.ColorFactory;
import observer.Observer;
import statediagram.*;
import memento.*;
import observer.StateSubject;
import observer.TransitionSubject;
import view.StateDiagramEditor;

//I think this mediator is over

public class ModelMediator {
	private static final ModelMediator instance = new ModelMediator();
	private ModelMediator() {

	}
	public static ModelMediator getInstance() {
		return instance;
	}

	private StateDiagramEditor gui = new StateDiagramEditor();
	private MementoCaretaker mementoCaretaker = new MementoCaretaker();
	private StateDiagram stateDiagram = new StateDiagram();
	private StateSubject stateSubject = new StateSubject();
	private TransitionSubject transitionSubject = new TransitionSubject();
	private ColorFactory colorFactory;

	/****************************************/
	
    public Color getColorFromFactory(String color) {
        return this.colorFactory.getColor(color);
	}

	/****************************************/
	
	/**
	 * �Ыطs�� StateDiagram
	 * @return new StateDiagram()
	 */
	public StateDiagram newStateDiagram() {
		return new StateDiagram();
	}
	/**
	 * �Ыطs�� State
	 * @return new State()
	 */
	public State newState() {
		return new State();
	}
	/**
	 * �Ыطs�� Transition
	 * @return new Transition()
	 */
	public Transition newTransition() {
		return new Transition();
	}

	/**
	 * ���o���w��group
	 * @param group =group's number
	 * @return the group
	 */
	public Component getGroup(int group) {
		return this.stateDiagram.getGroup(group);
	}

	public void setStateDiagram(StateDiagram stateDiagram) {
		this.stateDiagram = stateDiagram;
	}

	public ObjectStatusMemento saveStateDiagram() {
		return this.stateDiagram.save();
	}
	public void restoreStateDiagram(ObjectStatusMemento previousMemento) {
		this.stateDiagram.restore(previousMemento);
	}

	public void stateDiagramAttachSubject() {
		this.stateDiagram.attachSubject();
	}

	/****************************************/

	public void addMemento(ObjectStatusMemento memento) {
		this.mementoCaretaker.addMemento(memento);
	}


	public boolean canUndo() {
        return this.mementoCaretaker.canUndo();
    }
	/**
     * �^�ǤW�@�B��Memento, ���s�b�ɷ|�^�ǳ̪쪺 (list[0])
     * @return �W�@�B��Memento
     */
	public ObjectStatusMemento undo() {
		return this.mementoCaretaker.undo();
	}


	public boolean canRedo() {
        return this.mementoCaretaker.canRedo();
    }
	/**
     * �^�ǤU�@�B��Memento, ���s�b�ɷ|�^�ǲ{�b�� (list[size()-1])
     * @return �U�@�B��Memento
     */
    public ObjectStatusMemento redo() {
		return this.mementoCaretaker.redo();
	}

	/****************************************/

	public void attachStateSubject(Observer observer) {
		this.stateSubject.attach(observer);
	}
	public void detachStateSubject(Observer observer) {
		this.stateSubject.detach(observer);
	}
	public void detachAllStateSubject() {
		this.stateSubject.detachAll();
	}

	public void attachTransitionSubject(Observer observer) {
		this.transitionSubject.attach(observer);
	}
	public void detachTransitionSubject(Observer observer) {
		this.transitionSubject.detach(observer);
	}
	public void detachAllTransitionSubject() {
		this.transitionSubject.detachAll();
	}
}