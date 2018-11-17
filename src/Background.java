// class made by David Nguyen
public class Background {
	int x;
	int y;
	EZImage picture1;
	EZImage picture2;

	Background() {
		picture1 = EZ.addImage("Background1.jpg", 1600 / 2, 800 / 2);
		picture2 = EZ.addImage("Background2.jpg", (1600 / 2) + 1600, 800 / 2);
	}

	void move() {
		picture1.moveForward(-2);
		picture2.moveForward(-2);
		if (picture1.getXCenter() < -800) {
			picture1.moveForward(3200);
		} else if (picture2.getXCenter() < -800) {
			picture2.moveForward(3200);
		}
	}
}
