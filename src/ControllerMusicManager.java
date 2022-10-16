import java.awt.event.*;

import javax.swing.*;

public class ControllerMusicManager
	implements ActionListener
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	private ViewMusicManager view;
	private ModelMusicManager model;
	
	//COMPONENTS
	
	//CONSTRUCTORS
	public ControllerMusicManager(ViewMusicManager view, ModelMusicManager model)
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