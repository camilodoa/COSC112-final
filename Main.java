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

    // Final image display page:
    // final image page declaration here

    while(true){
      if (showGreeting == true){
        // Greeting page:
        GreetingPage greetingInstance = new GreetingPage();

        appPage.setContentPane(greetingInstance);
        appPage.pack();
        appPage.setVisible(true);
      }else if(showImage == true){
        // Image edit page:
        ImagePage imageInstance = new ImagePage();
        
        appPage.setContentPane(imageInstance);
        appPage.pack();
        appPage.setVisible(true);
      }
    }
  }
}
