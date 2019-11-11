import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameOver extends JPanel {

	JLabel go = new JLabel();
	
	public GameOver () {
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
		go.setText("GameOver");
		go.setHorizontalAlignment(JLabel.CENTER);
		go.setSize(180, 90);
		go.setLocation(60, 60);
		go.setVisible(true);
		add(go);
		
		
		
	}
	
}
