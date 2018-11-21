<<<<<<< HEAD
import java.util.ArrayList;
=======
// Main was worked on by all three students
>>>>>>> 3105a759bc33cd1ff7356e1f8089be2eed76ef50

public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
<<<<<<< HEAD
		//Sprite me = new Sprite("squire_m.png", 100,100,32,48,10);
=======
>>>>>>> 3105a759bc33cd1ff7356e1f8089be2eed76ef50
		final int MOVEMENT = -2;
		int counter = 0;
		
		ArrayList<Obstacle> obs = new ArrayList<Obstacle> ();
		obs.add(new Obstacle(1000, 800));
		
		
			
		while (true) {
			counter++;
			
			if(counter > 2000)
				obs.add(new Obstacle(1000, 800));
			
			for(int i = 0; i < obs.size(); i++) {
				obs.get(i).move(MOVEMENT);
			}
			background.move(MOVEMENT);
			fish.move();
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
		}
	}

}
