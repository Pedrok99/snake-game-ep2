package SnakePackage;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class StarSnake extends Snake {

	public StarSnake() {
		super();
		setds(true);
		setIcon(new ImageIcon("./images/starh.png"));
	}
	public void AppleCollision(Snake s, Apple a, LinkedList<Point> pontos) {
		if ((s.getX() == a.getX()) && (s.getY() == a.getY())) {
			pontos.addLast(new Point(pontos.get(pontos.size() - 1)));
			a.generateApple();
			s.score += 2;
		}
	}

}
