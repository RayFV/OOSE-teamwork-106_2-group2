package state;

import java.awt.event.MouseEvent;

import memento.MementoCaretaker;
import statediagram.Component;
import statediagram.StateDiagram;
import view.View;

public class ChosenSelect implements MouseState{
	//singleton
	private static ChosenSelect instance = null;
	private boolean check = false;		//���F�P�O�ϥέ��ӥ\��A�קK�P��Ĳ�o
	private Component deCheck = null;
	private String text = "Select";
			
	private ChosenSelect() {}

	public static ChosenSelect getInstance() {
		System.out.println("Curernt Mouse State: select");
		if (instance == null) {
			instance = new ChosenSelect();
		}
		return instance;
	}

	@Override
	public void mouseClicked(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		this.pressedLoopCheck(vMdtr, sd, e);
		if(deCheck == null) {
			vMdtr.setSelectedItemID(-1);
		}
	}
	private void pressedLoopCheck(View vMdtr, Component sd, MouseEvent e) {
		for(Component de : sd.getComponentList()) {
			if (de instanceof StateDiagram) {
				this.pressedLoopCheck(vMdtr, de, e);
			}
			else {
				if(de.checkPoint(e.getPoint()) || de.checkLinePoint(e.getPoint())) {
					if(deCheck == null) {
						deCheck = de;
						System.out.println("Pressed item: " + deCheck.getClassName() + deCheck.getId());
					}
					vMdtr.setSelectedItemID(de.getId());
				}
			}
		}
	}

	@Override
	public void mouseReleased(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		deCheck = null;
		check = false;
	}

	@Override
	public void mouseDragged(View vMdtr, MouseEvent e) {
		// TODO Auto-generated method stub
		StateDiagram sd = vMdtr.getStateDiagram();
		this.draggedLoopCheck(vMdtr, sd, e);
	}
	private void draggedLoopCheck(View vMdtr, Component sd, MouseEvent e) {
		for(Component de : sd.getComponentList()) {
			if (de instanceof StateDiagram) {
				this.draggedLoopCheck(vMdtr, de, e);
			}
			else {
				if(!check) {
					if(de.checkPoint(e.getPoint())){
						check = true; //�u�P�_�Ĥ@����Ԧ�m�A���U�ӥu�n����}�ƹ����i�H�ưʪ���A���Z�ܦh
					}
				}
				if(deCheck == de) {
					vMdtr.changePoint(e, deCheck);
				}
			}
		}
	}

	@Override
	public String getMouseStateText() {
		// TODO Auto-generated method stub
		return text;
	}
	
}
