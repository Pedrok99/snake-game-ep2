package SnakePackage;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class KittySnake extends Snake{
	private int x=30, y=30;
	
	
	public KittySnake() {
		super();
		setIcon(new ImageIcon("./images/kittyh.png"));
	}
	
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
	 /*	for (int i = 0; i < wall.size(); i++) {
			if (wall.get(i).getX() == x && wall.get(i).getY() == y) {
				return false;
			}
		}*/
		s.setLocation(x, y);
		return true;
	}

}
