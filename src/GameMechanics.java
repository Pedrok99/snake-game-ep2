import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameMechanics extends JLabel implements Runnable, KeyListener {

	private JFrame display = new JFrame();
	private Thread thread = new Thread(this);
	private JLabel end = new JLabel();
	private Snake S1 = new Snake();
	private Apple A1 = new Apple();
	private int Xspeed = 10, Yspeed = 0, i;
	private boolean isRunning = true;
	private LinkedList<Point> Pontos = new LinkedList<Point>();
	private Point lastp = new Point();
	private ImageIcon img = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\GAMEOVER.png");

	public GameMechanics() {
		cfgDisplay();
		setSize(300, 300);
		setLocation(0, 0);
		setLayout(null);
		setVisible(true);
		display.addKeyListener(this);
		display.add(this);
		display.add(end);
		display.add(S1);
		display.add(A1);
		Pontos.addLast(new Point(20, 30));
		Pontos.addLast(new Point(10, 30));
		Pontos.addLast(new Point(0, 30));
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
		end.setSize(300, 300);
		end.setLocation(0, 0);
		end.setLayout(null);
		end.setVisible(false);
		end.setIcon(img);
		
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_UP:
			if (Yspeed == 10) {
				break;
			}
			Yspeed = -10;
			Xspeed = 0;
			break;
		case KeyEvent.VK_DOWN:
			if (Yspeed == -10) {
				break;
			}
			Yspeed = 10;
			Xspeed = 0;
			break;
		case KeyEvent.VK_LEFT:
			if (Xspeed == 10) {
				break;
			}
			Yspeed = 0;
			Xspeed = -10;
			break;
		case KeyEvent.VK_RIGHT:
			if (Xspeed == -10) {
				break;
			}
			Yspeed = 0;
			Xspeed = 10;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void run() {

		while (isRunning) {
			lastp.setLocation(S1.getLocation());
			A1.checkApple(A1, Pontos);
			isRunning = S1.MoveAndCheck(S1, Xspeed, Yspeed, Pontos);	
			if (!isRunning ) {
				end.setVisible(true);
				remove(A1);
				remove(S1);
				setVisible(false);
				break;
			}
			S1.AppleCollision(S1, A1, Pontos);
			repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Pontos.addFirst(Pontos.removeLast());
		Pontos.get(0).setLocation(lastp);
		for (i = 0; i < Pontos.size(); i++) {
			g.fillOval(Pontos.get(i).x, Pontos.get(i).y, 10, 10);

		}

	}

}
