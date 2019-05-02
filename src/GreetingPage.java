//imports=======================================================================
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
//imports=======================================================================


public class GreetingPage extends Page {

  //constructor
  public GreetingPage(){
    // Set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  //methods
  @Override
  public void paintComponent(Graphics g){//=====================================
    super.paintComponent(g);

    // Set background color
    g.setColor(Color.WHITE);
    g.fillRect(0,0,WIDTH,HEIGHT);

    // Title and header
    Color headerColor = new Color(0,0,255);
    Font headerFont = new Font("SansSerif", Font.BOLD, 30);
    g.setColor(headerColor);
    g.fillRect(0, 0, WIDTH, 100);
    g.setColor(Color.WHITE);
    g.setFont(headerFont);
    g.drawString("Face Distorter 2000", WIDTH/2-150, 50);


    // Front page description
    Font descriptionFont = new Font("SansSerif", Font.PLAIN, 15);
    g.setFont(descriptionFont);
    g.setColor(Color.BLACK);
    int x_text = WIDTH/4;
    int y_text = HEIGHT/4;
    g.drawString("Welcome to the Face Distorter 2000 program!",x_text,y_text);
    g.drawString("Click the button below to select a profile picture - square images work best",x_text,y_text+40);
    g.drawString("Our facial recognition back end will identify faces (and eyes)",x_text,y_text+80);
    g.drawString("If your image was too complicated for it to identify, you can always reselect an image",x_text,y_text+120);
    g.drawString("Afterwards, you can distort the faces the program found in a number of ways",x_text,y_text+160);
    g.drawString("and save the distorted image!",x_text,y_text+180);
    g.setColor(headerColor);
    g.drawString("To get started, click the button below:",x_text,y_text+220);


    // Select image button
    JButton start = new JButton("Select your image");
    start.setOpaque(false);
    start.setContentAreaFilled(false);
    start.setBorderPainted(false);
    start.setForeground(headerColor);
    start.setFont(new Font("SansSerif", Font.PLAIN, 15));
    start.setBounds(WIDTH/2-100, HEIGHT - HEIGHT/4 - 25, 200, 40);
    add(start);


    // Add an action listener
    start.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fc.getSelectedFile();
          String fileToPass = selectedFile.getPath();

          JButton loading = new JButton("Finding faces...");
          loading.setOpaque(true);
          loading.setContentAreaFilled(true);
          loading.setBorderPainted(false);
          loading.setBackground(Color.white);
          loading.setForeground(headerColor);
          loading.setFont(new Font("SansSerif", Font.PLAIN, 15));
          loading.setBounds(WIDTH/2-100, HEIGHT - HEIGHT/4+10, 200, 40);
          add(loading);


          setImagePath(fileToPass);

          showGreetingToImage(); //changes pages to ImagePage
        }
      }
    });
  }//paintComponent()===========================================================
}
