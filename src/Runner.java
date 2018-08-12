
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	static final int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	GamePanel gamePanel;
	JFrame mainFrame;
	JPanel mainPanel;

	public Runner() {
		mainFrame = new JFrame();
		gamePanel = new GamePanel();
		run();
	}

	public static void main(String[] args) {
		Runner runner = new Runner();
	}

	void run() {
		mainFrame.add(mainPanel);
		
		mainFrame.setSize(width, height);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}