
public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
		Sprite me = new Sprite("squire_m.png", 100,100,32,48,10);

		while (true) {
			background.move();
			me.go();
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
		}
	}

}
