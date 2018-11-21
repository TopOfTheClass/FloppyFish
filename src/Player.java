// Player class made by Brody Uehara
import java.awt.event.KeyEvent;
public class Player {
	private int x;
	private int y;
	static int z; // declare variable z of type static int
	EZImage picture;

	Player() { //our constructor
		x = 250; //set x to 512
		y = 400; //set y to 300
		picture = EZ.addImage("fish.png", x, y); //add image R35 into picture at the given the x and y integers
		}
	
	void move() { //set up move method
		
		if (EZInteraction.wasKeyPressed(KeyEvent.VK_SPACE)) { //if the w key is pressed down
			y = y - 50; //then decrement y by 10
		} else {
			y += 2;
		}
		
		// limits for the fish
		if (y <= 0) { // if the surfers Y position is less than or equal to 0:
			y = y + 50; // move the surfers Y position up 10 units on the y-axis
		} else if (y >= 750) { // if the surfers Y position is greater than or equal to 768:
			y = y - 2; // move the surfer down 10 units on the y-axis
		}
		picture.translateTo(x, y); //translate picture to x and y coordinates
	}
}

