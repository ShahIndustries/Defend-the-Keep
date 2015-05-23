import javax.swing.JFrame;
import java.awt.Color;

public class Main
{
    public final static int FRAME_WIDTH = 1040;
    public final static int FRAME_HEIGHT = 804;

    // This is the height of the title bar at the top of the frame
    public final static int TITLE_HEIGHT = 20;

    // Declare a bouncy ball object
    private static Game Game;

    public static void main(String[] args) 
    {
        // Create the bouncy ball game object
        Game = new Game();

        // Set up the JFrame. This is a container for our
        // game JPanel.
        JFrame j = new JFrame();
        j.setTitle("Defend the Keep");    
        j.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //j.setBackground(Color.BLACK);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the bouncy ball game object which is a JPanel
        j.add(Game);

        j.setVisible(true);

        attachShutDownHook();

        // Start the game
        Game.playGame();
        j.setSize(FRAME_WIDTH + 1, FRAME_HEIGHT + 1);
        j.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    // This will allow us to kill the sound nicely when the game exits.
    // *** Not working as intended right now ***
    public static void attachShutDownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
               Game.stopGame();
            }
        });
    }
}