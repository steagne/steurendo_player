import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public abstract class AbstractButton
	extends JComponent
	implements MouseListener
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	protected Color colorBackground;
	protected Color colorBorders;
	protected Color colorDefault;
	protected Color colorOver;
	protected Color colorPressed;
	protected int bordersThickness;
	protected boolean mousePressed;
	protected boolean mouseOver;
	protected boolean stateChanged;
	
	//OVERRIDES
	public abstract void paintComponent(Graphics g);
	
	//GET
	public Color getColorBorders() { return colorBorders; }
	public Color getColorDefault() { return colorDefault; }
	public Color getColorOver() { return colorOver; }
	public Color getColorPressed() { return colorPressed; }
	public int getBordersThickness() { return bordersThickness; }
	//SET
	public void setColorBorders(Color color) { colorBorders = color; }
	public void setColorDefault(Color color) { colorDefault = color; }
	public void setColorOver(Color color) { colorOver = color; }
	public void setColorPressed(Color color) { colorPressed = color; }
	public void setBordersThickness(int bordersThickness) { this.bordersThickness = bordersThickness; }
	
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
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mouseEntered(MouseEvent e);
	public abstract void mouseExited(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
}