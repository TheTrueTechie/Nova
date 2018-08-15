import java.awt.Color;
import java.awt.Graphics;

public class TestBlock extends BasicObject {

	GamePanel gpanelAmbassador;
	Manager manager;
	int xspeed;
	int yspeed;
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
	}

	@Override
	public void draw(Graphics gpx) {
		gpx.setColor(Color.black);
		gpx.fillRect(x, y, width, height);
		// gpx.drawImage(Panel.enemy, x, y, width, height, null);
	}

}
