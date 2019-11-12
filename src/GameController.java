import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameController extends JFrame implements ActionListener, Runnable {

	GameMechanics maingame;
	GameOver gameover;
	JButton jb1 = new JButton("Classic");
	JButton jb2 = new JButton("Kitty");
	JButton jb3 = new JButton("Star");
	JLabel titulo = new JLabel();
	JLabel classic = new JLabel();
	JLabel kitty = new JLabel();
	JLabel star =  new JLabel();
	boolean teste=true;

	public GameController() {
		setTitle("SnakeGame");
		setMinimumSize(new Dimension(300, 300));
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(new Dimension(300, 300));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
		
		jb1.setBounds(10, 80, 90, 30);
		jb1.setVisible(true);
		jb1.addActionListener(this);
		jb1.setBackground(Color.DARK_GRAY);
		jb1.setFont(jb1.getFont().deriveFont(16.0f));
		jb1.setForeground(Color.MAGENTA);
		jb1.setFocusPainted(false);
		jb1.setBorderPainted(false);
		add(jb1);
		
		jb2.setBounds(10, 140, 90, 30);
		jb2.setVisible(true);
		jb2.addActionListener(this);
		jb2.setBackground(Color.DARK_GRAY);
		jb2.setFont(jb2.getFont().deriveFont(16.0f));
		jb2.setForeground(Color.green);
		jb2.setFocusPainted(false);
		jb2.setBorderPainted(false);
		add(jb2);
		
		jb3.setBounds(10, 200, 90, 30);
		jb3.setVisible(true);
		jb3.addActionListener(this);
		jb3.setBackground(Color.DARK_GRAY);
		jb3.setFont(jb3.getFont().deriveFont(16.0f));
		jb3.setForeground(Color.ORANGE);
		jb3.setFocusPainted(false);
		jb3.setBorderPainted(false);
		add(jb3);
		
		titulo.setSize(new Dimension(230, 35));
		titulo.setFont(titulo.getFont().deriveFont(16.0f));
		titulo.setLocation(95, 10);
		titulo.setText("SNAKEGAME");
		titulo.setForeground(Color.pink);
		add(titulo);
		
		classic.setSize(new Dimension(150, 30));
		classic.setLocation(110, 80);
		classic.setText(" - Nenhum Efeito Especial.");
		classic.setForeground(Color.white);
		add(classic);
		kitty.setSize(new Dimension(150, 30));
		kitty.setLocation(110, 140);
		kitty.setText(" - Atravessa Obstaculos.");
		kitty.setForeground(Color.white);
		add(kitty);
		
		star.setSize(new Dimension(150, 30));
		star.setLocation(110, 200);
		star.setText(" - Recebe 2x Mais Pontos.");
		star.setForeground(Color.white);
		add(star);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			maingame = new GameMechanics(1);
			setVisible(false);
		}
		if (e.getSource() == jb2) {
			maingame = new GameMechanics(2);
			setVisible(false);
		}
		if (e.getSource() == jb3) {
			maingame = new GameMechanics(3);
			setVisible(false);
		}
		new Thread(this).start();
		teste=true;

	}

	@Override
	public void run() {
	
		while(teste) {
			if(!maingame.isRunning && maingame.finalflag) {
				maingame.display.dispose();
				maingame=null;
				System.gc();
				setVisible(true);
				teste=false;
			}
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
