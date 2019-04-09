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

public class GreetingPage extends JPanel implements Page{
  private static int HEIGHT;
  private static int WIDTH;

  public GreetingPage(){
    // get fields from interface
    this.HEIGHT = Page.HEIGHT;
    this.WIDTH = Page.WIDTH;

    //set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public void paintComponent(Graphics g){

  }

}
