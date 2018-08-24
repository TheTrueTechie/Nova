
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	static final int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	String gameVersion = ".02 Alpha";

	GamePanel gamePanel;
	JFrame mainFrame;

	public Runner() {
		gamePanel = new GamePanel();

		mainFrame = new JFrame();

	}

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run();
	}

	void run() {
		mainFrame.add(gamePanel);
		mainFrame.setTitle("Nova " + gameVersion);
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.startGame();
		System.out.println("Runner done.");
	}
}