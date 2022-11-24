package towerDefense;

import java.awt.Color;
import java.awt.Graphics;

public class Enemies {
	int x = 0; 
	int y = 225;
	int d = 50;
	int speed = 1;
	boolean reachGoal = false;
	
	public Enemies() {
	this.x = x;
	this.y = y;
}
	
	public void moveEnemies() {
		if(x < 335 && y == 225) {
			x += speed;
		}
		else if((x >= 335 && x < 370 && y >= 225 && y < 530)) {
			y += speed;
		}
		
		else if(x >=335 && x < 635 && y == 530 ) {
			x += speed;
		}
		else if(x == 635 && y >= 530 && y < 830 ) {
			y += speed;
		}
		else if(x >= 635 && x < 1035 && y == 830) {
			x += speed;
		}
		else if(x == 1035 && y <= 830 && y > 530 ) {
			y -= speed;
		}
		else if(x<=1035 &&  x >835 && y == 530) {
			x -= speed;
		}
		else if(x == 835 && y <= 530 && y > 430) {
			y -= speed;
		}
		else if(x <= 835 && x > 735 && y == 430) {
			x -= speed;
		}
		else if (x == 735 && y <= 430 && y > 230) {
			y -= speed;
		}
		else if (x >= 735 && y == 230) {
			x += speed;
		}
		if (x >= 1100) {
			reachGoal = true;
		}
	}
	
	public void paintEnemies(Graphics g) {
		g.setColor(Color.cyan);
		g.fillOval(x, y, d, d);
	}
}
