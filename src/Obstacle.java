import java.util.Random;

// Obstacle class made by Colin Jackson
public class Obstacle {

	private static int TOP = -250; // since both pictures will use the same Y coordinate this will
									// be used to adjust the images away from eachother.
	private static int BOTTOM = 250;// " "
	private Random rand = new Random();
	EZImage top; // The obstacle is made of a top and bottom image.
	EZImage bottom;
	int posX, posY, botY, topY;// Both images will share the same x coordinate but there posY will vary
								// slightly
	// but are based off this single y coordinate.

	Obstacle() { // default constructor spawns image off screen.
		posY = -500;
		posX = -500;
		top = EZ.addImage("TopWeed.png", posX, posY + TOP);
		bottom = EZ.addImage("BottomWeed.png", posX, posY + BOTTOM);
	}

	Obstacle(int x, int y) { // when we know where we want the image to be call this contructor
		posX = x;
		posY = rand.nextInt(225) + 175;
		botY = posY + BOTTOM;
		topY = posY + TOP;
		top = EZ.addImage("TopWeed.png", posX, posY + TOP);
		bottom = EZ.addImage("BottomWeed.png", posX, posY + BOTTOM);
		EZ.refreshScreen();
	}

	void close() {
		EZ.removeEZElement(top);
		EZ.removeEZElement(bottom);
		EZ.refreshScreen();
	}

	public void move(double speed) {
		posX += speed;
		top.translateTo(posX, topY);
		bottom.translateTo(posX, botY);
	}

	public void adjust(int X_MAX) {

		botY = 0;
		topY = 0;
		posY = rand.nextInt(230) + 175;
		botY = posY + BOTTOM;
		topY = posY + TOP;
		posX = X_MAX;
		move(0);// calls move function to translate to new location.
	}
	
	public void gameOver() {
		do {
			topY += 5;
			botY += 5;
			top.rotateBy(10);
			bottom.rotateBy(10);
			top.translateTo(posX, topY);
			bottom.translateTo(posX, botY);
			EZ.refreshScreen();
		}while(topY < 800 || botY < 800);
	}

}
