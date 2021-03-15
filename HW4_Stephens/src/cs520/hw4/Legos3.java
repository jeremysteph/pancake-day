package cs520.hw4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;

public class Legos3 extends JFrame {
	int startX;
	int startY;
	int legoWidth;
	int legoHeight;
	int baseLength;
	Color[] colors = { Color.BLACK, Color.BLUE, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.ORANGE,
			Color.RED, Color.PINK };

	public Legos3() {
		super("Stephens' Legos");
		startX = 20;
		startY = 300;
		legoWidth = 50;
		legoHeight = 20;
		baseLength = 10;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void paint(Graphics g) {
		int presentX = startX;
		int presentY = startY;
		Random random = new Random();
		Color currentColor;

		for (int x = 1; x <= baseLength; x++) {

			for (int y = 1; y <= baseLength - x; y++) {
				g.drawRect(startX, startY, legoWidth, legoHeight);
				g.fillRoundRect(startX, startY, legoWidth, legoHeight, 2, 2);
				currentColor = g.getColor();
				do {
					g.setColor(colors[random.nextInt(colors.length)]);

				} while (currentColor == colors[random.nextInt(colors.length)]);

				startX = (startX + legoWidth);
			}
			startX = (startX / 2) - ((baseLength - x) * legoWidth) / 2 + ((legoHeight * x + legoWidth) / 2) + x / 2;

			startY = startY - legoHeight;
		}
	}

	public static void main(String[] args) {
		Legos3 l = new Legos3();
		l.setSize(550, 325);
		l.setVisible(true);
		l.repaint();
	}

}
