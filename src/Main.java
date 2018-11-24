import java.util.ArrayList;
// Main was worked on by all three students

public class Main {

	public static void main(String[] args) {
		EZ.initialize(900, 600);
		EZImage shark = EZ.addImage("Shark.png", -115, 300);
		Background background = new Background();
		Player fish = new Player();
		final int MOVEMENT = -2;
		final int SCORE = 0;
		int counter = 0;
		boolean needNew = false;
		boolean needRespawn = false;

		ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
		obs.add(new Obstacle(1000, 600));

		while (true) {
			counter++;
			System.out.println(counter);

			if (counter % 1000 == 0 && obs.size() < 6) {
				needNew = true;
			}

			if (needNew) {
				for (int i = 0; i < obs.size(); i++) {
					if (obs.get(i).posX <= obs.size() * (1000 / (obs.size() + 1))
							&& obs.get(i).posX >= obs.size() * ((1000 / (obs.size() + 1) - 2))) {
						obs.add(new Obstacle(1000, 600));
						needNew = false;
					}
				}
			}

			if (needRespawn) {
				for (int i = 0; i < obs.size(); i++) {
					if (obs.get(i).posX <= obs.size() * (1000 / (obs.size() + 1))
							&& obs.get(i).posX >= obs.size() * ((1000 / (obs.size() + 1) - 2))) {
						obs.add(new Obstacle(1000, 600));
						needRespawn = false;
					}
				}
			}

			for (int i = 0; i < obs.size(); i++) {
				if (obs.get(i).posX > 0) {
					obs.get(i).move(MOVEMENT);
				} else {
					obs.get(i).close();
					obs.remove(i);
					if (obs.size() == 0) {
						obs.add(new Obstacle(1000, 600));
					} else {
						needRespawn = true;
					}
				}
			}
			//if ()
			background.move(MOVEMENT);
			fish.move();
			shark.pullForwardOneLayer();
			EZ.refreshScreen();

		}
	}

}
