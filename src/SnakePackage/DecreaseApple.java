package SnakePackage;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class DecreaseApple extends Apple {
	private ImageIcon appleicon = new ImageIcon("./images/dec.png");
	
	
	public DecreaseApple() {
		super();
		setIcon(appleicon);
		setLocation(400, 400);
	}
	
	public void collision(Snake s,  LinkedList<Point> pontos) {
		if ((s.getX() == this.getX()) && (s.getY() == this.getY())) {
			pontos.subList(3, pontos.size()).clear();
			setLocation(-10,  -10);
		}
	}
	
}
