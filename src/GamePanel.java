import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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
	static int current_state = GAME_STATE;
	static TestBlock oplorom;
	Manager gman;

	public GamePanel() {
		gamespeed = new Timer(1000 / 60, this);
		font1 = new Font("Arial", 0, 24);
		// oplorom = new TestBlock(this, gman, Runner.width - (75 / 2), Runner.width -
		// (75 / 2), 75, 75);
		// gman.addObject(oplorom);
		System.out.println("Constructed.");
		/*
		 * image import format try { morrowright =
		 * ImageIO.read(this.getClass().getResourceAsStream("MorrowRight.jpg")); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

	}

	public void startGame() {
		oplorom = new TestBlock(this, gman, Runner.width - (75 / 2), Runner.width - (75 / 2), 75, 75);
		gman = new Manager();
		gman.addObject(oplorom);
		gamespeed.start();

		System.out.println("Started.");
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_UP) {
			oplorom.yspeedAdder = -1;
		} else if (e.getKeyChar() == KeyEvent.VK_DOWN) {
			oplorom.yspeedAdder = 1;
		} else if (e.getKeyChar() == KeyEvent.VK_RIGHT) {
			oplorom.xspeedAdder = 1;
		} else if (e.getKeyChar() == KeyEvent.VK_LEFT) {
			oplorom.xspeedAdder = -1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void drawMenuState(Graphics graphix) {
		graphix.setColor(Color.blue);
		graphix.fillRect(0, 0, Runner.width, Runner.height);
		System.out.println("Menu drawn.");
	}

	private void updateMenuState() {

	}

	private void drawGameState(Graphics graphix) {
		if (oplorom != null) {
			graphix.setColor(Color.darkGray);
			graphix.fillRect(0, 0, Runner.width, Runner.height);
			if (gman != null) {
				gman.draw(graphix);
			}
		}
		System.out.println("Game drawn.");
	}

	private void updateGameState() {
		System.out.println("Game updated.");
		gman.update();
	}

	private void drawPauseState(Graphics graphix) {
		System.out.println("Game, paused, drawn.");
	}

	private void updatePauseState() {
		System.out.println("Game, paused, updated.");
	}

	protected void paintComponent(Graphics graphix) {
		super.paintComponent(graphix);
		System.out.println("PaintComponent.");
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
		System.out.println("ActionPerformed.");
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
