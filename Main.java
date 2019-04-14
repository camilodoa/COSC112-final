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

    // Greeting page:
    GreetingPage greetingInstance = new GreetingPage();

    appPage.setContentPane(greetingInstance);
    appPage.pack();
    appPage.setVisible(true);

    while(showImage!= true){
      try{
        Thread.sleep(1000);
      }catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Image edit page:
    ImagePage imageInstance = new ImagePage();

    appPage.setContentPane(imageInstance);
    appPage.pack();
    appPage.setVisible(true);

  }
}
