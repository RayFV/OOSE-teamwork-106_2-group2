package view;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;

import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import abstractFactory.AbstractSkinFactory;
import net.miginfocom.swing.MigLayout;
import strategy.FlatUI;
import strategy.GuiStrategy;

import java.awt.SystemColor;

@SuppressWarnings("serial")
public class StateDiagramEditor extends JFrame{
	
	private View view = View.getInstance();
	
    private PanelButton panelButtonBuilder;
    private BorderPanel borderPanelBuilder;
    private SettingPanel settingPanelBuilder;
    private StatusPanel statusPanelBuilder;
    
    private JPanel left;
    private JPanel panelButton;
    private JPanel borderPanel;
    private JPanel settingPanel;
    private JPanel statusPanel;
    
	/**
	 * Create the application.
	 */
	public StateDiagramEditor(AbstractSkinFactory skinFactory) {
		initialize(skinFactory);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(AbstractSkinFactory skinFactory) {
		setTitle("State Diagram Editor");
		getContentPane().setBackground(SystemColor.controlShadow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
		
		left = skinFactory.createPanel();
		left.setLayout(new BorderLayout(5, 2));

		panelButton = skinFactory.createPanel();
		panelButtonBuilder = new PanelButton(skinFactory, panelButton);
		
		borderPanel = skinFactory.createPanel();
		borderPanelBuilder = new BorderPanel("State Diagram", borderPanel);
		
		DrawCanvas canvas = new DrawCanvas();
		
		settingPanel = skinFactory.createPanel();
		settingPanelBuilder = new SettingPanel(skinFactory, settingPanel);
		
		statusPanel = skinFactory.createPanel();
		statusPanelBuilder = new StatusPanel(skinFactory, statusPanel);
		
		borderPanel.add(canvas, BorderLayout.CENTER);
		
		canvas.setPreferredSize(new Dimension(800, 600));
		borderPanel.add(statusPanel, BorderLayout.SOUTH);
		getContentPane().add(borderPanel, BorderLayout.CENTER);
		left.add(panelButton, BorderLayout.NORTH);
		left.add(settingPanel, BorderLayout.CENTER);
		getContentPane().add(left, BorderLayout.WEST);
		
		//Menu Bar
		JMenuBar menuBar = skinFactory.createMenuBar();
		MenuBar menuBarBuilder = new MenuBar(menuBar);
		this.setJMenuBar(menuBar);

		view.registerMainFrame(this);
		view.buttonRefresh();
		view.registerSettingPanel(settingPanelBuilder);
		
	}
}
