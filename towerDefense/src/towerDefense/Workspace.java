package towerDefense;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Workspace extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
	ArrayList <Towers> towers = new ArrayList<>();
	Towers tower;
	ArrayList <Enemies> enemies = new ArrayList<>();
	Enemies enemy;
	boolean lowerEntrance = false;
	boolean upperEntrance = false;
	boolean centerSpace = false;
	boolean upperEnding = false;
	boolean lowCenter = false;
	boolean lowEnding = false;
	boolean centerEnding = false;
	boolean menuIsOpen = false;
	boolean leftTowerHoveredOver = false;
	boolean centerTowerHoveredOver = false;
	boolean rightTowerHoveredOver = false;
	boolean leftTowerIsSelected = false;
	boolean centerTowerIsSelected = false;
	boolean rightTowerIsSelected = false;
	boolean startButtonHoveredOver = false;
	int summonTowerX = 0;
	int summonTowerY = 0;
	int timesClicked = 0;
	int life = 5;
	double currency = 0;
	boolean start = false;
	Timer t = new Timer(5, this);
	public Workspace() {
		addMouseMotionListener(this);
		addMouseListener(this);
		t.start();
		t.addActionListener(this);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		setOpaque(true);
		paintBackground(g);
		paintCurrency(g);
		paintLife(g);
		if(!menuIsOpen) {
		paintMarkers(g);
		}
	
		for(int n = 0; n < towers.size(); n++) {
			tower = towers.get(n);
			tower.paintTower(g);
			}
		if (menuIsOpen) {
			paintMenu(g);
			}
		for(int n = 0; n < enemies.size(); n++) {
			enemy = enemies.get(n);
			enemy.paintEnemies(g);
		}
	}
	
	void paintCurrency(Graphics g) {
		Font font = new Font("Aerial Black", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Currency: "+ currency+" $", 30, 650);
	}
	
	void paintLife(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Life: "+ life, 30, 670);
	}
	
	void paintBackground(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1200, 1000);
		g.setColor(Color.green);
		g.fillRect(0, 0, 1200, 200);
		g.fillRect(0, 300, 300, 700);
		g.fillRect(400, 200, 300, 300);
		g.fillRect(250, 600, 350, 400);
		g.fillRect(800, 300, 400, 100);
		g.fillRect(900, 400, 400, 100);
		g.fillRect(700, 500, 100, 300);
		g.fillRect(800, 600, 200, 200);
		g.fillRect(1100, 500, 200, 600);
		g.fillRect(600, 900, 500, 100);
		g.setColor(Color.yellow);
		g.fillRect(400, 0, 300, 200);
		g.fillRect(0, 600, 300, 700);
		g.setColor(Color.black);
		g.fillRect(450, 40, 200, 100);
		Font font = new Font("Aerial Black", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Start", 490, 105);
	}
	
	private void paintMarkers(Graphics g) {
		if(lowerEntrance) {
			g.setColor(Color.red);
			//vänster hörn
			g.fillRect(0, 300, 50, 20);
			g.fillRect(0, 300, 20, 50);
			//höger
			g.fillRect(250, 300, 50, 20);
			g.fillRect(280, 300, 20, 50);
			
			g.fillRect(0, 550, 20, 50);
			g.fillRect(0, 580, 50, 20);
			
			g.fillRect(280, 550, 20, 50);
			g.fillRect(250, 580, 50, 20);
			
		}
		if(upperEntrance) {
			g.setColor(Color.red);
			g.fillRect(0, 0, 50, 20);
			g.fillRect(0, 0, 20, 50);
			
			g.fillRect(0, 180, 50, 20);
			g.fillRect(0, 150, 20, 50);
			
			g.fillRect(380, 0, 20, 50);
			g.fillRect(350, 0, 50, 20);
			
			g.fillRect(380, 150, 20, 50);
			g.fillRect(350, 180, 50, 20);
		}
		if (centerSpace) {
			g.setColor(Color.red);
			g.fillRect(400, 200, 50, 20);
			g.fillRect(400, 200, 20, 50);
			
			g.fillRect(400, 480, 50, 20);
			g.fillRect(400, 450, 20, 50);
			
			g.fillRect(680, 200, 20, 50);
			g.fillRect(650, 200, 50, 20);
			
			g.fillRect(680, 450, 20, 50);
			g.fillRect(650, 480, 50, 20);
		}
		if (upperEnding) {
			g.setColor(Color.red);
			g.fillRect(700, 0, 50, 20);
			g.fillRect(700, 0, 20, 50);
			
			g.fillRect(700, 180, 50, 20);
			g.fillRect(700, 150, 20, 50);
			
			g.fillRect(1165, 0, 20, 50);
			g.fillRect(1135, 0, 50, 20);
			
			g.fillRect(1165, 150, 20, 50);
			g.fillRect(1135, 180, 50, 20);
		}
		if (lowCenter) {
			g.setColor(Color.red);
			g.fillRect(300, 600, 50, 20);
			g.fillRect(300, 600, 20, 50);
			
			g.fillRect(300, 880, 50, 20);
			g.fillRect(300, 850, 20, 50);
			
			g.fillRect(580, 600, 20, 50);
			g.fillRect(550, 600, 50, 20);
			
			g.fillRect(580, 850, 20, 50);
			g.fillRect(550, 880, 50, 20);
		}
		
		if (lowEnding) {
			g.setColor(Color.red);
			g.fillRect(700, 600, 50, 20);
			g.fillRect(700, 600, 20, 50);
			
			g.fillRect(700, 780, 50, 20);
			g.fillRect(700, 750, 20, 50);
			
			g.fillRect(980, 600, 20, 50);
			g.fillRect(950, 600, 50, 20);
			
			g.fillRect(980, 750, 20, 50);
			g.fillRect(950, 780, 50, 20);
		}
		if (centerEnding) {
			g.setColor(Color.red);
			g.fillRect(900, 300, 50, 20);
			g.fillRect(900, 300, 20, 50);
			
			g.fillRect(900, 480, 50, 20);
			g.fillRect(900, 450, 20, 50);
			
			g.fillRect(1165, 300, 20, 50);
			g.fillRect(1135, 300, 50, 20);
			
			g.fillRect(1165, 450, 20, 50);
			g.fillRect(1135, 480, 50, 20);
		}
		if(startButtonHoveredOver) {
			g.setColor(Color.CYAN);
			g.fillRect(450, 40, 10, 35);
			g.fillRect(450, 40, 35, 10);
			
			g.fillRect(450, 105, 10, 35);
			g.fillRect(450, 130, 35, 10);
			
			g.fillRect(640, 40, 10, 35);
			g.fillRect(615, 40, 35, 10);
			
			g.fillRect(640, 105, 10, 35);
			g.fillRect(615, 130, 35, 10);
		}
		
		
	}
	
	private void paintMenu(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(250, 700, 650, 600);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(300,755, 150, 150);
		g.fillRect(500,755, 150, 150);
		g.fillRect(700,755, 150, 150);
		g.setColor(Color.red);
		g.fillRect(840, 700, 60, 30);
		g.setColor(Color.black);
		g.drawLine(855, 705, 885, 725);
		g.drawLine(885, 705, 855, 725);
		for(int n = 1; n < 4; n++) {
			Color c = Color.black;
			switch(n) {
			case 1:
				c = Color.blue;
				break;
			case 2:
				c = Color.yellow;
				break;
			case 3:
				c = Color.red;
				break;
			}
			g.setColor(c);
			g.drawString(Math.floor(15+n*Math.pow(n, 2*n)+(n*Math.pow(n, 5)))+ "$", 350+200*(n-1), 770);
		g.fillRect((375+(200*(n-1)))-(40/2), 830-(40/2), 40, 40);
		g.fillRect((375+(200*(n-1)))-(40/8), 830-40, 40/4, 40*2);
		g.fillRect((375+(200*(n-1)))-40, 830-(40/8), 40*2, 40/4);
		}

		g.setColor(Color.red);
		if (leftTowerHoveredOver) {
			g.fillRect(300, 755, 35, 10);
			g.fillRect(300, 755, 10, 35);
			g.fillRect(300, 895, 35, 10);
			g.fillRect(300, 870, 10, 35);
			g.fillRect(415, 895, 35, 10);
			g.fillRect(440, 870, 10, 35);
			g.fillRect(415, 755, 35, 10);
			g.fillRect(440, 755, 10, 35);
		}
		if (centerTowerHoveredOver) {
			g.fillRect(500, 755, 35, 10);
			g.fillRect(500, 755, 10, 35);
			g.fillRect(500, 895, 35, 10);
			g.fillRect(500, 870, 10, 35);
			g.fillRect(615, 895, 35, 10);
			g.fillRect(640, 870, 10, 35);
			g.fillRect(615, 755, 35, 10);
			g.fillRect(640, 755, 10, 35);
		}
		if (rightTowerHoveredOver) {
			g.fillRect(700, 755, 35, 10);
			g.fillRect(700, 755, 10, 35);
			g.fillRect(700, 895, 35, 10);
			g.fillRect(700, 870, 10, 35);
			g.fillRect(815, 895, 35, 10);
			g.fillRect(840, 870, 10, 35);
			g.fillRect(815, 755, 35, 10);
			g.fillRect(840, 755, 10, 35);
		}
	}

	
	public void openMenu(int x, int y) {

		//kontrollerar vilken ruta
		if(x > 0 && x < 300 && y > 300 && y < 600 ) {
			lowerEntrance = true;
			summonTowerX = 150;
			summonTowerY = 450;
		}
		
		if(x > 0 && x < 400 && y > 0 && y < 200) {
			upperEntrance = true;
			summonTowerX = 200;
			summonTowerY = 100;
		}
		if(x > 400 && x < 700 && y > 200 && y < 500) {
			centerSpace = true;
			 summonTowerX = 550;
			 summonTowerY = 350;
		}
		
		if(x > 700 && x < 1200 && y > 0 && y < 200) {
			upperEnding = true;
			summonTowerX = 940;
			summonTowerY = 100;
		}
		
		if(x > 300 && x < 600 && y > 600 && y < 1000) {
			lowCenter = true;
			summonTowerX = 450;
			summonTowerY = 750;
		}
		
		if(x > 700 && x < 1000 && y > 600 && y < 800) {
			lowEnding = true;
			summonTowerX = 850;
			summonTowerY = 700;
		}
		if(x > 900 && x < 1200 && y > 300 && y < 500) {
			centerEnding = true;
			summonTowerX = 1040;
			summonTowerY = 400;
		}
		
	}
	
	public void towerIsBought(String towerSelected) {
		switch(towerSelected) {
		case "leftTowerIsSelected":
			summonTower(Color.blue, 1);
			break;
		case "centerTowerIsSelected":
			summonTower(Color.yellow, 2);
			break;
		case "rightTowerIsSelected":
			summonTower(Color.red, 3);
			break;
		}

	}
	
	public void summonTower(Color c, int d) {

		tower = new Towers(summonTowerX, summonTowerY, c, d);
		towers.add(tower);
		menuIsOpen = false;
		
	}
	
	public void startGame() {
		start = true;
		enemy = new Enemies();
		enemies.add(enemy);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(start) {
			t.start();
			for(int n = 0; n < enemies.size(); n++) {
				enemy = enemies.get(n);
				enemy.moveEnemies();
				if(enemy.reachGoal) {
					enemies.remove(n);
					life--;
					if(life == 0) {
						
					}
				}
		}
		
	}
		repaint();
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() > 450 && e.getX() < 650 && e.getY() > 40 && e.getY() < 140) {
			startGame();
		}
		else if(!menuIsOpen) {
			if(lowerEntrance || upperEntrance || centerSpace || centerEnding || lowEnding || upperEnding ||  lowCenter) {
			openMenu(e.getX(), e.getY());
			menuIsOpen = true;}
		}
		else if(menuIsOpen) {
			if(e.getX() > 840 && e.getX() < 900 && e.getY() > 700 && e.getY() < 730) {
				menuIsOpen = false;
			}
			else if (e.getX() > 300 && e.getX() < 450 && e.getY() > 755 && e.getY() < 905){
			towerIsBought("leftTowerIsSelected");
			}
		
		else if (e.getX() > 500 && e.getX() < 650 && e.getY() > 755 && e.getY() < 905) {
			towerIsBought("centerTowerIsSelected");
		}
		else if(e.getX() > 700 && e.getY() < 850 && e.getY() > 755 && e.getY() < 905) {
			towerIsBought("rightTowerIsSelected");
		}
		}
		repaint();
		timesClicked +=1;
		System.out.print(timesClicked);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(!menuIsOpen) {
		if(e.getX() > 0 && e.getX() < 300 && e.getY() > 300 && e.getY() < 600 ) {
			lowerEntrance = true;
			
		}
		else {
			lowerEntrance = false;
		}
		
		if(e.getX() > 0 && e.getX() < 400 && e.getY() > 0 && e.getY() < 200) {
			upperEntrance = true;
			
		}
		else {
			upperEntrance = false;
		}
		if(e.getX() > 400 && e.getX() < 700 && e.getY() > 200 && e.getY() < 500) {
			 centerSpace = true;
			
		}
		else {
			 centerSpace = false;
		}
		
		if(e.getX() > 700 && e.getX() < 1200 && e.getY() > 0 && e.getY() < 200) {
			upperEnding = true;
			
		}
		else {
			upperEnding = false;
		}
		
		if(e.getX() > 300 && e.getX() < 600 && e.getY() > 600 && e.getY() < 900) {
			lowCenter = true;
			
		}
		else {
			lowCenter = false;
		}
		
		if(e.getX() > 700 && e.getX() < 1000 && e.getY() > 600 && e.getY() < 800) {
			lowEnding = true;
			
		}
		else {
			lowEnding = false;
		}
		
		if(e.getX() > 900 && e.getX() < 1200 && e.getY() > 300 && e.getY() < 500) {
			centerEnding = true;
			
		}
		else {
			centerEnding = false;
		}
		if(e.getX() > 450 && e.getX() < 600 && e.getY() > 40 && e.getY() < 140) {
			startButtonHoveredOver = true;
		}
		else {
			startButtonHoveredOver = false;
		}
		}
		if(menuIsOpen) {
			if(e.getX() > 300 && e.getX() < 450 && e.getY() > 755 && e.getY() < 905) {
				leftTowerHoveredOver = true;
			}
			else {
				leftTowerHoveredOver = false;
			}
			
			if(e.getX() > 500 && e.getX() < 650 && e.getY() > 755 && e.getY() < 905) {
				centerTowerHoveredOver = true;
			}
			else {
				centerTowerHoveredOver = false;
			}

			if(e.getX() > 700 && e.getX() < 850 && e.getY() > 755 && e.getY() < 905) {
				rightTowerHoveredOver = true;
			}
			else {
				rightTowerHoveredOver = false;
			}

		}
		repaint();
		
	}

}
