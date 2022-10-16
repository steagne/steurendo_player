import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ViewMusicManager
	extends JFrame
	implements Observer
{
	//CONSTANTS
	public final static String WINDOW_TITLE = "Steurendo's Music Manager";
	public final static int WINDOW_WIDTH = 400;
	public final static int WINDOW_HEIGHT = 500;
	
	//GLOBAL VARIABLES
	private ModelMusicManager model;
	private ControllerMusicManager controller;
	
	//COMPONENTS
	private TitleBar titleBar;
	
	//CONSTRUCTORS
	public ViewMusicManager()
	{
		init();
		initComponents();
		setComponentsListeners();
		addComponents();
	}
	
	//OVERRIDES
	@Override
	public void update(Observable observable, Object obj)
	{
	}
	
	//GET-SET
	
	//METHODS
	private void init()
	{
		Container container;
		
		model = new ModelMusicManager(this);
		controller = new ControllerMusicManager(this, model);

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
		titleBar.maximizeButtonDisabled(true);
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
}