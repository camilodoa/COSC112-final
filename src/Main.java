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


  public void run(JFrame app){ //=========================================================
    Page.restart = false;

    // Image edit page:
    ImagePage imageInstance = new ImagePage();
    app.setContentPane(imageInstance);
    app.pack();
    app.setVisible(true);

    while(showFinalImage!= true){
      try{
        Thread.sleep(500);
      }catch (Exception e) {
        e.printStackTrace();
      }
    }

    FinalPage finalInstance = new FinalPage();
    app.setContentPane(finalInstance);
    app.pack();
    app.setVisible(true);

    while(Page.restart!= true){
      try{
        Thread.sleep(500);
      }catch (Exception e) {
        e.printStackTrace();
      }
      if(Page.restart == true){
        Page.restart = false;
        Page.showFinalImage = false;
        Page.showGreeting = false;
        Page.showImage = true;

        run(app);
      }
    }
  }//run()======================================================================

  public static void main(String[] args){//=====================================
    Main app = new Main();
    JFrame appPage = new JFrame("Face Distorter 2000");
    appPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appPage.setResizable(false);


    // Pages:
    GreetingPage greetingInstance = new GreetingPage();

    //greetingInstance
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

    app.run(appPage);
  }//Main()=====================================================================

}
