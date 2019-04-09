import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FinalPage extends JPanel implements Page{
  private static int HEIGHT;
  private static int WIDTH;

  public FinalPage(){
    // get fields from interface
    this.HEIGHT = Page.HEIGHT;
    this.WIDTH = Page.WIDTH;

    //set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public void paintComponent(Graphics g){

  }
}
