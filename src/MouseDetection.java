import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseDetection extends MouseAdapter {
	final static int START_LOW_X = 48;
	final static int START_HIGH_X = 246;
	final static int START_LOW_Y = 350;
	final static int START_HIGH_Y = 426;

	final static int CONTROLS_LOW_X = 716;
	final static int CONTROLS_HIGH_X = 1040;
	final static int CONTROLS_LOW_Y = 350;
	final static int CONTROLS_HIGH_Y = 426;
	public void mousePressed(MouseEvent e) {
		//check CONTROLS button
		
		if(e.getX() > (CONTROLS_LOW_X) && e.getX() < (CONTROLS_HIGH_X) && e.getY() > (CONTROLS_LOW_Y) && e.getY() < (CONTROLS_HIGH_Y))
		{
			//System.out.println("Control pressed");
			Game.controlsFlag = true;
		}
		//check start button
		else if(e.getX() > (START_LOW_X) && e.getX() < (START_HIGH_X) && e.getY() > (START_LOW_Y) && e.getY() < (START_HIGH_Y))
		{
			//System.out.println("Start pressed");
			Game.gameFlag = true;
		}
	}
}
