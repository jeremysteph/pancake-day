package cs520.hw4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Legos1 extends JFrame {
	int startX;
	int startY;
	int legoWidth;
	int legoHeight;
	int baseLength;

	public Legos1() {
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
		for (int x = 1; x <= baseLength; x++) {
			g.setColor(Color.RED);

			for (int y = 1; y <= baseLength - x; y++) {
				g.drawRect(startX, startY, legoWidth, legoHeight);
				g.fillRoundRect(startX, startY, legoWidth, legoHeight, 2, 2);

				if (g.getColor() == Color.red) {

					g.setColor(Color.BLUE);
				} else {
					g.setColor(Color.RED);
				}

				startX = (startX + legoWidth);
			}
			startX = (startX / 2) - ((baseLength - x) * legoWidth) / 2 + ((legoHeight * x + legoWidth) / 2) + x / 2;

			startY = startY - legoHeight;
		}
	}

	public static void main(String[] args) {
		Legos1 l = new Legos1();
		l.setSize(550, 325);
		l.setVisible(true);
		l.repaint();
	}

}
