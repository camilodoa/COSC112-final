import javax.swing.JPanel;

public class Page extends JPanel{
  static final int WIDTH=1024;
  static final int HEIGHT=580;

  static boolean showGreeting = true;
  static boolean showImage = false;
  static boolean showFinalImage = false;

  static void showGreetingToImage(){
    showGreeting = false;
    showImage = true;
  }
  static void imageToFinal(){
    showImage = false;
    showFinalImage = true;
  }
  static void startOver(){
    showFinalImage = false;
    showGreeting = true;
  }
}
