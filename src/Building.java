import java.awt.Color;
import java.awt.Graphics;

public class Building extends BasicObject {
	int basehealth;
	int health;
	Color deep = new Color(200, 70, 70);

	public Building(int x, int y, int width, int height, int baseHealth) {
		super(x, y, width, height);
		basehealth = baseHealth;
		health = basehealth;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		g.setColor(deep);
		g.fillRect(x, y, width, height);
	}
}
