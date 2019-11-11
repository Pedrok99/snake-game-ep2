import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameMechanics extends JPanel implements Runnable, KeyListener {

	private JFrame display = new JFrame();
	private Thread thread = new Thread(this);
	private JLabel end = new JLabel();
	private GameOver gameoverpanel = new GameOver();

	//private Snake S1 = new Snake();

	 private KittySnake S1 = new KittySnake();

	 //private StarSnake S1 = new StarSnake();

	private Apple A1 = new Apple();
	private int Xspeed = 10, Yspeed = 0, i;
	private boolean isRunning = true;
	private LinkedList<Point> Pontos = new LinkedList<Point>();
	private Point lastp = new Point();
//	private ImageIcon img = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\GAMEOVER.png");
	private LinkedList<Point> wall = new LinkedList<Point>();
	private Point aux = new Point();
	private BombApple bomba = new BombApple();
	private BigApple big = new BigApple();
	private DecreaseApple Decrease = new DecreaseApple();
	private SpecialSpawner spawner = new SpecialSpawner(bomba, big, Decrease);// -------------

	public GameMechanics() {
		cfgDisplay();
		setSize(300, 300);
		setLocation(0, 0);
		setLayout(null);
		setVisible(true);
		setBackground(Color.lightGray);
		add(S1);
		add(A1);

		add(bomba);// -------------
		add(big);
		add(Decrease);
		display.add(gameoverpanel);

		//Pontos.add(new Point(20, 30));
		//Pontos.add(new Point(10, 30));
		//Pontos.add(new Point(0, 30));
		thread.start();

	}

	public void cfgDisplay() {
		display.setTitle("SnakeGame");
		display.setMinimumSize(new Dimension(300, 300));
		display.setSize(new Dimension(300, 300));
		display.setResizable(false);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setLayout(null);
		display.setVisible(true);
		display.addKeyListener(this);
		display.add(this);
		display.add(end);
		display.setLocationRelativeTo(null);
		end.setSize(300, 300);
		end.setLocation(0, 0);
		end.setLayout(null);
		end.setVisible(false);
		// end.setIcon(img);
		barrier();
		display.pack();

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
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override

	public void run() {
		Pontos.add(new Point(20, 30));
		Pontos.add(new Point(10, 30));
		Pontos.add(new Point(0, 30));

		while (isRunning) {

			lastp.setLocation(S1.getLocation());
			isRunning = S1.MoveAndCheck(S1, Xspeed, Yspeed, Pontos, wall); // define as proximas cords da cobra

			if (!isRunning) {
				break;
			}
			isRunning = bomba.collision(S1);
			if (!isRunning) {
				break;
			}
			spawner.generateSpecial();// -------------
			//bomba.collision(S1);
			big.collision(S1, Pontos);
			Decrease.collision(S1, Pontos);
			S1.AppleCollision(S1, A1, Pontos);
			repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		endscreen();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try{
		//System.out.println("Tamanho da lista: "+Pontos.size());
		aux = Pontos.removeLast();
		Pontos.addFirst(aux);
		Pontos.get(0).setLocation(lastp);
		}catch(NoSuchElementException e){
			System.out.println("POKEBOLAAAAAAAA VAAAAAAAAAAAAAAAAAAAAAAAAAIII");
		}
		for (i = 0; i < Pontos.size(); i++) {
			g.fillOval(Pontos.get(i).x, Pontos.get(i).y, 10, 10);

		}
		g.fillRect(70, 120, 10, 100);
		g.fillRect(210, 40, 10, 100);

	}

	public void endscreen() {
		setVisible(false);
		gameoverpanel.setVisible(true);

	}

	public void barrier() {
		for (int i = 0; i < 10; i++) {
			wall.add(new Point(70, 120 + i * 10));
		}
		for (int i = 0; i < 10; i++) {
			wall.add(new Point(210, 40 + i * 10));
		}
	}

}
