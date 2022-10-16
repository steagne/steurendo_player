import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Button extends AbstractButton
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	private String text;
	
	//COMPONENTS
	
	//CONSTRUCTORS
	public Button(String text)
	{
		super();
		
		this.text = text;
	}
	public Button() { this(""); }
	
	//OVERRIDES
	public void paintComponent(Graphics g)
	{
	}
	
	//METHODS
    public void addActionListener(ActionListener listener) { listenerList.add(ActionListener.class, listener); }
    public void removeActionListener(ActionListener listener) { listenerList.remove(ActionListener.class, listener); }
	protected void fireActionPerformed()
	{
        ActionListener[] listeners;
        
        listeners = listenerList.getListeners(ActionListener.class);
        if (listeners != null)
			if (listeners.length > 0)
				listeners[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    }
    
	//IMPLEMENTS
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
	}
}