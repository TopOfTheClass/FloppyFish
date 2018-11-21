
public class Main {

	public static void main(String[] args) {
		EZ.initialize(1000, 800);
		EZImage shark = EZ.addImage("Shark.png", -150, 350);
		Background background = new Background();
		Player fish = new Player();
<<<<<<< HEAD
		

		while (true) {
			background.move();
			fish.move();// use the move function in player class
=======
		Sprite me = new Sprite("squire_m.png", 100,100,32,48,10);
	final int MOVEMENT = -2;
			
		while (true) {
			background.move(MOVEMENT);
			me.go();
>>>>>>> 6032478785342ee87e012c0428c78facef533d50
			shark.pullForwardOneLayer();
			EZ.refreshScreen();
		}
	}

}
