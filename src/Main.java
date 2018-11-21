 import java.util.ArrayList;
// Main was worked on by all three students


public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 600);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
		//Sprite me = new Sprite("squire_m.png", 100,100,32,48,10);
		final int MOVEMENT = -2;
<<<<<<< HEAD
		final int SCORE = 0;
=======
		int counter = 0;
		
		ArrayList<Obstacle> obs = new ArrayList<Obstacle> ();
		obs.add(new Obstacle(1000, 600));
		
		
>>>>>>> 9b915125f81a1e24a8abe64cb5f564d7d1bfa0c8
			
		while (true) {
			counter++;
			
			if(counter > 2000)
				obs.add(new Obstacle(1000, 600));
			
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
