import java.awt.Color;
import java.awt.Graphics;

public class TestBlock extends BasicObject {

	GamePanel gpanelAmbassador;
	Manager manager;
	int xspeed;
	int yspeed;
	// hey Shiv! the speed modifiers are a duo set that work in sequence. The f l u
	// x modifiers modify the direct speed modifiers. These flux modifiers will
	// always be between -2 and 2, inclusive. However, the speed modifiers have no
	// bounds. This is a fun little acceleration trick.
	public int yFlux;
	public int xFlux;

	public TestBlock(GamePanel gpanelAmbassador, Manager manager, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.gpanelAmbassador = gpanelAmbassador;
		this.manager = manager;
		yspeed = 0;
		xspeed = 0;
		yFlux = 0;
		xFlux = 0;
	}

	@Override
	public void update() {
		super.update();
		yspeed += yFlux;
		xspeed += xFlux;
		y += yspeed;
		x += xspeed;
		// System.out.println("x flux: " + xFlux);
	}

	@Override
	public void draw(Graphics gpx) {
		gpx.setColor(Color.white);
		gpx.fillRect(x, y, width, height);
		// System.out.println("x " + x + " y " + y);
		// gpx.drawImage(Panel.enemy, x, y, width, height, null);
	}

}
