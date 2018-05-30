package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import abstractFactory.AbstractSkinFactory;

import javax.swing.text.AbstractDocument;

import listeners.ChangeGroupColorListener;

public class SettingPanel{

	JLabel lblGroup;
	JLabel lblGroupColor;
	JLabel lblStateColor;
	JLabel lblStateSize;
	JLabel lblTransitionColor;

	JTextField textFieldStateSize = new JTextField("0");
	
	JPanel panelGroup;
	JPanel panelTransition;
	JPanel panelState ;
	
	JButton addGroupButton;
	
	View vMdtr = View.getInstance();
	
	ArrayList<String> colors = vMdtr.getColorStringList();
	ArrayList<Integer> group = vMdtr.getGroupList();
	
	JComboBox comboComponentGroup = new JComboBox(group.toArray());
	JComboBox comboGroupColor = new JComboBox(colors.toArray());
	JComboBox comboStateColor = new JComboBox(colors.toArray());
	JComboBox comboTransitionColor = new JComboBox(colors.toArray());
	
	
	JLabel mouseXY = new JLabel("");

	private GridBagLayout gbl = new GridBagLayout();
	
	private JPanel panel;
	
	public SettingPanel(AbstractSkinFactory skinFactory, JPanel panel) {
		this.panel = panel;
		panel.setLayout(gbl);
		
		panelGroup = skinFactory.createPanel();
		panelTransition = skinFactory.createPanel();
		panelState = skinFactory.createPanel();
		
		lblGroup = skinFactory.createLabel("Group:");
		lblGroupColor = skinFactory.createLabel("Color");
		lblStateColor= skinFactory.createLabel("Color");
		lblStateSize = skinFactory.createLabel("Size");
		lblTransitionColor = skinFactory.createLabel("Color");
		
		addGroupButton = skinFactory.createButton("Add Group");
		
		Border bdr = BorderFactory.createEtchedBorder(Color.black,Color.black);
		Border titlebdr = BorderFactory.createTitledBorder(bdr, "Setting", 0, 0, null, Color.BLACK);
		panel.setBorder(titlebdr);

		panelGroup.setLayout(new GridLayout(3,1));
		panelState.setLayout(new GridLayout(2,1));
		panelTransition.setLayout(new GridLayout(1,1));
		
		panelGroup.setBorder(new TitledBorder(null, "Group", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelGroup.add(lblGroup);
		panelGroup.add(comboComponentGroup);
		//comboComponentGroup.setSelectedIndex(-1);
		panelGroup.add(lblGroupColor);
		panelGroup.add(comboGroupColor);
		//comboGroupColor.setSelectedIndex(-1);
		panelGroup.add(addGroupButton);
		panel.add(panelGroup);
		
		comboGroupColor.addActionListener (new ChangeGroupColorListener());
		
		addGroupButton.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        vMdtr.addNewGroup();
		    }
		});
		
		
		panelState.setBorder(new TitledBorder(null, "State", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelState.add(lblStateColor);
		panelState.add(comboStateColor);
		panelState.add(lblStateSize);
		panelState.add(textFieldStateSize);
		textFieldStateSize.setColumns(10);
		
		
	    panel.add(panelState);
		comboStateColor.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        vMdtr.setStateSubject(getStateSelectedColorText());
		    }
		});
		
		textFieldStateSize.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				  updateSize();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  updateSize();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  updateSize();
			  }
			
			  public void updateSize() {
				System.out.println("changed size: " + textFieldStateSize.getText());
				String text = textFieldStateSize.getText();
				int size;
				if(!text.equals("")) {
					size = Integer.parseInt(text);
				}else {
					size = 0;
				}
				vMdtr.changeStateSize(size);
			  }
		});
		
		panelTransition.setBorder(new TitledBorder(null, "Transition", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelTransition.add(lblTransitionColor);
		panelTransition.add(comboTransitionColor);
		panel.add(panelTransition);
		comboTransitionColor.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        vMdtr.setTransitionSubject(getTransSelectedColorText());
		    }
		});

		
		GridBagConstraints c = new GridBagConstraints();
		
		easyConstraints(c, gbl, panelGroup, 1, 1, 0, 0, 0.5, 1.0);
		easyConstraints(c, gbl, panelState, 1, 1, 0, 1, 0.5, 1.0);
		easyConstraints(c, gbl, panelTransition, 1, 1, 0, 2, 0.5, 1.0);
		c.weighty = 1.0;
		panel.add(Box.createVerticalGlue(), c);
		
		
		vMdtr.registerComboStateColor(comboStateColor);
		vMdtr.registerComboTransColor(comboTransitionColor);
		vMdtr.registerComboGroupColor(comboGroupColor);
		vMdtr.registerComboComponentGroup(comboComponentGroup);
	}
	
	private void easyConstraints(GridBagConstraints c, GridBagLayout gbl, JComponent comp, int w, int h, int x, int y, double wx, double wy) {
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.top = 3;
		c.insets.bottom = 0;
		c.gridwidth = w;
		c.gridheight = h;
		c.gridx = x;
		c.gridy = y;
		c.weightx = 0;
		c.weighty = 0;
		panel.add(comp, c);
	}
	
	
	public String getStateSelectedColorText() {
		return this.getStateSelectedColor().toString();
	}
	
	public Object getStateSelectedColor() {
		return this.comboStateColor.getSelectedItem();
	}
	
	public String getTransSelectedColorText() {
		return this.getTransSelectedColor().toString();
	}
	
	public Object getTransSelectedColor() {
		return this.comboTransitionColor.getSelectedItem();
	}
	
	public int getSelectedGroupText() {
		if(comboComponentGroup.getSelectedIndex() == -1)
			return 1;
		return Integer.parseInt(this.getSelectedGroup().toString());
	}
	
	public Object getSelectedGroup() {
		return this.comboComponentGroup.getSelectedItem();
	}
	
	public String getGroupSelectedColorText() {
		if(comboGroupColor.getSelectedIndex() == -1)
			return "black";
		return this.getGroupSelectedColor().toString();
	}
	
	public Object getGroupSelectedColor() {
		return this.comboGroupColor.getSelectedItem();
	}
}
