import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MinimizeButton extends AbstractButton
{
	//CONSTANTS
	private static final Color COLOR_BORDERS = new Color(0, 180, 255);
	private static final Color COLOR_DEFAULT = new Color(0, 0, 0, 0);
	private static final Color COLOR_OVER = new Color(0, 40, 180);
	private static final Color COLOR_PRESSED = new Color(0, 120, 255);
	private static final Color COLOR_ICON = COLOR_BORDERS;
	private static final int BORDERS_THICKNESS = 1;
	
	//GLOBAL VARIABLES
	private Color colorIcon;
	private int iconSize;
	
	//CONSTRUCTORS
	public MinimizeButton()
	{
		super();
		
		colorBorders = COLOR_BORDERS;
		colorDefault = COLOR_DEFAULT;
		colorOver = COLOR_OVER;
		colorPressed = COLOR_PRESSED;
		colorBackground = colorDefault;
		colorIcon = COLOR_ICON;
		bordersThickness = BORDERS_THICKNESS;
		mouseOver = false;
		mousePressed = false;
		stateChanged = false;
		iconSize = 12;
		addMouseListener(this);
	}
	
	//GET
	public int getIconSize() { return iconSize; }
	public Color getColorIcon() { return colorIcon; }
	//SET
	public void setIconSize(int size) { iconSize = size; }
	public void setColorIcon(Color color) { colorIcon = color; }
	
	//OVERRIDES
	public void paintComponent(Graphics g)
	{
		RenderingHints qualityHints;
		
		//QUALITY
		qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		((Graphics2D)g).setRenderingHints(qualityHints);
		//BUTTON
		g.setColor(colorBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(colorBorders);
		for (int i = 0; i < bordersThickness; i++)
			g.drawRect(i, i, (getWidth() - i * 2 - 1), (getHeight() - i * 2 - 1));
		//ICON
		int x1, y1, x2, y2;

		g.setColor(colorIcon);
		x1 = (getWidth() / 2 - iconSize / 2);
		y1 = (getHeight() / 2);
		x2 = (getWidth() / 2 + iconSize / 2) - 1;
		y2 = (getHeight() / 2);
		g.drawLine(x1, y1, x2, y2);
	}
	
	//METHODS
    
	//IMPLEMENTS
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e)
	{
		if (isEnabled())
		{
			mouseOver = true;
			colorBackground = colorOver;
			repaint();
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if (isEnabled())
		{
			mouseOver = false;
			colorBackground = colorDefault;
			repaint();
		}
	}
	public void mousePressed(MouseEvent e)
	{
		if (isEnabled())
		{
			Thread thread;
			
			mousePressed = true;
			thread = new Thread()
			{
				public void run()
				{
					while (mousePressed)
					{
						if (mouseOver && !colorBackground.equals(colorPressed))
						{
							colorBackground = colorPressed;
							stateChanged = true;
						}
						else if (!mouseOver && !colorBackground.equals(colorDefault))
						{
							colorBackground = colorDefault;
							stateChanged = true;
						}
						if (stateChanged)
						{
							stateChanged = false;
							repaint();
						}
						try
						{
							Thread.sleep(3);
						} catch (Exception e) { e.printStackTrace(); }
					}
				}
			};
			thread.start();
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		if (isEnabled())
		{
			mousePressed = false;
			if (mouseOver)
			{
				fireActionPerformed();
				colorBackground = colorOver;
			}
			else
				colorBackground = colorDefault;
			repaint();
		}
	}
}