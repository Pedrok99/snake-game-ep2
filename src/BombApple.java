import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BombApple extends Apple {
	private ImageIcon appleicon = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\C_BODY.png");
	
	
	public BombApple() {
		super();
		setIcon(appleicon);
		setLocation(400, 400);
	}
	
	public boolean collision(Snake s) {
		if ((s.getX() == this.getX()) && (s.getY() == this.getY())) {
			return false;
		}
		return true;
	}
	
}
