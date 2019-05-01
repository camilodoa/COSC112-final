import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class SaveButton extends JPanel{
	static final int WIDTH = 400;
	static final int HEIGHT = 200;
	private BufferedImage profile;

	public SaveButton(){
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g){

		// This is the image that we will try to save...it should be already represented in the other code
		try {
			profile = ImageIO.read(new File("/CS112/FinalProject/COSC112-final/images/kelley.jpg"));
			System.out.println("Image width: " + profile.getWidth());
			System.out.println("Image height: " + profile.getHeight());			
		} catch (IOException k) {
			System.out.println(k);
		}


		// Set other graphics
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH,HEIGHT);

		Color headerColor = new Color(0,0,255);

		// Make save button
	    JButton save = new JButton("Save image");
	    save.setOpaque(false);
	    save.setContentAreaFilled(false);
	    save.setBorderPainted(false);
	    save.setForeground(headerColor);
	    save.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    save.setBounds(10, 10, 150, 30);
	    add(save);

	    // Add action listener to save image
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JFileChooser directoryChooser = new JFileChooser();
                directoryChooser.setCurrentDirectory(new java.io.File("."));
                directoryChooser.setDialogTitle("Save Image");
                directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                directoryChooser.setAcceptAllFileFilterUsed(false);

                if(directoryChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                	directoryChooser.getCurrentDirectory(); // this is the path where the file will be saved
                	System.out.println("Chosen directory: " + directoryChooser.getCurrentDirectory());
                }
                else {
                	System.out.println("No directory selection");
                }
 
            }
        });	    

	}

	public static void main(String[] args) throws Exception {

		// Set the frame
		JFrame saveButton = new JFrame("Save button");
	    saveButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    saveButton.setContentPane(new SaveButton());
	    saveButton.pack();
	    saveButton.setVisible(true);

	}

}
