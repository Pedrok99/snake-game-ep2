import javax.swing.ImageIcon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class GameOver extends JLabel {

	ImageIcon gameover = new ImageIcon("C:\\Users\\Pichau\\Desktop\\Triangulo\\GAMEOVER.png");
	
	public GameOver () {
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}
	
}
