// class made by David Nguyen, used private variables

public class Background {
	private int x = 1600; // set a private variable x of 1600
	private int y = 800; // set a private variable y for 800
	EZImage picture1; // create variable for picture1 with no assignment
	EZImage picture2; // create variable for picture2 with no assignment

	Background() { // create background constructor
		picture1 = EZ.addImage("Background1.jpg", x / 2, y / 2); // put picture1 variable and upload a picture at x/2 and y/2 values
		picture2 = EZ.addImage("Background2.jpg", (x / 2) + x, y / 2); // put picture2 variable and upload the picture at x/2 + x and y/2 values
	}

	void move(double z) { // create a method called move that pulls variable of type double
		picture1.moveForward(z); // move picture1 forward the value of z
		picture2.moveForward(z); // move picture2 forward the value of z
		if (picture1.getXCenter() < -y) { // if picture reaches -y, then move picture forward x*2
			picture1.moveForward(x * 2);
		} else if (picture2.getXCenter() < -y) { // // if picture2 reaches -y, then move picture forward x*2
			picture2.moveForward(x * 2);
		}
	}
}
