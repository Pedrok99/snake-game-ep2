import java.awt.Dimension;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Apple extends JLabel {

	private int x, y;
	private Random applePosx = new Random();
	private Random applePosy = new Random();
	private ImageIcon appleicon = new ImageIcon("./images/APPLE.png");
	private boolean validplace = true;

	public Apple() {
		setIcon(appleicon);
		setSize(new Dimension(10, 10));
		setVisible(true);
		generateApple();
	}

	public void generateApple() {
		
		do {
			
			x = applePosx.nextInt(289);
			y = applePosy.nextInt(269);
			x = x / 10;
			x = x * 10;
			y = y / 10;
			y = y * 10;
			validplace=true;
			for (int i = 0; i < 10; i++) {
				if (x == 70 && y == (120 + i * 10)) {
					validplace = false;
				}
			}
			for (int i = 0; i < 10; i++) {
				if (x == 210 && y == (40 + i * 10)) {
					validplace = false;
				}
			}
		} while (!validplace);

		setLocation(x, y);
	}
}
