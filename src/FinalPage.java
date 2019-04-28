import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;


public class FinalPage extends Page{
  private final String imageToEdit;
  private final String editedImage;

  public FinalPage(){
    try{
      BufferedImage profileToEdit = ImageIO.read(new File("../data/profile.png")); //read existing file
      ImageIO.write(profileToEdit, "png", new File("../data/profileToEdit.png"));
    }catch(Exception e){
      e.printStackTrace();
    }

    this.imageToEdit = "../data/profile.png";
    this.editedImage = "../data/profileToEdit.png";

    //set screen size
    this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
  }

  /*
    need a method that reads in imageToEdit, changes it, and displays it
  */

  private void rotate() throws Exception{
    BufferedImage toEdit = ImageIO.read(new File(imageToEdit));

    AffineTransform rotateCranium = new AffineTransform();

    // for(Integer[] coordinate : this.coordinates){
    //   rotateCranium.rotate(Math.PI/2, coordinate[]);
    // }
  }

  private BufferedImage lazer(Graphics g, BufferedImage toEdit) throws Exception{
    BufferedImage lazerEyes = ImageIO.read(new File("../data/lens-flare.png"));
    Graphics gImage = toEdit.createGraphics();


    for(Integer[] c : coordinates){
      if(c.length == 8){
        BufferedImage resized = Page.resize(lazerEyes, 120, 120);
        gImage.drawImage(resized, c[0]+c[2]/2 - 60, c[1]+c[3]/2 - 60, null);

        gImage.drawImage(resized, c[4]+c[6]/2 - 60, c[5]+c[7]/2 - 60, null);
      }
    }
    return toEdit;
  }

  private BufferedImage deepFry(BufferedImage toEdit) throws Exception{
    // A 3x3 kernel that sharpens an image
    Kernel kernel = new Kernel(3, 3,new float[]{
            -1, -1, -1,
            -1, 9, -1,
            -1, -1, -1});

    BufferedImageOp op = new ConvolveOp(kernel);

    toEdit = op.filter(toEdit, null);

    return toEdit;
  }


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

    //outline of image border
    Graphics2D g2 = (Graphics2D) g;
    float thickness = 2;
    g2.setStroke(new BasicStroke(thickness));
    g.setColor(new Color(211,211,211));
    g.drawRect((WIDTH/2-400/2), (HEIGHT/2-400/2) + 40, 400, 400);

    //Unedited image
    try{
      BufferedImage profile = ImageIO.read(new File("../data/profileToEdit.png"));
      g.drawImage(profile, (WIDTH/2-400/2), (HEIGHT/2-400/2) + 40, this);

    }catch(Exception e){
      e.printStackTrace();
    }

    //make a save button
    JButton save = new JButton("Save");
    save.setOpaque(false);
    save.setContentAreaFilled(false);
    save.setBorderPainted(false);
    save.setForeground(headerColor);
    save.setFont(new Font("SansSerif", Font.PLAIN, 15));
    save.setBounds(WIDTH-300, HEIGHT/2, 200, 40);
    add(save);
    save.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try{
          BufferedImage profile = ImageIO.read(new File(imageToEdit));

          BufferedImage deepFried = deepFry(profile);

          // BufferedImage superDeepFried = deepFry(deepFried);

          BufferedImage lazed = lazer(g, deepFried);

          RescaleOp rescaleOp = new RescaleOp(1.2f, 15, null);

          rescaleOp.filter(lazed, lazed);

          ImageIO.write(lazed, "png", new File("../data/profileToEdit.png"));

          repaint();
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
    });



    // Make deep fry button
    JButton deepFry = new JButton("Deep Fry");
    deepFry.setOpaque(false);
    deepFry.setContentAreaFilled(false);
    deepFry.setBorderPainted(false);
    deepFry.setForeground(headerColor);
    deepFry.setFont(new Font("SansSerif", Font.PLAIN, 15));
    deepFry.setBounds(WIDTH/4-200, HEIGHT/2-50, 200, 40);
    add(deepFry);
    // Add an action listener
    deepFry.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try{
          BufferedImage profile = ImageIO.read(new File(imageToEdit));

          BufferedImage deepFried = deepFry(profile);

          // BufferedImage superDeepFried = deepFry(deepFried);

          BufferedImage lazed = lazer(g, deepFried);

          RescaleOp rescaleOp = new RescaleOp(1.2f, 15, null);

          rescaleOp.filter(lazed, lazed);

          ImageIO.write(lazed, "png", new File("../data/profileToEdit.png"));

          repaint();
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
    });


    // Make superDeepFry button
    JButton superDeepFry = new JButton("Super Deep Fry");
    superDeepFry.setOpaque(false);
    superDeepFry.setContentAreaFilled(false);
    superDeepFry.setBorderPainted(false);
    superDeepFry.setForeground(headerColor);
    superDeepFry.setFont(new Font("SansSerif", Font.PLAIN, 15));
    superDeepFry.setBounds(WIDTH/4-200, HEIGHT/2, 200, 40);
    add(superDeepFry);
    // Add an action listener
    superDeepFry.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try{
          BufferedImage profile = ImageIO.read(new File(imageToEdit));

          BufferedImage deepFried = deepFry(profile);

          BufferedImage superDeepFried = deepFry(deepFried);

          BufferedImage lazed = lazer(g, superDeepFried);

          RescaleOp rescaleOp = new RescaleOp(1.2f, 15, null);

          rescaleOp.filter(lazed, lazed);

          ImageIO.write(lazed, "png", new File("../data/profileToEdit.png"));

          repaint();
        }catch(Exception exp){
          exp.printStackTrace();
        }
      }
    });
  }
}
