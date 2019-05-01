//imports=======================================================================
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.TitledBorder;
import java.lang.Process;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Thread;
import java.util.Arrays;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
//imports=======================================================================

public class ImagePage extends Page{
  //FIELDS
  private BufferedImage profile;
  private Font headerFont;
  private Color headerColor = new Color(0,0,255);
  private boolean firstRender = true;


  // CONSTRUCTOR
  public ImagePage(){

    //get a BufferedImage from the selected image
    try{
      this.profile = ImageIO.read(new File(this.imagePath));

      //resize
      profile = Page.resize(profile, 400, 400);

      //copy resized image to data folder
      File outputfile = new File("../data/profile.png");

      ImageIO.write(profile, "png", outputfile);

    }catch(IOException e){
      System.out.println(e);
    }

    // set screen size
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    //headerfont
    this.headerFont = new Font("SansSerif", Font.BOLD, 30);

    //run python analysis
    this.runPython();

  }


  // HELPER METHODS
  private static void runPython(){//============================================
    /*
      runPython() calls the facial recognition python program, reads the file it
      writes to the data folder, and updates a static variable based on what it
      read
    */
    String command = "python3 faceRecog.py " + "../data/profile.png";
    try{
      Process p = Runtime.getRuntime().exec(command);

      p.waitFor();

      coordinates = readPython();

    }catch(IOException | InterruptedException e){
      System.out.println(e);
    }
  }//runPython()================================================================

  private static Vector<Integer[]> readPython(){//==============================
    /*
      readPython() reads the file the facial recognition program wrote and
      returns a vector of the parsed file's contents
    */
    try{
      Scanner sc = new Scanner(new File("../data/picData.txt"));
      //first count the lines so we know how big our file is
      Vector<Integer[]> toReturn = new Vector<Integer[]>();

      while(sc.hasNextLine()){

        String line = sc.nextLine();

        final Integer[] ints = Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        toReturn.add(ints);
      }
      sc.close();

      return toReturn;
    }
    catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }//readPython()===============================================================


  private void paintFaceSquares(Graphics g){//==================================
    /*
      paintFaceSquares() goes through the Vector<> coordinates and draws a rectangle
      around each face and each eye it found
    */
    Graphics2D g2 = (Graphics2D) g;
    float thickness = 2;

    for(Integer[] coordinate : coordinates){

      if(coordinate.length == 4){
        g2.setStroke(new BasicStroke(thickness));
        g.setColor(headerColor);
        g.drawRect(coordinate[0]+WIDTH/2-400/2,coordinate[1] + HEIGHT/2-400/2 + 40, coordinate[2], coordinate[3]);

      }else if (coordinate.length == 8){
        g2.setStroke(new BasicStroke(thickness));
        g.setColor(headerColor);
        g.drawRect(coordinate[0]+WIDTH/2-400/2, coordinate[1] + HEIGHT/2-400/2 + 40 , coordinate[2], coordinate[3]);

        g2.setStroke(new BasicStroke(thickness));
        g.setColor(headerColor);
        g.drawRect(coordinate[4]+WIDTH/2-400/2, coordinate[5] + HEIGHT/2-400/2 + 40 , coordinate[6], coordinate[7]);
      }
    }
  }//paintFaceSquares()=========================================================


  public void paintComponent(Graphics g){//=====================================
    //buttons
    JButton reselect = new JButton("Reselect");
    JButton next = new JButton("Distort");


    //Draw the page
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    //Header
    g.setColor(headerColor);
    g.fillRect(0, 0, WIDTH, 100);
    g.setColor(Color.WHITE);
    g.setFont(headerFont);
    g.drawString("Face Distorter 2000", WIDTH/2-150, 50);


    //reselect button
    reselect.setBounds(WIDTH/4-175, HEIGHT/2, 160, 40);
    reselect.setOpaque(false);
    reselect.setContentAreaFilled(false);
    reselect.setBorderPainted(false);
    reselect.setFont(new Font("SansSerif", Font.PLAIN, 20));
    reselect.setForeground(headerColor);
    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    // Add an action listener
    reselect.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnValue = fc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fc.getSelectedFile();
          String fileToPass = selectedFile.getPath();

          setImagePath(fileToPass);

          //get a BufferedImage from the image
          try{
            profile = ImageIO.read(new File(imagePath));

            //resize
            profile = Page.resize(profile, 400, 400);

            File outputfile = new File("../data/profile.png");

            ImageIO.write(profile, "png", outputfile);

          }catch(IOException exp){
            System.out.println(exp);
          }

          //run python analysis on new image
          runPython();

          //re render
          firstRender = true;
          repaint();
          }
        }
      });
    add(reselect);
    

    //next page button
    next.setBounds(WIDTH - WIDTH/4 + 25, HEIGHT/2, 160, 40);
    next.setOpaque(false);
    next.setContentAreaFilled(false);
    next.setBorderPainted(false);
    next.setForeground(headerColor);
    next.setFont(new Font("SansSerif", Font.PLAIN, 20));
    next.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        imageToFinal();
      }
    });
    add(next);

    //profile
    g.drawImage(profile, (WIDTH/2-400/2), (HEIGHT/2-400/2) + 40, this);


    //to tell the user if no faces were found
    if(coordinates.isEmpty()){ //to tell user to reselect if there are no faces
      Font descriptionFont = new Font("SansSerif", Font.PLAIN, 15);
      g.setFont(descriptionFont);
      g.setColor(headerColor);
      g.drawString("No faces were found",WIDTH/4-170,HEIGHT/2-70);
      g.drawString("Select another image",WIDTH/4-170,HEIGHT/2-50);

    }

    //some logic to avoid buggy reloads
    if (firstRender == true){
      firstRender = false;
      paintFaceSquares(g);
    }
  }//paintComponent()===========================================================
}
