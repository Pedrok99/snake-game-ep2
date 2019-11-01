import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameMechanics extends JLabel implements Runnable, KeyListener {

	private JFrame display = new JFrame();
	private Thread thread = new Thread(this);
	private Snake S1 = new Snake();
	private Apple A1 = new Apple();
	private int Xspeed = 10, Yspeed = 0, x = 30, y = 30;

	public GameMechanics() {
		cfgDisplay();
		setSize(300, 300);
		setLocation(0, 0);
		setLayout(null);
		display.addKeyListener(this);
		display.add(this);
		display.add(S1);
		display.add(A1);
		thread.start();
	}

	public void cfgDisplay() {
		display.setTitle("SnakeGame");
		display.setResizable(false);
		display.setSize(300, 300);
		display.setMinimumSize(new Dimension(300, 300));
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setLayout(null);
		display.setVisible(true);
		display.setLocationRelativeTo(null);
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_UP:
			Yspeed = -10;
			Xspeed = 0;
			break;
		case KeyEvent.VK_DOWN:
			Yspeed = 10;
			Xspeed = 0;
			break;
		case KeyEvent.VK_LEFT:
			Yspeed = 0;
			Xspeed = -10;
			break;
		case KeyEvent.VK_RIGHT:
			Yspeed = 0;
			Xspeed = 10;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void run() {

		while (true) {
			S1.move(S1, Xspeed, Yspeed);
			S1.collide(S1, A1);
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
