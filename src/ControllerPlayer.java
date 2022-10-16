import java.awt.event.*;

import javax.swing.*;

public class ControllerPlayer
	implements ActionListener
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	private ViewPlayer view;
	private ModelPlayer model;
	
	//COMPONENTS
	
	//CONSTRUCTORS
	public ControllerPlayer(ViewPlayer view, ModelPlayer model)
	{
		this.view = view;
		this.model = model;
	}
	
	//OVERRIDES
	public void actionPerformed(ActionEvent evt)
	{
		JComponent component;
		
		component = (JComponent)evt.getSource();
	}
	
	//METHODS
}