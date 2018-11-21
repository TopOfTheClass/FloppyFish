// Main was worked on by all three students

public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
		final int MOVEMENT = -2;
		final int SCORE = 0;
			
		while (true) {
			background.move(MOVEMENT);
			fish.move();
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
			
		}
	}

}
