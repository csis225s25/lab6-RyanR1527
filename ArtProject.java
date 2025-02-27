import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        int [] xCords = new int[30];
        int [] yCords = new int[30];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                xCords[j] = (int) (Math.random() * 100);
                yCords[j] = (int) (Math.random() * 100);
            }
            g.setColor(Color.RED);
            g.fillPolygon(xCords, yCords, 3);
        }
        // draw a flower

        g.setColor(Color.RED);
        g.fillOval(100, 100, 100, 100);
        g.setColor(Color.GREEN);
        g.fillRoundRect(100, 150, 100, 100, 10, 10);
        g.setColor(Color.BLUE);
        g.drawPolygon(xCords, yCords, 4);
        g.setColor(Color.YELLOW);
        g.fillOval(100, 250, 100, 100);
        g.setColor(Color.ORANGE);
        g.fill3DRect(100, 200, 100, 100, true);
        g.setColor(Color.YELLOW);


    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Art Project");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel2();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}

