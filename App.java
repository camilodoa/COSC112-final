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

// Hello. Kelley was here.

public class App {

  public App(){
    this.showGreeting = true;
    this.showImage = false;
    this.showFinalImage = false;
  }

  // state variables that lets App know where its at ===========================
  private boolean showGreeting;
  private boolean showImage;
  private boolean showFinalImage;
  // end of state variables ====================================================


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
  }


}
