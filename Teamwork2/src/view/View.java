package view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import abstractFactory.AbstractSkinFactory;
import abstractFactory.NormalSkinFactory;
import abstractFactory.Skin;
import controller.Controller;
import state.ChosenSelect;
import state.ChosenState;
import state.ChosenTransition;
import state.MouseState;
import statediagram.Circle;
import statediagram.Component;
import statediagram.StateDiagram;
import strategy.FlatUI;
import strategy.GuiStrategy;

public class View {

	//Singleton with Eager initialization 
	private static View vMdtr = new View();
	private Controller controller;
	private GuiStrategy guiStrategy;

	private StateDiagramEditor mainFrame;
	private AbstractSkinFactory skinFactory;
	
	//Declare
	private JButton buttonState;
	private JButton buttonSelect;
	private JButton buttonTransition;
	private JButton buttonAddnote;
	private JButton buttonDelete;
	private JButton buttonEdit;

	private DrawCanvas drawCanvas;
	private MouseState currentState = ChosenSelect.getInstance(); //singleton
	private StatusPanel statusPanel;
	
	private EditDialog eDialog;
	private JComboBox eDialogCbColor;
	private JComboBox eDialogCbGroup;
	private JTextField eDialogTextFieldName;

	private JMenuItem menuOpen;
	private JMenuItem menuSave;
	private JMenuItem menuExit;
	private JMenuItem menuDelete;
	private JMenuItem menuModify;
	private JMenuItem menuUndo;
	private JMenuItem menuRedo;

	private int selectedItemID = -1;
	
	private SettingPanel settingPanel;
	private JComboBox settingCbStateColor;
	private JComboBox settingCbTransColor;
	private JComboBox settingCbGroupColor;
	private JComboBox settingCbGroup;
	private boolean pressedOK;
	

	private View() {
		guiStrategy = new FlatUI();
	}
	
	public static View getInstance() {
		return vMdtr;
	}
	
	public void init() {
		mainFrame = new StateDiagramEditor(skinFactory);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}


	public void setController(Controller controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}
	
	//**************Register****************//
	public void registerButtonState(JButton bState) {
		// TODO Auto-generated method stub
		this.buttonState = bState;
	}

	public void registerButtonSelect(JButton bSelect) {
		// TODO Auto-generated method stub
		this.buttonSelect = bSelect;
	}

	public void registerButtonAddNote(JButton btnAddNote) {
		// TODO Auto-generated method stub
		this.buttonAddnote = btnAddNote;
	}
	
	public void registerButtonTransition(JButton bTransition) {
		// TODO Auto-generated method stub
		this.buttonTransition = bTransition;
	}

	public void registerButtonDelete(JButton bDelete) {
		// TODO Auto-generated method stub
		this.buttonDelete = bDelete;
	}
	
	public void registerButtonEdit(JButton bEdit) {
		this.buttonEdit = bEdit;
	}
	
	public void registerDrawCanvas(DrawCanvas drawCanvas) {
		// TODO Auto-generated method stub
		this.drawCanvas = drawCanvas;
	}
	
	public void registerStatusPanel(StatusPanel sp) {
		// TODO Auto-generated method stub
		this.statusPanel = sp;
	}

	public void registerEditStateDialog(EditDialog editStateDialog) {
		// TODO Auto-generated method stub
		this.eDialog = editStateDialog;
	}

	public void registerMenuOpen(JMenuItem menuItemOpen) {
		// TODO Auto-generated method stub
		this.menuOpen = menuItemOpen;
	}

	public void registerMenuSave(JMenuItem menuItemSave) {
		// TODO Auto-generated method stub
		this.menuSave = menuItemSave;
	}

	public void registerMenuExit(JMenuItem menuItemExit) {
		// TODO Auto-generated method stub
		this.menuExit = menuItemExit;
	}

	public void registerMenuDelete(JMenuItem menuItemDelete) {
		// TODO Auto-generated method stub
		this.menuDelete = menuItemDelete;
	}

	public void registerMenuModify(JMenuItem menuItemModify) {
		// TODO Auto-generated method stub
		this.menuModify = menuItemModify;
	}

	public void registerMainFrame(StateDiagramEditor sde) {
		// TODO Auto-generated method stub
		this.mainFrame = sde;
	}
	
	public void registerMenuUndo(JMenuItem menuItemUndo) {
		// TODO Auto-generated method stub
		this.menuUndo = menuItemUndo;
	}

	public void registerMenuRedo(JMenuItem menuItemRedo) {
		// TODO Auto-generated method stub
		this.menuRedo = menuItemRedo;
	}
	

	public void registerSettingPanel(SettingPanel settingPanel) {
		// TODO Auto-generated method stub
		this.settingPanel = settingPanel;
	}
	

