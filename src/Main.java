import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
// Main was worked on by all three students

public class Main {

	public static void main(String[] args) {
		
		EZ.initialize(900, 600);
		EZImage shark = EZ.addImage("Shark.png", -115, 275);
		Background background = new Background();
		EZSound theme = EZ.addSound("Theme.wav");
		EZSound ending = EZ.addSound("gameOver.wav");
		Player fish = new Player();
		//intro screen
		Color c = new Color(255,255,0);
		EZText text1 = EZ.addText(450, 400, "PRESS SPACE TO START", c, 80);
		EZText text2 = EZ.addText(450, 450, "DIRECTIONS", c, 50);
		EZText text3 = EZ.addText(450, 480, "AVOID THE SEAWEED BY PRESSING SPACE", c, 50);
		EZText text4 = EZ.addText(450, 200, "FLOPPY FISH", c, 170);
		
		text1.setFont("FlappyBirdy.ttf"); // set font 
		text2.setFont("FlappyBirdy.ttf"); 
		text3.setFont("FlappyBirdy.ttf"); 
		text4.setFont("FlappyBirdy.ttf");
		
		boolean wait = true;
		
		do{  // while true
			if(EZInteraction.wasKeyPressed('w')) {
				text1.hide();
				text2.hide();
				text3.hide();
				text4.hide();
				wait = false;
			}
		} while(wait);
		
		final int MOVEMENT = -2;
		int counter = 0;
		int score = 0;
		boolean needNew = false;
		boolean needRespawn = false;
		boolean gameOver = false;

		ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
		obs.add(new Obstacle(1000, 600));
		theme.play();
		do {
			score++;
			background.move(MOVEMENT * 1.25);
			fish.move();
			shark.pullForwardOneLayer();
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
					obs.get(i).move(MOVEMENT * 1.25);
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

			for (int i = 0; i < obs.size(); i++) {
				if (obs.get(i).bottom.isPointInElement(fish.picture.getXCenter(), fish.picture.getYCenter())
						|| obs.get(i).top.isPointInElement(fish.picture.getXCenter(), fish.picture.getYCenter())) {
					gameOver = true;
				}
				else if (fish.picture.getYCenter() <= 0 || fish.picture.getYCenter() >= 600) {
					gameOver = true;
				}
			}
			EZ.refreshScreen();

		} while(!gameOver); 
		theme.stop();	
		ending.play();
		EZText theEnd = EZ.addText(900/2, 600/2, "GAME OVER", c, 175);
		EZText endScore = EZ.addText(450, 400, "SCORE: " + score, c, 50);		
		theEnd.setFont("FlappyBirdy.ttf");
		endScore.setFont("Flappy-Bird.ttf");
		for(int i = 0; i < obs.size(); i++) 
			obs.get(i).gameOver();
		
		fish.gameOver();
		
		
		EZ.setBackgroundColor(Color.BLACK);
		
			
	}
	
}
