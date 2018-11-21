
public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
		

		while (true) {
			background.move();
			fish.move();// use the move function in player class
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
		}
	}

}
