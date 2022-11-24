package towerDefense;

import javax.swing.JFrame;

public class MainMethod {
	public static void main(String[]args) {
		JFrame main = new JFrame();
		Workspace panel = new Workspace();
		main.setBounds(0, 0, 1200, 1000);
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		main.setTitle("NADA");
		main.setLocationRelativeTo(null);
	    main.add(panel);
	    panel.setFocusable(true);
	    panel.requestFocus();
	}

}
