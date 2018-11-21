import java.util.Random;

// Obstacle class made by Colin Jackson
public class Obstacle {
	private static int O_NUMBER = 2;//the number of seaweed pictures needed to create an obstacle
	private static int TOP = -100; // since both pictures will use the same Y coordinate this will
								   // be used to adjust the images away from eachother.
	private static int BOTTOM = 100;// " "
	private Random rand;
	EZImage[] obstacle = new EZImage[O_NUMBER];
	int posX, posY;//Both images will share the same x coordinate but there posY will vary slightly
				   // but are based off this single y coordinate.
	
	Obstacle() { //default constructor spawns image off screen.
		posY = -500;
		posX = -500;
		obstacle[0] = EZ.addImage("seaweed.png", posX, posY + TOP);
		obstacle[1] = EZ.addImage("seaweed2.png", posX, posY + BOTTOM);		
	}
	
	Obstacle(int x, int y) { // when we know where we want the image to be call this contructor
		posX = x;
		posY = y;
		obstacle[0] = EZ.addImage("seaweed.png", posX, posY + TOP);
		obstacle[1] = EZ.addImage("seaweed2.png", posX, posY + BOTTOM);	
	}
	
	
	 public void move(int speed) {
		posX += speed;
		for(int i = 0; i < obstacle.length; i++) {
			if(i % 2 == 1) {
				obstacle[i].translateTo(posX, posY + TOP);
			} else {
				obstacle[i].translateTo(posX, posY + BOTTOM);
			}
		}
	}
	
	 public void adjust(int X_MAX) {
		 posY = rand.nextInt(600) + 200;
		 posX = X_MAX;
		 move(0);//calls move function to translate to new location.
	 }
	 
}
