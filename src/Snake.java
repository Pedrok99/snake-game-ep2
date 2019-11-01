import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Snake extends JLabel {

	private int x = 30, y = 30, larg = 10, alt = 10;

	ImageIcon head = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\SQHead.png");

	public Snake() {
		setBounds(x, y, larg, alt);
		setVisible(true);
		setIcon(head);
	}

	public void move(Snake s, int VX, int VY) {
		x = x + VX;
		y = y + VY;
		s.setLocation(x, y);
	}
	public void collide(Snake s, Apple a) {
		if((s.getX() == a.getX()) && (s.getY() == a.getY())) {
			a.T1.resume();
		}
	}

}
