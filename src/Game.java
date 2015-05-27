import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Bouncy ball is a JPanel and implements ActionListener for timer events
public class Game extends JPanel implements ActionListener, KeyListener
{
	// This is needed to get rid of the JPanel warning
	private static final long serialVersionUID = 1L;

	public boolean controlsFlag = false;
	public boolean gameFlag = false;
	public boolean menuFlag = false;
	public boolean GamePlaying = true;
	public boolean MusicPlaying = true;
	public static ImageIcon id;
	public static boolean IsOnTitleScreen = false;
	public static boolean IsOnControlScreen = false;
	public static boolean IsOnStartScreen = false;
	public MainGame start;
	private JLabel counter = new JLabel();
	private String x;
	int Score = 0;
	int imageX;
	int imageY;
	int imageX2;
	int imageY2;
	private boolean UpMove = false;
	private boolean DownMove = false;
	public boolean MainGame = false;

	private boolean active;
	private Image CompProject3;
	private Image CompProject2;
	private Image CompProject; //Background 
	@SuppressWarnings("unused")
	private int BackgroundX;
	@SuppressWarnings("unused")
	private int BackgroundY; 
	@SuppressWarnings("unused")
	private BackgroundMusic sap; // Declare a player for the background music
	private Main main;

	public Game(Main main){
		this.main = main;
		BackgroundX = (main.getFrameHeight());
		BackgroundY = (main.getFrameWidth());  
	}

	public void playGame() throws InterruptedException
	{

		active = true;

		// Create the Image from the file.
		id = new ImageIcon("CompProject.png");
		CompProject = id.getImage();
		IsOnTitleScreen = true;


		// These things need to be done as part of dealing with 
		// keyboard input. 'Focus' means that your application is
		// receiving the input and not some other application.
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		requestFocus();
		addMouseListener(new MouseDetection(this));
		main.setSize(BackgroundY + 1,BackgroundX + 1);
		main.setSize(BackgroundY, BackgroundX);

		// Start the background music

		sap = new BackgroundMusic("Music.wav");

		while(GamePlaying){
			System.out.print(controlsFlag);
			if(controlsFlag){
				IsOnTitleScreen = false;
				controlsFlag = false;
				IsOnControlScreen = true;
				ImageIcon id1 = new ImageIcon("Controls.png");
				CompProject = id1.getImage();
				imageX = 0;
				imageY = 0;
				System.out.println("triggered");

				this.repaint();
				super.repaint();

			}
			if(gameFlag){
				IsOnTitleScreen = false;
				gameFlag = false;
				IsOnStartScreen = true;
				ImageIcon id2 = new ImageIcon("GameBackground.png");
				CompProject = id2.getImage();
				imageX = 0;
				imageY = 0;
				System.out.println("triggered");

				//super.repaint();
				MainGame();
				//setVisible(true);
				//setEnabled(true);

				this.repaint();

			}
			if(menuFlag){
				IsOnControlScreen = false;
				menuFlag = false;
				IsOnTitleScreen = true;
				ImageIcon id = new ImageIcon("CompProject.png");
				CompProject = id.getImage();
				imageX = 0;
				imageY = 0;
				System.out.println("triggered");
				this.repaint();
				super.repaint();
			}
			
		}
	}

	public void stopGame()
	{
		active = false;
		//tm.stop();
	}
	public void MainGame(){
		MainGame = true;
		x = "Score : " + Integer.toString(Score);
		counter.setText(x);
		counter.setBounds(400, 11, 360, 60);
		counter.setFont(counter.getFont().deriveFont(55f));
		counter.setVisible(true);
		System.out.println(counter.getSize());
		this.add(counter);
		ImageIcon id2 = new ImageIcon("GameBackground.png");
		CompProject2 = id2.getImage();
	    ImageIcon id = new ImageIcon("Archer.png");
        CompProject = id.getImage();
        imageX = 886;
		imageY = 360;
	    ImageIcon id3 = new ImageIcon("Knight.png");
        CompProject3 = id3.getImage();
        imageX2 = 400;
		imageY2 = 400;
		System.out.println("Trig2");
		setVisible(true);
		setEnabled(true);
		System.out.println("Trig2");
		setVisible(true);
		setEnabled(true);
		update(getGraphics());
		repaint();
		System.out.println("In Run");
	}

	// This is the method that is called when the JPanel repaint method is called.
	public void paintComponent(Graphics g)
	{
		if(MainGame){
			System.out.println("test");

			// Calling the superclass method will essentially clear the panel
			// so that you can now put what you want.
			super.paintComponent(g);

			// This places an on the screen at the desired
			// position.
			g.drawImage(CompProject2, 0, 0, null);
			g.drawImage(CompProject, imageX, imageY, null);
			g.drawImage(CompProject3, imageX2, imageY2, null);

			// Need to cast the graphics object to a Graphics2D object
			//Graphics2D g2d = (Graphics2D) g;
		}
		else{
			System.out.println("test");

			// Calling the superclass method will essentially clear the panel
			// so that you can now put what you want.
			super.paintComponent(g);

			// This places an on the screen at the desired
			// position.
			g.drawImage(CompProject, imageX, imageY, null);

			// Need to cast the graphics object to a Graphics2D object
			//Graphics2D g2d = (Graphics2D) g;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (! active)
		{
			//sap.stopMusic();

		}
		else
		{

			System.out.println(UpMove);
			System.out.println(DownMove);
            // Move the rocket left if the left arrow is being pressed
            if (UpMove)
            {
                imageY-=5;
            }

            // Move the rocket right if the right arrow is being pressed
            if (DownMove)
            {
                imageY+=5;
            }

            // This will cause our paintComponent method to be called.
            repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void keyTyped(KeyEvent e) {
		// We don't need this because we use 'pressed' and 'released'
		// to track the keys.
	}


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Check if the left or right arrows were pressed so that we
        // will start moving the rocket
        if (key == KeyEvent.VK_UP) {
            UpMove = true;
            System.out.println(UpMove);
        }
        else if (key == KeyEvent.VK_DOWN) {
            DownMove = true;
            System.out.println(DownMove);
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // Check if the left or right arrows were released so that we
        // will stop moving the rocket
        if (key == KeyEvent.VK_UP) {
            UpMove = false;
            System.out.println(UpMove);
        }
        if (key == KeyEvent.VK_DOWN) {
            DownMove = false;
            System.out.println(DownMove);
        }
    }
}