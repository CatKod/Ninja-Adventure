package objects;

import static utilz.Constants.ObjectConstants.*;

import main.Game;

public class GameContainer extends GameObject {

	public GameContainer(int x, int y, int objType) {
		super(x, y, objType);
		createHitbox();
	}

	private void createHitbox() {
		if (objType == BOX) {
			initHitbox(25, 18);

			xDrawOffset = (int) (27 * Game.SCALE);
			yDrawOffset = (int) (54 * Game.SCALE);

		} else {
			initHitbox(21, 25);
			xDrawOffset = (int) (27 * Game.SCALE);
			yDrawOffset = (int) (54 * Game.SCALE);
		}

		hitbox.y += yDrawOffset - 63;
		hitbox.x += xDrawOffset / 2;
	}

	public void update() {
		if (doAnimation)
			updateAnimationTick();
	}
}
