import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BigApple extends Apple {
	private ImageIcon appleicon = new ImageIcon("./images/BIG.png");

	public BigApple() {
		super();
		setIcon(appleicon);
		setLocation(400, 400);
	}

	public void collision(Snake s, LinkedList<Point> pontos) {
		if ((s.getX() == this.getX()) && (s.getY() == this.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			s.score += 2;
			setLocation(-10, -10);
			if (s.getds()) {
				s.score += 2;
			}
		}

	}

}
