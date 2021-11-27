import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.EventQueue;

public class Input {

    public Input() {
    }

    public static void createFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Input Parameters");

                JLabel lblUser = new JLabel("File:");
                JTextField tfUser = new JTextField(20);
                lblUser.setLabelFor(tfUser);

                JLabel lblDots = new JLabel("Quality of dots:");
                JTextField tfDots = new JTextField(20);
                lblDots.setLabelFor(tfDots);

                JButton btnGet = new JButton("DO IT");
                btnGet.addActionListener(
                        new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(frame,
                                        "Success");
                            }
                        });

                JPanel panel = new JPanel();
                panel.setLayout(new SpringLayout());

                panel.add(lblUser);
                panel.add(tfUser);
                panel.add(lblDots);
                panel.add(tfDots);
                panel.add(btnGet);


                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);
                frame.getContentPane().add(panel);
                frame.setVisible(true);

            }
        });
    }
}
