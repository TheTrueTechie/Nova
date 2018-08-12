import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class GamePanel implements ActionListener {
	Timer gamespeed;
	Font font1;

	public GamePanel() {
		gamespeed = new Timer(1000 / 60, this);
		font1 = new Font("Arial", 0, 24);

		/*
		 * try { morrowright =
		 * ImageIO.read(this.getClass().getResourceAsStream("MorrowRight.jpg")); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void startGame() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
