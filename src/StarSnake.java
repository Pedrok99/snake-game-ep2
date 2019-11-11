import java.awt.Point;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class StarSnake extends Snake {

	private int x=30, y=30;
	protected int score = 0;
	protected boolean doublescore=true;

	public StarSnake() {
		super();
	}

	public void AppleCollision(Snake s, Apple a, LinkedList<Point> pontos) {
		if ((s.getX() == a.getX()) && (s.getY() == a.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			a.generateApple();
			score += 2;
			System.out.println("Score = " + score);

		}
	}

}
