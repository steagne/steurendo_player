import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TitleBar
	extends JPanel
	implements ActionListener
{
	//CONSTANTS
	public static final int BUTTONS_WIDTH = 30;
	public static final int BUTTONS_HEIGHT = 24;
	public static final int ICON_SIZE = 16;
	
	//GLOBAL VARIABLES
	private JFrame view;
	private boolean hasIcon;
	
	//COMPONENTS
	private CloseButton buttonClose;
	private MaximizeButton buttonMaximize;
	private MinimizeButton buttonMinimize;
	private JLabel labelTitle;
	
	//CONSTRUCTORS
	public TitleBar(JFrame view)
	{
		super();
		
		this.view = view;
		
		init();
		initComponents();
		setComponentsListeners();
		addComponents();
		view.add(this);
	}
	
	//OVERRIDES
	public void actionPerformed(ActionEvent evt)
	{
		JComponent component;
		
		component = (JComponent)evt.getSource();
		if (component.getName().equals("buttonClose"))
			view.dispose();
		else if (component.getName().equals("buttonMaximize"))
		{
			view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		else if (component.getName().equals("buttonMinimize"))
		{
			view.setState(JFrame.ICONIFIED);
		}
		repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int k;
		
		init();
		g.setColor(buttonClose.getColorBorders());
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		k = 1;
		buttonClose.setBounds(getWidth() - BUTTONS_WIDTH, 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		if (buttonMaximize.isVisible())
			k++;
		buttonMaximize.setBounds(getWidth() - BUTTONS_WIDTH * k + (k - 1), 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		if (buttonMinimize.isVisible())
			k++;
		buttonMinimize.setBounds(getWidth() - BUTTONS_WIDTH * k + (k - 1), 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		labelTitle.setBounds((hasIcon ? ICON_SIZE + 16 : 8), 0, getWidth() - BUTTONS_WIDTH * 4, getHeight());
	}
	
	//METHODS
	private void init()
	{
		setLayout(null);
		setBounds(0, 0, view.getWidth(), BUTTONS_HEIGHT);
		setBackground(view.getBackground());
		
		hasIcon = false;
	}
	private void initComponents()
	{
		buttonClose = new CloseButton();
		buttonClose.setBounds(getWidth() - BUTTONS_WIDTH, 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		buttonClose.setName("buttonClose");
		buttonMaximize = new MaximizeButton();
		buttonMaximize.setBounds(getWidth() - BUTTONS_WIDTH * 2 + 1, 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		buttonMaximize.setName("buttonMaximize");
		buttonMinimize = new MinimizeButton();
		buttonMinimize.setBounds(getWidth() - BUTTONS_WIDTH * 3 + 2, 0, BUTTONS_WIDTH, BUTTONS_HEIGHT);
		buttonMinimize.setName("buttonMinimize");
		labelTitle = new JLabel(view.getTitle());
		labelTitle.setBounds((hasIcon ? ICON_SIZE + 16 : 8), 0, getWidth() - BUTTONS_WIDTH * 4, getHeight());
		labelTitle.setForeground(buttonClose.getColorBorders());
	}
	private void setComponentsListeners()
	{
		buttonClose.addActionListener(this);
		buttonMaximize.addActionListener(this);
		buttonMinimize.addActionListener(this);
	}
	private void addComponents()
	{
		add(buttonClose);
		add(buttonMaximize);
		add(buttonMinimize);
		add(labelTitle);
	}
	public void setIcon()
	{
	}
	public void maximizeButtonDisabled(boolean disabled)
	{
		buttonMaximize.setVisible(!disabled);
		repaint();
	}
	public void minimizeButtonDisabled(boolean disabled)
	{
		buttonMinimize.setVisible(!disabled);
		repaint();
	}
}