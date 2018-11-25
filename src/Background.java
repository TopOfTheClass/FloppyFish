

// class made by David Nguyen, used private variables
public class Background {
	private int x = 1600;
	private int y = 800;
	EZImage picture1;
	EZImage picture2;

	Background() {
		picture1 = EZ.addImage("Background1.jpg", x / 2, y / 2);
		picture2 = EZ.addImage("Background2.jpg", (x / 2) + x, y / 2);
	}

	void move(double z) {
		picture1.moveForward(z);
		picture2.moveForward(z);
		if (picture1.getXCenter() < -y) {
			picture1.moveForward(x * 2);
		} else if (picture2.getXCenter() < -y) {
			picture2.moveForward(x * 2);
		}
	}
}
