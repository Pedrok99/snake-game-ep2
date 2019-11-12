import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Snake extends JLabel {

	private int x = 30, y = 30, larg = 10, alt = 10;
	protected int score = 0;
	protected boolean Ds=false;
	

	ImageIcon head = new ImageIcon("./images/SQHead.png");

	public Snake() {
		setBounds(x, y, larg, alt);
		setVisible(true);
		setIcon(head);
	}

	//codigo para fazer a cobra morrer ao bater na parede
	
	/*
	 * public boolean MoveAndCheck(Snake s, int VX, int VY, LinkedList<Point>
	 * pontos) { x = x + VX; y = y + VY; if (x < 0 || x > 280 || y < 0 || y > 260) {
	 * return false; } for (int i = 1; i < pontos.size(); i++) { if
	 * (pontos.get(i).getX() == x && pontos.get(i).getY() == y) { return false; } }
	 * s.setLocation(x, y); return true; }
	 */

	public boolean MoveAndCheck(Snake s, int VX, int VY, LinkedList<Point> pontos, LinkedList<Point> wall) {
		x = x + VX;
		y = y + VY;
		if (x < 0) {
			x = 280;
		}
		if (x > 280) {
			x=0;
		}
		if (y < 0) {
			y=260;
		}
		if (y > 260) {
			y=0;
		}

		for (int i = 1; i < pontos.size(); i++) {
			if (pontos.get(i).getX() == x && pontos.get(i).getY() == y) {
				return false;
			}
		}
		for (int i = 0; i < wall.size(); i++) {
			if (wall.get(i).getX() == x && wall.get(i).getY() == y) {
				return false;
			}
		}
		s.setLocation(x, y);
		return true;
	}

	public void AppleCollision(Snake s, Apple a, LinkedList<Point> pontos) {
		if ((s.getX() == a.getX()) && (s.getY() == a.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			a.generateApple();
			score++;
		}
	}
	public boolean getds () {
		return this.Ds;
	}
	public void setds (boolean d) {
		this.Ds = d;
	}
}
