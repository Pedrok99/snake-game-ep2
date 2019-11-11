import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BigApple extends Apple {
	private ImageIcon appleicon = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\BIG.png");

	public BigApple() {
		super();
		setIcon(appleicon);
		setLocation(400, 400);
	}

	public void collision(Snake s, LinkedList<Point> pontos) {
		if ((s.getX() == this.getX()) && (s.getY() == this.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			s.score += 2;
			System.out.println("Score da big = " + s.score);
			setLocation(-10, -10);
		}
		
		
	}

}
