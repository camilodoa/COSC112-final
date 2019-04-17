import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;


public class FinalPage extends Page{
  private final String imageToEdit;

  public FinalPage(){
    this.imageToEdit = "../data/profile.png";
    //set screen size
    this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
  }

  /*
    need a method that reads in imageToEdit, changes it, and displays it
  */

  // private void rotateHead() throws Exception{
  //   BufferedImage toEdit = ImageIO.read(new File(imageToEdit));
  //
  //
  //   AffineTransform rotateCranium = new AffineTransform();
  //
  //   for(Integer[] coordinate : this.coordinates){
  //     rotateCranium.rotate(Math.PI/2, coordinate[]);
  //   }
  // }


  public void paintComponent(Graphics g){
    Font headerFont = new Font("SansSerif", Font.BOLD, 30);
    Color headerColor = new Color(0,0,255);

    //Background
    g.setColor(Color.WHITE);
    g.fillRect(0,0,WIDTH,HEIGHT);

    //Header
    g.setColor(headerColor);
    g.fillRect(0, 0, WIDTH, 100);
    g.setColor(Color.WHITE);
    g.setFont(headerFont);
    g.drawString("Face Distorter 2000", WIDTH/2-150, 50);

    //Image
    // g.drawImage(profile, (WIDTH/2-400/2), (HEIGHT/2-400/2) + 40, this);

  }
}
