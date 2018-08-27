import java.awt.Color;
import java.awt.Graphics;

public class CheckCollisionCatcher extends BasicObject {
	public CheckCollisionCatcher(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		collisionArea.setBounds(x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width, height);

	}

}
