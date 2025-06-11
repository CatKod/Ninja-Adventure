package entities;

import java.awt.geom.Rectangle2D;

import main.Game;

import static utilz.Constants.Gun.*;

public class Gun {
	private Rectangle2D.Float hitbox;
	private int dir;
	private boolean active = true;

	public Gun(int x, int y, int dir) {
		int xOffset = (int) (0 * Game.SCALE);
		int yOffset = (int) (0 * Game.SCALE);

		if (dir == 1)
			xOffset = (int) (0 * Game.SCALE);

		hitbox = new Rectangle2D.Float(x + xOffset, y + yOffset, GUN_WIDTH, GUN_HEIGHT);
		this.dir = dir;
	}

	public void updatePos() {
		hitbox.x += dir * SPEED;
	}

	public void setPos(int x, int y) {
		hitbox.x = x;
		hitbox.y = y;
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

}
