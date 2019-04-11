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
import java.awt.image.BufferedImage;
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GreetingPage extends JPanel implements Page{
  private static int HEIGHT;
  private static int WIDTH;
  private BufferedImage titleImage;

  public GreetingPage(){
    // get fields from interface
    this.HEIGHT = Page.HEIGHT;
    this.WIDTH = Page.WIDTH;

    // set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    // title image
    try {
      titleImage = ImageIO.read(getClass().getResourceAsStream("/images/FaceDisorter.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    // set background color
    g.setColor(new Color(25,25,112));
    g.fillRect(0,0,WIDTH,HEIGHT);

    // write title
    g.drawImage(titleImage, 50, 50, null);

    // make button
    g.setColor(new Color(124,252,0));
    boolean unclicked = true;
    g.draw3DRect(WIDTH/2,HEIGHT-300,300,150, unclicked);
    //g.fillOval(WIDTH/2,HEIGHT-300,200,200);

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
    g.drawString("To get started, click on the big green button to upload an image.",x_text,y_text+120);

  }    

  public static void main(String[] args) {
    JFrame welcome = new JFrame("Face Distorter 2000");
    welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    welcome.setContentPane(new GreetingPage());
    welcome.pack();
    welcome.setVisible(true);
  }

}
