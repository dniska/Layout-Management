package layout_management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * This class will give you practice creating and laying out containers.
 * @author Daniel Niska
 */
public class LayoutManagement extends JComponent {
    
    public LayoutManagement() {
        setLayout(new FlowLayout());
        
        final JPanel buttonPanel = new JPanel();
        final JPanel buttonPanel2 = new JPanel();
        JPanel labelPanel = new JPanel();
        
             buttonPanel.setLayout(new GridLayout(0, 1, 20, 5));
             buttonPanel2.setLayout(new GridLayout(0, 1, 20, 5));
             labelPanel.setLayout(new GridLayout(0, 1));
        
        final JLabel left = new JLabel("Default Message"); //For button pressed on left
        final JLabel right = new JLabel("Default Message"); //For button pressed on right
        TitledBorder Lborder = new TitledBorder("Message 1");
        TitledBorder Rborder = new TitledBorder("Message 2");
        
        left.setBorder(Lborder);
        right.setBorder(Rborder);
        
             left.setBackground(Color.PINK);
             right.setBackground(Color.PINK);
        
                  left.setPreferredSize(new Dimension(125, 50));
                  right.setPreferredSize(new Dimension(125, 50));
        
             left.setHorizontalAlignment(JLabel.CENTER);
             left.setVerticalAlignment(JLabel.CENTER);
             right.setHorizontalAlignment(JLabel.CENTER);
             right.setVerticalAlignment(JLabel.CENTER);
        
        labelPanel.add(left);
        labelPanel.add(right);

        //Add buttons to new panel
        String[] labels = "This class will give you practice creating and laying out containers".split("\\s");
        int x = labels.length;
        int i = 0;
        for (final String label : labels) {
            final JButton button = new JButton(label);
            button.setBackground(Color.CYAN);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(button.getParent() == buttonPanel)
                        left.setText(label);
                    else if(button.getParent() == buttonPanel2)
                        right.setText(label);
                }
            });
            ++i;
            button.setPreferredSize(new Dimension(125, 25));
            if(i <= (x/2) + 1)
                buttonPanel.add(button);
            else
                buttonPanel2.add(button);
            
        } //end for
        EmptyBorder aBorder = new EmptyBorder(25, 25, 25, 25);
        add(buttonPanel);
        add(labelPanel);
        add(buttonPanel2);
        setBorder(aBorder);
    }

    /**
     * @param args the command line arguments -- not used
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Management Lab");
        frame.add(new LayoutManagement());
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
