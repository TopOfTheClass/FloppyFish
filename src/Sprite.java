public class Sprite {
	
	EZImage spriteSheet;
	
	
	int x = 0;				// Position of Sprite
	int y = 0;
	int spriteWidth;		// Width of each sprite
	int spriteHeight;		// Height of each sprite
	int direction = 0;		// Direction character is walking in
	int walkSequence = 0;	// Walk sequence counter
	int cycleSteps;			// Number of steps before cycling to next animation step
	int counter = 0;		// Cycle counter
	

	Sprite(String imgFile, int startX, int startY, int width, int height, int steps) {
		x = startX;					// position of the sprite character on the screen
		y = startY;
		spriteWidth = width;		// Width of the sprite character
		spriteHeight = height;		// Height of the sprite character
		cycleSteps = steps;			// How many pixel movement steps to move before changing the sprite graphic
		spriteSheet = EZ.addImage(imgFile, x, y);
		setImagePosition();
	}

	private void setImagePosition() {
		
		// Move the entire sprite sheet
		spriteSheet.translateTo(x, y);
		
		// Show only a portion of the sprite sheet.
		// Portion is determined by setFocus which takes 4 parameters:
		// The 1st two numbers is the top left hand corner of the focus region.
		// The 2nd two numbers is the bottom right hand corner of the focus region.
		spriteSheet.setFocus(walkSequence * spriteWidth, direction,
				walkSequence * spriteWidth + spriteWidth, direction + spriteHeight);
	}

	public void moveDown(int stepSize) {
		y = y + stepSize;

		direction = 0;

		if ((counter % cycleSteps) == 0) {
			walkSequence++;
			if (walkSequence > 3)
				walkSequence = 0;
		}
		counter++;
		setImagePosition();
	}
	
	public void moveLeft(int stepSize) {
		x = x - stepSize;
		direction = spriteHeight;

		if ((counter % cycleSteps) == 0) {
			walkSequence--;
			if (walkSequence < 0)
				walkSequence = 3;
		}
		counter++;
		setImagePosition();
	}

	public void moveRight(int stepSize) {
		x = x + stepSize;
		direction = spriteHeight * 2;
		
		if ((counter % cycleSteps) == 0) {
			walkSequence++;
			if (walkSequence > 3)
				walkSequence = 0;
		}
		counter++;

		setImagePosition();
	}

	public void moveUp(int stepSize) {
		y = y - stepSize;
		direction = spriteHeight * 3;

		if ((counter % cycleSteps) == 0) {
			walkSequence--;
			if (walkSequence < 0)
				walkSequence = 3;
		}
		setImagePosition();

		counter++;
	}


	// Keyboard controls for moving the character.
	public void go() {
		if (EZInteraction.isKeyDown('w')) {
			moveUp(2);
		} else if (EZInteraction.isKeyDown('a')) {
			moveLeft(2);
		} else if (EZInteraction.isKeyDown('s')) {
			moveDown(2);
		} else if (EZInteraction.isKeyDown('d')) {
			moveRight(2);
		}
	}

}
