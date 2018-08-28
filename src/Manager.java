import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Manager implements ActionListener {
	ArrayList<BasicObject> objects;

	private int score = 0;

	int enemySpawnTime = 900;

	public Manager() {
		objects = new ArrayList<BasicObject>();
	}

	public void addObject(BasicObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			BasicObject o = objects.get(i);
			o.update();

		}

		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			BasicObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void checkCollision() {

		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				BasicObject o1 = objects.get(i);
				BasicObject o2 = objects.get(j);
				if (o1.collisionArea.intersects(o2.collisionArea)) {
					System.out.println("hit");

					if (((o1 instanceof Ball) && (o2 instanceof TestBlock))
							|| ((o2 instanceof Ball) && (o1 instanceof TestBlock))) {

						o1.isAlive = o1 instanceof TestBlock ? false : true;
						o2.isAlive = o2 instanceof TestBlock ? false : true;
						;

					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}