import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;

// Bouncy ball is a JPanel and implements ActionListener for timer events
public class Game extends JPanel implements ActionListener, KeyListener
{
	// This is needed to get rid of the JPanel warning
	private static final long serialVersionUID = 1L;


	// Declare a player for the background music
	private Sounds sap;


	//Background
	private int BackgroundX = (Main.FRAME_WIDTH);
	private int BackgroundY = (Main.FRAME_HEIGHT);
	// 48, 50   246, 426
	//716, 358   1020, 422


	private Image CompProject;

	private boolean active;
	public static boolean controlsFlag = false;
	public static boolean gameFlag = false;
	public boolean GamePlaying = true;
	public boolean MusicPlaying = true;

	public void playGame() throws InterruptedException
	{

		active = true;

		// Create the Image from the file.

		ImageIcon id = new ImageIcon("CompProject.png");
		CompProject = id.getImage();

		// These things need to be done as part of dealing with 
		// keyboard input. 'Focus' means that your application is
		// receiving the input and not some other application.
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		requestFocus();
		addMouseListener(new MouseDetection());
        Main.j.setSize(Main.FRAME_WIDTH + 1, Main.FRAME_HEIGHT + 1);
        Main.j.setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);

		// Start the background music

		sap = new Sounds("Music.wav");


		while(GamePlaying){
			if(!(sap.playing)){
				//Thread.sleep(1000);
				sap =  new Sounds("Music.wav");

			}
			if(controlsFlag){
				controlsFlag = false;
				ImageIcon id1 = new ImageIcon("Controlls.png");
				CompProject = id.getImage();
				System.out.println("triggered");
				this.repaint();
			}
			if(gameFlag){
				gameFlag = false;
				ImageIcon id2 = new ImageIcon("Start.png");
				CompProject = id.getImage();
				System.out.println("triggered");
				this.repaint();
			}
		}
	}

	public void stopGame()
	{
		active = false;
		//tm.stop();
	}

	// This is the method that is called when the JPanel repaint method is called.
	public void paintComponent(Graphics g)
	{
		System.out.println("test");
		
		// Calling the superclass method will essentially clear the panel
		// so that you can now put what you want.
		super.paintComponent(g);

		// This places an on the screen at the desired
		// position.
		g.drawImage(CompProject, 0, 0, this);

		// Need to cast the graphics object to a Graphics2D object
		Graphics2D g2d = (Graphics2D) g;

	}

	public void actionPerformed(ActionEvent e)
	{
		if (! active)
		{
			//sap.stopMusic();

		}
		else
		{

			//repaint();
		}
	}



	public void mouseReleased(MouseEvent e) {

	}

	public void keyTyped(KeyEvent e) {
		// We don't need this because we use 'pressed' and 'released'
		// to track the keys.
	}


	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}