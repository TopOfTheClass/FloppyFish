// Player class made by Brody Uehara

import java.awt.event.KeyEvent;

public class Player {
	private int x;
	private int y;

	EZImage picture;

	Player() { //our constructor
		x = 300; //set x to 300
		y = 400; //set y to 400
		picture = EZ.addImage("fish.png", x, y); //add image fish.png into picture at the given the x and y integers
		}
	
	void move() { //set up move method
		
		if (EZInteraction.wasKeyPressed(KeyEvent.VK_SPACE)) { //if the w key is pressed down
			y = y - 75; //then decrement y by 50
		} else {
			y += 3;
		}
		
		// limits for the fish
		if (picture.getXCenter() <= 0) { // if the surfers Y position is less than or equal to 0:
			y = y + 50; // move the surfers Y position up 10 units on the y-axis
		} else if (picture.getYCenter() >= 750) { // if the surfers Y position is greater than or equal to 768:
			y = y - 10; // move the surfer down 10 units on the y-axis
		}
		picture.translateTo(x, y); //translate picture to x and y coordinates
	}
}

