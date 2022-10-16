import java.awt.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ViewPlayer
	extends JFrame
	implements Observer
{
	//CONSTANTS
	public final static String WINDOW_TITLE = "Steurendo's Player";
	public final static int WINDOW_WIDTH = 400;
	public final static int WINDOW_HEIGHT = 500;
	
	//GLOBAL VARIABLES
	private ModelPlayer model;
	private ControllerPlayer controller;
	
	//COMPONENTS
	private TitleBar titleBar;
	
	//CONSTRUCTORS
	public ViewPlayer()
	{
		init();
		initComponents();
		setComponentsListeners();
		addComponents();
	}
	
	//OVERRIDES
	
	//GET-SET
	
	//METHODS
	private void init()
	{
		Container container;
		
		model = new ModelPlayer(this);
		controller = new ControllerPlayer(this, model);

		container = this.getContentPane();
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container.setBackground(Constants.COLOR_BACKGROUND);
		setUndecorated(true);
		setBackground(new Color(Constants.COLOR_BACKGROUND.getRed(),
				Constants.COLOR_BACKGROUND.getGreen(),
				Constants.COLOR_BACKGROUND.getBlue(),
				Constants.COLORS_ALPHA));
	}
	private void initComponents()
	{
		titleBar = new TitleBar(this);
	}
	private void setComponentsListeners()
	{
	}
	private void addComponents()
	{
		add(new JLabel());
	}
	
	public void start()
	{
		setVisible(true);
	}

	@Override
	public void update(Observable observable, Object obj)
	{
	}
}