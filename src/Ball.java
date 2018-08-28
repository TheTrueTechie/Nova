import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends BasicObject {
	int xspeed;
	int yspeed;

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		yspeed = new Random().nextInt(16) - 8;
		;
		xspeed = new Random().nextInt(16) - 8;
		;
	}

	@Override
	public void update() {
		super.update();
		if ((y <= 0) || ((y + height) >= Runner.height)) {
			// yspeed/* = new Random().nextInt(16) - 8 */++;
			yspeed = -yspeed;
			yspeed += yspeed > 0 ? 1 : -1;
		}
		if ((x <= 0) || ((x + width) >= Runner.width)) {
			// xspeed/* = new Random().nextInt(16) - 8 */++;
			xspeed = -xspeed;
			xspeed += xspeed > 0 ? 1 : -1;
		}
		y += yspeed;
		x += xspeed;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		super.draw(g);
	}
}
