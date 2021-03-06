import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer gamespeed;
	Font font1;
	final static int MENU_STATE = 0;
	final static int GAME_STATE = 1;
	final static int PAUSE_STATE = 2;
	final static int END_STATE = 3;
	static int current_state = GAME_STATE;
	static TestBlock oplorom;
	Manager gman;
	Ball ball;
	CheckCollisionCatcher collisioncheckobj;
	Building base1;
	Building base2;
	Building base3;
	Building base4;
	static int numDeaths;

	public GamePanel() {
		gamespeed = new Timer(1000 / 60, this);
		font1 = new Font("Arial", 0, 24);
		// oplorom = new TestBlock(this, gman, Runner.width - (75 / 2), Runner.width -
		// (75 / 2), 75, 75);
		// gman.addObject(oplorom);
		// System.out.println("Constructed.");
		/*
		 * image import format try { morrowright =
		 * ImageIO.read(this.getClass().getResourceAsStream("MorrowRight.jpg")); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

	}

	public void startGame() {
		numDeaths = 0;
		base1 = new Building(Runner.width / 4, Runner.height / 4, 100, 100, 100);
		base2 = new Building(Runner.width / 4 * 3, Runner.height / 4, 100, 100, 100);
		base3 = new Building(Runner.width / 4, Runner.height / 4 * 3, 100, 100, 100);
		base4 = new Building(Runner.width / 4 * 3, Runner.height / 4 * 3, 100, 100, 100);
		collisioncheckobj = new CheckCollisionCatcher(0, 0, Runner.width, Runner.height);
		ball = new Ball(100, 100, 40, 40);
		oplorom = new TestBlock(this, gman, (Runner.width / 2) - (75 / 2), (Runner.height / 2) - (75 / 2), 75, 75);
		System.out.println(oplorom.x + " . " + oplorom.y);
		gman = new Manager();
		gman.addObject(collisioncheckobj);
		gman.addObject(ball);
		gman.addObject(oplorom);
		gman.addObject(base1);
		gman.addObject(base2);
		gman.addObject(base3);
		gman.addObject(base4);
		gamespeed.start();

		// System.out.println("Started.");
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			oplorom./* yFlux */yspeed = -5;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			oplorom./* yFlux */yspeed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			oplorom./* xFlux */xspeed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			oplorom./* xFlux */xspeed = -5;
		}
		// System.out.println("keypressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		oplorom.yspeed = 0;
		oplorom.xspeed = 0;
	}

	private void drawMenuState(Graphics graphix) {
		graphix.setColor(Color.blue);
		graphix.fillRect(0, 0, Runner.width, Runner.height);
		// System.out.println("Menu drawn.");
	}

	private void updateMenuState() {

	}

	private void drawGameState(Graphics graphix) {
		if (oplorom != null) {
			// graphix.setColor(Color.darkGray);
			// graphix.fillRect(0, 0, Runner.width, Runner.height);
			if (gman != null) {
				gman.draw(graphix);
			}
		}
		// System.out.println("Game drawn.");
	}

	private void updateGameState() {
		// System.out.println("Game updated.");
		/*
		 * if (oplorom.isAlive == false) { System.out.println("dead"); oplorom.isAlive =
		 * true; addZombie(oplorom); }
		 */
		gman.update();
		gman.checkCollision();
		if ((base1.isAlive == false) && (base2.isAlive == false) && (base3.isAlive == false)
				&& (base4.isAlive == false)) {
			current_state = END_STATE;
		}

	}

	private void drawPauseState(Graphics graphix) {
		// System.out.println("Game, paused, drawn.");
	}

	private void updatePauseState() {
		// System.out.println("Game, paused, updated.");
	}

	private void drawEndState(Graphics graphix) {
		graphix.setColor(Color.red);
		graphix.fillRect(0, 0, Runner.width, Runner.height);
	}

	private void updateEndState() {
		// System.out.println("Game, paused, updated.");
	}

	protected void paintComponent(Graphics graphix) {
		super.paintComponent(graphix);
		// System.out.println("PaintComponent.");
		if (current_state == MENU_STATE) {
			drawMenuState(graphix);
		} else if (current_state == GAME_STATE) {
			drawGameState(graphix);
		} else if (current_state == PAUSE_STATE) {
			drawPauseState(graphix);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("ActionPerformed.");
		repaint();
		// paintComponent(this.getGraphics());
		if (current_state == MENU_STATE) {
			updateMenuState();
		} else if (current_state == GAME_STATE) {
			updateGameState();
		} else if (current_state == PAUSE_STATE) {
			updatePauseState();
		}
	}
}
