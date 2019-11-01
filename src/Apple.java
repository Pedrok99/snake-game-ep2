import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Apple extends JLabel implements Runnable {

	int x, y;
	private Random applePosx = new Random();
	private Random applePosy = new Random();
	private ImageIcon appleicon = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\APPLE.png");
	Thread T1 = new Thread(this);
	public Apple() {
		setIcon(appleicon);
		setBounds(0, 0, 10, 10);
		setVisible(true);
		T1.start();
	}

	public void run() {
		while (true) {				
				x = applePosx.nextInt(250);
				y = applePosy.nextInt(250);
				x=x/10;
				x=x*10;
				y=y/10;
				y=y*10;
				setLocation(x, y);
				T1.suspend();
		}

	}

	public int getAppleX() {
		return getX();
	}

	public int getAppleY() {
		return getY();
	}

}
