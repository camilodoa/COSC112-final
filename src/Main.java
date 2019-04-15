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

  public void run(){
    JFrame appPage = new JFrame("Face Distorter 2000");
    appPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Final image display page:
    // final image page declaration here

    // Greeting page:
    GreetingPage greetingInstance = new GreetingPage();

    appPage.setContentPane(greetingInstance);
    appPage.pack();
    appPage.setVisible(true);

    while(showImage!= true){
      try{
        Thread.sleep(500);
      }catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Image edit page:
    ImagePage imageInstance = new ImagePage();

    appPage.setContentPane(imageInstance);
    appPage.pack();
    appPage.setVisible(true);

    while(showFinalImage!= true){
      try{
        Thread.sleep(500);
      }catch (Exception e) {
        e.printStackTrace();
      }
    }

    //Initialize final page
    System.out.println("got to final page");
  }


  public static void main(String[] args){
    Main app = new Main();
    app.run();

  }
}
