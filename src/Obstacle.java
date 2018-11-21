import java.util.Random;

// Obstacle class made by Colin Jackson
public class Obstacle {
	private static int TOP = -300; // since both pictures will use the same Y coordinate this will
								   // be used to adjust the images away from eachother.
	private static int BOTTOM = 300;// " "
	private Random rand;
	EZImage top; //The obstacle is made of a top and bottom image.
	EZImage bottom;
	int posX, posY, botY, topY;//Both images will share the same x coordinate but there posY will vary slightly
				   // but are based off this single y coordinate.
	
	Obstacle() { //default constructor spawns image off screen.
		posY = -500;
		posX = -500;
		top = EZ.addImage("TopWeed.png", posX, posY + TOP);
		bottom = EZ.addImage("BottomWeed.png", posX, posY + BOTTOM);		
	}
	
	Obstacle(int x, int y) { // when we know where we want the image to be call this contructor
		posX = x;
		posY = y / 2;
		botY = posY + BOTTOM;
		topY = posY + TOP;
		top = EZ.addImage("TopWeed.png", posX, posY + TOP);
		bottom = EZ.addImage("BottomWeed.png", posX, posY + BOTTOM);	
	}
	
	
	 public void move(int speed) {
		posX += speed;
		top.translateTo(posX, topY);
		bottom.translateTo(posX, botY);
	}
	
	 public void adjust(int X_MAX) {
		 posY = rand.nextInt(500) + 100;
		 botY = posY + botY;
		 topY = posY + topY;
		 posX = X_MAX;
		 move(0);//calls move function to translate to new location.
	 }
	 
}