	public void registerEditStateDialogComboColor(JComboBox cbColor) {
		// TODO Auto-generated method stub
		this.eDialogCbColor = cbColor;
	}

	public void registerEditStateDialogComboGroup(JComboBox cbGroup) {
		// TODO Auto-generated method stub
		this.eDialogCbGroup = cbGroup;
	}

	public void registerEditStateDialogTextFieldName(JTextField textFieldName) {
		// TODO Auto-generated method stub
		this.eDialogTextFieldName = textFieldName;
	}
	
	public void registerComboStateColor(JComboBox comboStateColor) {
		// TODO Auto-generated method stub
		this.settingCbStateColor = comboStateColor;
	}

	public void registerComboTransColor(JComboBox comboTransitionColor) {
		// TODO Auto-generated method stub
		this.settingCbTransColor = comboTransitionColor;
	}

	public void registerComboGroupColor(JComboBox comboGroupColor) {
		// TODO Auto-generated method stub
		this.settingCbGroupColor = comboGroupColor;
	}

	public void registerComboComponentGroup(JComboBox comboComponentGroup) {
		// TODO Auto-generated method stub
		this.settingCbGroup = comboComponentGroup;
	}
	
	/*****************/
	/*  Action Event */
	/*****************/
	public void transClick(ActionEvent e) {
		currentState.transButtonClicked(this);
		this.setSelectedItemID(-1);
		System.out.println("trans btn clicked");
	}
	
	public void stateClick(ActionEvent e) {
		currentState.stateButtonClicked(this);
		this.setSelectedItemID(-1);
		System.out.println("state btn clicked");
	}
	
	public void selectClick(ActionEvent e) {
		currentState.selectButtonClicked(this);
		System.out.println("select btn clicked");
	}
	

	public void addNoteClick(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Add note btn clicked");
		int id = controller.addNote(getSelectedItemID());
		this.setSelectedItemID(id);
		this.showDialog();
		this.repaint();
		this.setSelectedItemID(-1);
	}
	
	public void editClick(ActionEvent e) {
		System.out.println("Edit btn clicked");
		if(getSelectedItemID() != -1) {
			showDialog();
		}
	}
	
	public void deleteClick(ActionEvent e) {
		System.out.println("Delete btn clicked");
		this.removeComponent();
	}
	
	
	/*********/
	
	//Change mouse state and update status
	public void changeState(MouseState newState) {
		currentState = newState;
		setSelectedStateText(currentState.getMouseStateText());
	}

	// return current chosen mouse state
	public MouseState getCurrentState() {
		return currentState;
	}
	
	//****************Status************//
	//update mouse position
	public void setCoordinates(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mouseMove(this, e);
		statusPanel.setCoordinates(e.getX(), e.getY());
	}
	
	//update selected item status
	public void setSelectedItemText() {
		String Text = "None";
		if(selectedItemID != -1) {
			Text = this.getSelectedItemText();
		}
		statusPanel.setSelectedItem(Text);
	}
	
	//update chosen state status (ex. State, Transition and Select)
	public void setSelectedStateText(String text) {
		statusPanel.setSelectedState(text);
	}
	
	//*********************Diagram*********************//
	
	//draw State
	public void addState(MouseEvent e) {
		int id = controller.addNewState(e.getPoint());
		this.setSelectedItemID(id);
		this.showDialog();
		this.repaint();
	}
	
	// draw transition
	public void addTranstion(MouseEvent e, Component s1, Component s2) {
		int id = controller.addNewTransition(e.getPoint(), s1, s2);
		this.setSelectedItemID(id);
		this.showDialog();
		this.repaint();
	}
	
	//Set Selected Component Text
	public void setComponentText(String text) {
		controller.setComponentText(text);
	}

	//Get Selected Component Text
	public String getSelectedItemText() {
		return controller.getSelectedItemText();
	}

	//record selected(clicked) component ID
	public void setSelectedItemID(int id) {
		this.selectedItemID = id;
		setSelectedItemText();

		buttonRefresh();
	}
	
	//get selected(clicked) component ID
	public int getSelectedItemID() {
		return this.selectedItemID;
	}

	//remove component from state diagram by ID
	public void removeComponent() {
		controller.removeComponent();
	}
	
	public StateDiagram getStateDiagram() {
		return controller.getStateDiagram();
	}
	
	
	//**************Mouse Event***********//
	public void mouseClicked(MouseEvent e) {
		currentState.mouseClicked(this, e);
	}
	
	public void mouseDragged(MouseEvent e) {

		System.out.println("testingasdasd");
		currentState.mouseDragged(this, e);
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mousePressed(this, e);
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mouseReleased(this, e);
	}

	//Change Position and repaint when drag the component
	public void changePoint(MouseEvent e, Component comp) {
		// TODO Auto-generated method stub
		comp.changePoint(e.getPoint());
		repaint();
	}
	
