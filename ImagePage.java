import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.lang.Process;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ImagePage extends JPanel implements Page{
  //FIELDS
  private static int HEIGHT;
  private static int WIDTH;
  private String imagePath;
  private BufferedImage profile;
  private Font headerFont;
  private Color headerColor = new Color(0,0,255);


  // CONSTRUCTOR
  public ImagePage(String imPath){
    // get fields from interface
    this.HEIGHT = Page.HEIGHT;
    this.WIDTH = Page.WIDTH;

    // get path from constructor
    this.imagePath = imPath;

    //get a BufferedImage from the image
    try{
      this.profile = ImageIO.read(new File(imagePath));

      //resize
      profile = resize(profile, 400, 400);

    }catch(IOException e){
      System.out.println(e);
    }

    // set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    //make a header
    this.headerFont = new Font("SansSerif", Font.BOLD, 30);

    //run python analysis
    this.runPython();

    this.readPython();

  }


  // HELPER METHODS
  private void runPython(){
    String command = "python3 faceRecog.py " + imagePath;
    try{
      Process p = Runtime.getRuntime().exec(command);
      System.out.println("ran process p");
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }

  private void readPython(){
    try{
      Scanner sc = new Scanner(new File("picData.txt"));
      //first count the lines so we know how big our file is

      System.out.println("lines are " + lines);
      String finalString = "";
      while(sc.hasNextLine()){
        String toAdd = sc.nextLine();
        System.out.println(toAdd);
        finalString += toAdd;
      }
      System.out.println(finalString);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }


  private static BufferedImage resize(BufferedImage img, int height, int width) {
    // resizes BufferedImage
    // code from:
    // https://memorynotfound.com/java-resize-image-fixed-width-height-example/

    Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

    BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = resized.createGraphics();

    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return resized;
  }


  public void paintComponent(Graphics g){
    //Draw the page
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    g.setColor(headerColor);
    g.fillRect(0, 0, WIDTH, 100);

    g.setColor(Color.WHITE);
    g.setFont(headerFont);
    g.drawString("~DistortMe~", WIDTH/2-80, 50);


    g.drawImage(profile, (WIDTH/2-400/2), (HEIGHT/2-400/2) + 40, this);

  }
}
