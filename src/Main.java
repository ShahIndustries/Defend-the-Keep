import javax.swing.JFrame;
import java.awt.Container;

public class Main extends JFrame
{
 private static final long serialVersionUID = 1L;
 
 private final int FRAME_WIDTH = 1040;
    private final int FRAME_HEIGHT = 804;

    // This is the height of the title bar at the top of the frame
    public final static int TITLE_HEIGHT = 20;

    // Declare the Game
    private Game Game;
    private Container container;
 
    
    /**
     * Constructor of Main which creates the Game object
     */
    public Main(){
     Game = new Game(this);
     
        this.setTitle("Defend the Keep");           
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = this.getContentPane();       
        container.add(Game); // Adds Game        
        this.setVisible(true);
        setEnabled(true);
              
        try {
   Game.playGame(); // Start the game
  } 
        catch (InterruptedException e) {   
   e.printStackTrace();
  }
    }
    
    public static void main(String[] args) throws InterruptedException 
    {
     new Main();
    }
    
    public int getFrameHeight(){
     return FRAME_HEIGHT;
    }
    public int getFrameWidth(){
     return FRAME_WIDTH;
    }
    
}