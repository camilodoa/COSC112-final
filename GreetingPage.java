
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GreetingPage extends Page {
  private static int HEIGHT;
  private static int WIDTH;
  //private BufferedImage titleImage;

  public GreetingPage(){

    // Get fields from interface
    this.HEIGHT = Page.HEIGHT;
    this.WIDTH = Page.WIDTH;

    // Set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    // title image
    /*
    try {
      titleImage = ImageIO.read(this.getClass().getResourceAsStream("images/FaceDisorter.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    */

  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    // Set background color
    g.setColor(new Color(25,25,112));
    g.fillRect(0,0,WIDTH,HEIGHT);

    // Write title
    //g.drawImage(titleImage, 50, 50, 100, 100, null);
    g.setColor(Color.WHITE);
    g.drawString("FACE DISTORTER 2000",50,50);

    // Make description
    g.setColor(Color.WHITE);
    int x_text = 100;
    int y_text = 100;
    g.drawString("Welcome to the Face Distorter 2000 program.",x_text,y_text);
    g.drawString("You will first be prompted to upload an image that includes a face.",x_text,y_text+20);
    g.drawString("Then, you will be asked to identify the location of the face,",x_text,y_text+40);
    g.drawString("as well as eyes and mouth, using your mouse or trackpad.",x_text,y_text+60);
    g.drawString("Afterwards, you will be able to distort the face via a number of selections.",x_text,y_text+80);
    g.drawString("You will then be provided with the distorted image and options to save.",x_text,y_text+100);

    // First instructions
    g.setColor(new Color(124,252,0));
    g.drawString("To get started, click on the button to upload an image.",x_text,y_text+120);

    // Make button
    JButton b = new JButton("Select .jpg");
    b.setBounds(100, 400, 100, 50);
    add(b);

    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    // Add an action listener
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");

        int returnValue = fc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fc.getSelectedFile();
          String fileToPass = selectedFile.getPath();
          System.out.println(fileToPass);
          System.out.println(selectedFile.getName());

          

          showGreetingToImage(); //changes pages
        }
      }
        });


  }

  public static void main(String[] args) {

    // Set the frame
    JFrame welcome = new JFrame("Face Distorter 2000");
    welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    welcome.setContentPane(new GreetingPage());
    welcome.pack();
    welcome.setVisible(true);


  /*
    // Add a button
    JButton b = new JButton("Select .jpg");
    b.setBounds(100, 400, 100, 50);
    welcome.add(b);

    // Declare the file chooser and file
    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    // When ready, use the filters so that the user can ONLY upload a .jpg
    //FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg");
    //fc.setFileFilter(filter);

    // Add an action listener
  b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("clicked");

      int returnValue = fc.showSaveDialog(null);

      if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fc.getSelectedFile();
        String fileToPass = selectedFile.getPath();
        System.out.println(fileToPass);
        System.out.println(selectedFile.getName());

        showGreetingToImage(); //changes pages
      }
    }
      });

      */
  }

  // Implement more here to pass the image on to the next stage of the App
  // selectedFile is a jpg that can now be passed on
}
