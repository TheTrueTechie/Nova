
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	static final int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	String gameVersion = ".01 Alpha";

	GamePanel gamePanel;
	JFrame mainFrame;
	JPanel mainPanel;

	public Runner() {
		gamePanel = new GamePanel();

		mainFrame = new JFrame();
		mainPanel = new JPanel();
		run();
	}

	public static void main(String[] args) {
		Runner runner = new Runner();
	}

	void run() {
		mainFrame.add(mainPanel);
		mainFrame.setTitle("Nova " + gameVersion);
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.startGame();
		System.out.println("Runner done.");
	}
}