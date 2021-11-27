import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class App {

    public App() {
        // Creating the Frame
        JFrame frame = new JFrame("Picture Displayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);

        // Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Create open file and input points
        JPanel input = new JPanel(); // the panel is not visible in output
        JLabel lb1 = new JLabel("quantity of dots:");
        JTextField tf1 = new JTextField("1000");
        input.add(lb1);
        input.add(tf1);

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Dimension:");
        JTextField tf = new JTextField("show width: and height:");

        JButton close = new JButton("Close");
        close.addActionListener(e -> {
            frame.dispose();
        });
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(close);

        // Text Area at the Center
        Picture picture = new Picture("C:\\Users\\nguye\\Pictures\\QueHuong.jpg", 10000);
        NewPicture newPicture = new NewPicture(picture.getListPoints(), picture.getWidth(), picture.getHeight());


        //Open
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.createFrame();
            }
        });

        //Print
        // JButton paint = new JButton("Capture");
        m22.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage image = new BufferedImage(picture.getWidth(), picture.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    newPicture.printAll(g);
                    g.dispose();
                    try {
                        ImageIO.write(image, "jpg", new File("C:\\Users\\nguye\\Pictures\\QueHuong_new.jpg"));
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }
                }
            });

        // Adding Components to the frame.
        // frame.getContentPane().add(BorderLayout.SOUTH, paint);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        // frame.getContentPane().add(BorderLayout.NORTH, input);
        frame.getContentPane().add(BorderLayout.CENTER, newPicture);
        frame.setVisible(true);

        // savePic(frame);
        // m22.add(paint);
    }

    
    public static void main(String args[]) {

        new App();
    }
}
