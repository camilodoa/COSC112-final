//imports=======================================================================
import javax.swing.JPanel;
import java.util.Vector;
import java.awt.image.BufferedImage;
import java.awt.*;
//imports=======================================================================


public class Page extends JPanel{
  //fields
  static final int WIDTH=1024;
  static final int HEIGHT=580;
  static String imagePath;
  static Vector<Integer[]> coordinates;
  static boolean restart = false;
  static int downloadCounter = 0;


  static boolean showGreeting = true;
  static boolean showImage = false;
  static boolean showFinalImage = false;
  static boolean loading = false;

  //page state methods
  static void showGreetingToImage(){
    showGreeting = false;
    showImage = true;
  }
  static void imageToFinal(){
    showImage = false;
    showFinalImage = true;
  }


  //helper methods
  static void setImagePath(String s){
    imagePath = s;
  }

  static BufferedImage resize(BufferedImage img, int height, int width) {
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
}
