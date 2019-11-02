import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
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

	@SuppressWarnings("deprecation")
	public void run() {
		while (true) {
			x = applePosx.nextInt(289);
			y = applePosy.nextInt(269);
			x = x / 10;
			x = x * 10;
			y = y / 10;
			y = y * 10;
			setLocation(x, y);
			T1.suspend();
		}

	}

	@SuppressWarnings("deprecation")
	public void checkApple(Apple a, LinkedList<Point> pontos) {

		for (int i = 0; i < pontos.size(); i++) {
			if (pontos.get(i).getX() == a.getX() && pontos.get(i).getY() == a.getY()) {
				T1.resume();
				i = 0;
			}
		}
	}
}
