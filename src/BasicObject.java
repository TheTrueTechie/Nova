import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BasicObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	public int gravispeed = 1;
	public boolean lockedInPlace;
	Rectangle collisionArea = new Rectangle(x, y, width, height);
	public int yspeedAdder;
	public int xspeedAdder;

	public BasicObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void update() {
		collisionArea.setBounds(x, y, width, height);

	}

	public void draw(Graphics g) {
	}

}