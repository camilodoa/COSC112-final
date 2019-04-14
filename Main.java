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


public class Main extends Page{

  public Main(){

  }


  public static void main(String[] args){
    System.out.println("app time");

    JFrame appPage = new JFrame("DistortMe App");

    // Greeting page:
    // greeting page declaration here

    // Image edit page:
    String imPath = "./images/julian.jpg"; //would get this from a GreetingPage method
    ImagePage imageInstance = new ImagePage(imPath);

    // Final image display page:
    // final image page declaration here

    //appPage.setContentPane();

    appPage.setContentPane(imageInstance);
    appPage.pack();
    appPage.setVisible(true);

  }
}
