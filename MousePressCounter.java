import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */


public class MousePressCounter extends MouseAdapter implements Runnable {
	String text = "Count: ";
	int count = 0;
	JPanel panel;
	JButton button;

	class MouseDisplay extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
	
			super.paintComponent(g);
	
			FontMetrics fm = g.getFontMetrics();
	
			String toDisplay = text + count;
			int stringWidth = fm.stringWidth(toDisplay);
			int stringAscent = fm.getAscent();
	
			int xStart = getWidth() / 2 - stringWidth / 2;
			int yStart = getHeight() / 2 + stringAscent / 2;
	
			g.drawString(toDisplay, xStart, yStart);
		}
	}

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new MouseDisplay(); 
		panel.setLayout(new GridLayout(3,3));
		button = new JButton("Reset");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				panel.repaint();
			}
		});
		panel.add(new JLabel("")); // First row
		panel.add(new JLabel("")); 
		panel.add(new JLabel(""));
		panel.add(new JLabel("")); // Second row
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("")); // Third row
		panel.add(button);        // Bottom middle position
		panel.add(new JLabel(""));
		frame.add(panel);

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked: " + e);
		count ++;
		panel.repaint();
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}

