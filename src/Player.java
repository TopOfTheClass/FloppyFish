// Player class made by Brody Uehara, used private variables

import java.awt.event.KeyEvent;

public class Player {
	private int x;
	private int y;
	private boolean isPressed = false;
	private int moveCount = 0;

	EZImage picture;
	EZSound sound;

	Player() { // our constructor
		x = 300; // set x to 300
		y = 300; // set y to 300
		picture = EZ.addImage("fish.png", x, y); // add image fish.png into picture at the given the x and y integers
		sound = EZ.addSound("Drop.wav");
	}


	void move() { // set up move method

		if (EZInteraction.wasKeyReleased(KeyEvent.VK_SPACE) && isPressed == false) { // if the w key is pressed down
			sound.play();
			isPressed = true;
		} 
		
		if(isPressed && moveCount < 7) { //if is pressed is true and move count is less than 7
			y -= 11; //move up 11 units
			moveCount++; //increase move count
		} else if(moveCount >= 7) { //if movecount is greater than 7
			isPressed = false; //key pressed is false
			moveCount = 0; //make movecount 0
			y+= 3; //move down 3
		} else { //or else fall by 3
			y += 3;
		}

		// limits for the fish
		if (picture.getYCenter() <= 0) { // if the surfers Y position is less than or equal to 0:
			y = y + 25; // move the surfers Y position up 10 units on the y-axis
		} else if (picture.getYCenter() >= 600) { // if the surfers Y position is greater than or equal to 768:
			y = y - 3; // move the surfer down 10 units on the y-axis
		}
		picture.translateTo(x, y); // translate picture to x and y coordinates
	}
	
	public void gameOver() { //created gameover stuff
		do{ //rotate objects and make them fall
			y += 5;
			picture.rotateBy(10);
			picture.translateTo(x, y);
			EZ.refreshScreen();
		} while(y < 800);
	}
	public int getX() { //because x is a private variable 
		return x;
	}
	
	public int getY() { //because y is a private variable
		return y;
	}
	
}