	//***************Edit Dialog***************//
	//show up the edit dialog
	public void showDialog() {
		if(eDialog == null) {
			eDialog = new EditDialog(skinFactory);
			this.refreshColorComboBoxItem(eDialogCbColor, getColorStringList());
		}
		this.eDialogTextFieldName.setText(getSelectedItemText());
		this.refreshGroupComboBoxItem(eDialogCbGroup, getGroupList());
		this.eDialogCbGroup.setSelectedItem((Integer)getGroupByID());
		eDialog.showDialog();
	}
	
	public void closeMainFrame() {
		mainFrame.dispose();
	}

	//*********Draw Canvas****************//
	public void repaint() {
		drawCanvas.repaint();
		controller.saveAction();
	}
	public void repaintWithoutSave() {
		drawCanvas.repaint();
	}

	public void undoClick(ActionEvent e) {
		// TODO Auto-generated method stub
		controller.undoAction();
	}
	public void redoClick(ActionEvent e) {
		controller.redoAction();
	}

	public void setComponentColor(Object selectedItem) {
		// TODO Auto-generated method stub
		controller.changeColor(selectedItem.toString());
	}
	
	public void setStateSubject(String color) {
		controller.setStateSubject(color);
	}
	public void setTransitionSubject(String color) {
		controller.setTransitionSubject(color);
	}

	public ArrayList<String> getColorStringList() {
		return controller.getColorStringList();
	}


	public void changeStateSize(int size) {
		// TODO Auto-generated method stub
		controller.changeStateSize(size);
		repaint();
	}

	public void buttonRefresh() {
		// TODO Auto-generated method stub
		if(this.selectedItemID != -1) {
			this.buttonAddnote.setEnabled(true);
			this.buttonDelete.setEnabled(true);
			this.buttonEdit.setEnabled(true);
			this.menuDelete.setEnabled(true);
			this.menuModify.setEnabled(true);
		}
		else {
			this.buttonAddnote.setEnabled(false);
			this.buttonDelete.setEnabled(false);
			this.buttonEdit.setEnabled(false);
			this.menuDelete.setEnabled(false);
			this.menuModify.setEnabled(false);
		}
	}

	public ArrayList<Integer> getGroupList() {
		// TODO Auto-generated method stub
		return controller.getGroupList();
	}

	public void addNewGroup() {
		// TODO Auto-generated method stub
		controller.addNewGroup(getGroupList().size()+1);
		refreshGroupComboBoxItem(settingCbGroup, getGroupList());
	}

	public void copyState() {
		controller.copyState(getSelectedItemID());
	}
	
	public void refreshGroupComboBoxItem(JComboBox cb, ArrayList<Integer> list) {
		cb.removeAllItems();
		for(int i =0; i < list.size();i++) {
			cb.addItem(list.get(i));
		}
	}
	
	public void refreshColorComboBoxItem(JComboBox cb, ArrayList<String> list) {
		cb.removeAllItems();
		for(int i =0; i < list.size();i++) {
			cb.addItem(list.get(i));
		}
	}
	
	public int getGroupByID() {
		System.out.println("Group ID: " +controller.getGroupByID());
		return controller.getGroupByID();
	}

	public void setComponentGroup(Object selectedGroup) {
		// TODO Auto-generated method stub
		controller.changeGroup(getSelectedItemID(), Integer.parseInt(selectedGroup.toString()));
	}
	
	public void changeGroupColor() {
		// TODO Auto-generated method stub
		int group = settingPanel.getSelectedGroupText();
		String color = settingPanel.getGroupSelectedColorText();
		System.out.println("vMdtr.changeGroupColor  " + group + color);
		controller.changeGroupColor(group, color);
		repaint();
	}

	public void changeGuiStrategy(GuiStrategy s) {
		this.guiStrategy = s;
		handleGuiStrategy();
	}
	
	public void handleGuiStrategy() {
		this.buttonDelete.setBackground(guiStrategy.changeButton());
		this.buttonEdit.setBackground(guiStrategy.changeButton());
		this.buttonSelect.setBackground(guiStrategy.changeButton());
		this.buttonState.setBackground(guiStrategy.changeButton());
		this.buttonTransition.setBackground(guiStrategy.changeButton());
		
		this.buttonDelete.setForeground(guiStrategy.changeButtonFont());
		this.buttonEdit.setForeground(guiStrategy.changeButtonFont());
		this.buttonSelect.setForeground(guiStrategy.changeButtonFont());
		this.buttonState.setForeground(guiStrategy.changeButtonFont());
		this.buttonTransition.setForeground(guiStrategy.changeButtonFont());
		
		//this.settingPanel.setBackground(guiStrategy.changePanel());
		
	}

	public void setSkinFactory(AbstractSkinFactory skinFactory) {
		// TODO Auto-generated method stub
		this.skinFactory = skinFactory;
	}


}
