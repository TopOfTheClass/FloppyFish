
public class Main {

	public static void main(String[] args) {
		EZ.initialize(650, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();

		while (true) {
			background.move();
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
		}
	}

}
