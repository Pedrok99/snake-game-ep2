import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Snake extends JLabel {

	private int x = 30, y = 30, larg = 10, alt = 10;

//	ImageIcon head = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\SQHead.png");
	ImageIcon head = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\T_RIGHT.png");

	public Snake() {
		setBounds(x, y, larg, alt);
		setVisible(true);
		setIcon(head);
	}

	public boolean MoveAndCheck(Snake s, int VX, int VY, LinkedList<Point> pontos) {
		x = x + VX;
		y = y + VY;
		if (x < 0 || x > 280 || y < 0 || y > 260) {
			return false;
		}
		for (int i = 1; i < pontos.size(); i++) {
			if (pontos.get(i).getX() == x && pontos.get(i).getY() == y) {
				return false;
			}
		}
		s.setLocation(x, y);
		return true;
	}

	public void AppleCollision(Snake s, Apple a, LinkedList<Point> pontos) {
		if ((s.getX() == a.getX()) && (s.getY() == a.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			a.T1.resume();
		}
	}

	/*
	 * public boolean BodyCollision(Snake s, LinkedList<Point> pontos) { for (int i
	 * = 1; i < pontos.size(); i++) { if (pontos.get(i).getX() == s.getX() &&
	 * pontos.get(i).getY() == s.getY()) { return false; } } return true; }
	 */

}
