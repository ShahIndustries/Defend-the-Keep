import javax.swing.JFrame;

import java.awt.Color;

public class Main
{
    public final static int FRAME_WIDTH = 1040;
    public final static int FRAME_HEIGHT = 804;

    // This is the height of the title bar at the top of the frame
    public final static int TITLE_HEIGHT = 20;

    // Declare the Game
    private Game Game;
    public static JFrame j;
    
    /**
     * Constructor of Main which creates the Game object
     */
    public Main(){
    	Game = new Game();
    	j = new JFrame();
        j.setTitle("Defend the Keep");    
        j.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //j.setBackground(Color.BLACK);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adds Game
        j.add(Game);
        j.setVisible(true);
       // attachShutDownHook();
        // Start the game
        try {
			Game.playGame();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) throws InterruptedException 
    {
    	new Main();
    }
}