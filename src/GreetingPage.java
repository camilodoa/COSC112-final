
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
    // g.setColor(new Color(25,25,112));
    g.setColor(Color.WHITE);
    g.fillRect(0,0,WIDTH,HEIGHT);


    // Write title
    //g.drawImage(titleImage, 50, 50, 100, 100, null);
    Color headerColor = new Color(0,0,255);
    Font headerFont = new Font("SansSerif", Font.BOLD, 30);
    g.setColor(headerColor);
    g.fillRect(0, 0, WIDTH, 100);
    g.setColor(Color.WHITE);
    g.setFont(headerFont);
    g.drawString("Face Distorter 2000", WIDTH/2-150, 50);


    // Make description
    Font descriptionFont = new Font("SansSerif", Font.PLAIN, 15);
    g.setFont(descriptionFont);
    g.setColor(Color.BLUE);
    int x_text = WIDTH/4+50;
    int y_text = HEIGHT/4;
    g.drawString("Welcome to the Face Distorter 2000 program!",x_text,y_text);
    g.drawString("Click the button below to select a profile picture - square images work best",x_text,y_text+40);
    g.drawString("Our facial recognition back end will identify faces (and eyes)",x_text,y_text+80);
    g.drawString("If your image was too complicated for it to identify, you can always reselect an image",x_text,y_text+120);
    g.drawString("Afterwards, you can distort the faces the program found in a number of ways",x_text,y_text+160);
    g.drawString("and save the distorted image!",x_text,y_text+180);

    // First instructions
    g.setColor(new Color(124,252,0));
    g.drawString("To get started, click the button below:",x_text,y_text+220);

    // Make button
    JButton loading = new JButton("Loading...");
    loading.setBounds(WIDTH/2-100, HEIGHT - HEIGHT/4 - 25, 160, 40);
    JButton start = new JButton("Select your image");
    start.setBounds(WIDTH/2-100, HEIGHT - HEIGHT/4 - 25, 160, 40);
    add(start);

    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    // Add an action listener
    start.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // System.out.println("clicked");

        int returnValue = fc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fc.getSelectedFile();
          String fileToPass = selectedFile.getPath();

          JButton loading = new JButton("Loading...");
          loading.setBounds(WIDTH/2-100, HEIGHT - HEIGHT/4 - 25, 160, 40);
          add(loading);
          repaint();

          setImagePath(fileToPass);


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
