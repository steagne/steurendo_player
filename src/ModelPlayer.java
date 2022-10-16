import java.util.*;

public class ModelPlayer extends Observable
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	private ViewPlayer view;
	
	//COMPONENTS
	
	//CONSTRUCTORS
	public ModelPlayer(ViewPlayer view)
	{
		this.view = view;
		addObserver(view);
	}
	
	//OVERRIDES
	
	//METHODS
}