import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.Image;

import javax.swing.ImageIcon;
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
 
 private boolean active;
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
    System.out.println("triggered");
    start = new MainGame(this);
    setVisible(true);
    setEnabled(true);
    this.add(start);
    this.repaint();
    super.repaint();
    
   }
   if(menuFlag){
    IsOnControlScreen = false;
    menuFlag = false;
    IsOnTitleScreen = true;
    ImageIcon id = new ImageIcon("CompProject.png");
    CompProject = id.getImage();
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

 // This is the method that is called when the JPanel repaint method is called.
 public void paintComponent(Graphics g)
 {
  System.out.println("test");
  
  // Calling the superclass method will essentially clear the panel
  // so that you can now put what you want.
  super.paintComponent(g);

  // This places an on the screen at the desired
  // position.
  g.drawImage(CompProject, 0, 0, null);

  // Need to cast the graphics object to a Graphics2D object
  //Graphics2D g2d = (Graphics2D) g;

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