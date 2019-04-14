
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import javafx.stage.FileChooser;
import javax.swing.JButton;

// WHAT YOU NEED TO STILL IMPLEMENT:
// 1. Ability to click on a button (MouseListener), which opens up file browser
// 2. Select a file, which will be passed on to the next step


public class GreetingPage extends Page { //ActionListener
  //private BufferedImage titleImage;

  //private final JFileChooser fc = new JFileChooser();



  public GreetingPage(){

    // set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    /*
    // title image
    try {
      titleImage = ImageIO.read(this.getClass().getResourceAsStream("images/FaceDisorter.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    */

  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    // set background color
    g.setColor(new Color(25,25,112));
    g.fillRect(0,0,WIDTH,HEIGHT);

    // write title
    //g.drawImage(titleImage, 50, 50, 100, 100, null);
    g.setColor(Color.WHITE);
    g.drawString("FACE DISTORER 2000",50,50);

    // make description
    g.setColor(Color.WHITE);
    int x_text = 100;
    int y_text = 100;
    g.drawString("Welcome to the Face Distorter 2000 program.",x_text,y_text);
    g.drawString("You will first be prompted to upload an image that includes a face.",x_text,y_text+20);
    g.drawString("Then, you will be asked to identify the location of the face,",x_text,y_text+40);
    g.drawString("as well as eyes and mouth, using your mouse or trackpad.",x_text,y_text+60);
    g.drawString("Afterwards, you will be able to distort the face via a number of selections.",x_text,y_text+80);
    g.drawString("You will then be provided with the distorted image and options to save.",x_text,y_text+100);

    // first instructions
    g.setColor(new Color(124,252,0));
    g.drawString("To get started, click on the button to upload an image.",x_text,y_text+120);

  }

  public static void main(String[] args) {
    JFrame welcome = new JFrame("Face Distorter 2000");
    welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    welcome.setContentPane(new GreetingPage());
    welcome.pack();
    welcome.setVisible(true);

    JButton b = new JButton("Select .jpg");
    b.setBounds(100, 100, 50, 50);
    welcome.add(b);

    ActionListener a = new ActionListener();
    b.addActionListener(a);


    // JFileChooser fc = new JFileChooser();
    // IF (event 'clicked button' occurs) {
    //    fc.showOpenDialog(FileChooserDEMO.this);
    //    File jpg = fc.getSelectedFile();
    //
    //}


    //int i = fc.showOpenDialog(welcome);

  }

}
