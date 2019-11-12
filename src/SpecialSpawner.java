import java.awt.Point;
import java.util.Random;

public class SpecialSpawner {

	private BombApple bomb;
	private BigApple Big;
	private DecreaseApple decrease;
	protected int i=0, livingtime=0;
	private Random aux = new Random();
	private Point pos =  new Point(-10, -10);
	private boolean spawned=false;
	
	public SpecialSpawner(BombApple b, BigApple big, DecreaseApple Dec) {
		Big=big;
		bomb=b;
		decrease = Dec;
		
	}
	
	public void generateSpecial() {
		i+=60;
		if(i>=3000 && !spawned) {
			spawned=true;
			switch(aux.nextInt(3)) {
			case 0:
				bomb.generateApple();
			break;
			case 1:
				Big.generateApple();
			break;
			case 2:
				decrease.generateApple();
				break;
			}		
		}
			livingtime+=60;
			if(livingtime>=11000) {
				//todas as bombas serao mudadas para a pos
				bomb.setLocation(pos);
				Big.setLocation(pos);
				decrease.setLocation(pos);
				
				spawned=false;
				i=0;
				livingtime=0;
			}
		
	}
	
}
