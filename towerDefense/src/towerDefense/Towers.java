package towerDefense;

import java.awt.Color;
import java.awt.Graphics;

public class Towers {
	int x = 0;
	int y = 0;
	int r = 70;
	int damage = 0;
	Color c = Color.black;
	public Towers(int x, int y, Color c, int d) {
		this.x = x;
		this.y = y;
		this.c = c;
		damage = d;
		
	}
	
	public void paintTower(Graphics g) {
		g.setColor(c);
		g.fillRect(x-(r/2), y-(r/2), r, r);
		g.fillRect(x-(r/8), y-r, r/4, r*2);
		g.fillRect(x-r, y-(r/8), r*2, r/4);
		}
}
