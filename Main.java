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


public class Main implements Page{

  public Main(){
    this.showGreeting = true;
    this.showImage = false;
    this.showFinalImage = false;
    this.WIDTH = Page.WIDTH;
    this.HEIGHT = Page.HEIGHT;
  }

  // state variables that lets app (Main) know where its at ===========================
  private boolean showGreeting;
  private boolean showImage;
  private boolean showFinalImage;
  // end of state variables ====================================================

  private static int HEIGHT;
  private static int WIDTH;

  // state change variables ====================================================
  private void showGreetingToImage(){
    this.showGreeting = false;
    this.showImage = true;
  }

  private void imageToFinal(){
    this.showImage = false;
    this.showFinalImage = true;
  }

  private void startOver(){
    this.showFinalImage = false;
    this.showGreeting = true;
  }
  // end of state change variables =============================================


  public static void main(String[] args){
    System.out.println("app time");

    JFrame appPage = new JFrame("DistortMe App");

    // Greeting page:
    // greeting page declaration here

    // Image edit page:
    String imPath = "./images/profile1.jpg"; //would get this from a GreetingPage method
    ImagePage imageInstance = new ImagePage(imPath);

    // Final image display page:
    // final image page declaration here

    //appPage.setContentPane();

    appPage.setContentPane(imageInstance);
    appPage.pack();
    appPage.setVisible(true);

  }
}
