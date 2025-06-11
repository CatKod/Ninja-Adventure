package utilz;

import main.Game;

public class Constants {

	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static final int ANI_SPEED = 25;

	public static class Dialogue {
		public static final int QUESTION = 0;
		public static final int EXCLAMATION = 1;

		public static final int DIALOGUE_WIDTH = (int) (14 * Game.SCALE);
		public static final int DIALOGUE_HEIGHT = (int) (12 * Game.SCALE);

		public static int GetSpriteAmount(int type) {
			switch (type) {
			case QUESTION, EXCLAMATION:
				return 5;
			}

			return 0;
		}
	}

	public static class Projectiles {
		public static final int CANNON_BALL_DEFAULT_WIDTH = 15;
		public static final int CANNON_BALL_DEFAULT_HEIGHT = 15;

		public static final int CANNON_BALL_WIDTH = (int) (Game.SCALE * CANNON_BALL_DEFAULT_WIDTH);
		public static final int CANNON_BALL_HEIGHT = (int) (Game.SCALE * CANNON_BALL_DEFAULT_HEIGHT);
		public static final float SPEED = 0.75f * Game.SCALE;
	}
	
	public static class Gun {
		public static final int GUN_DEFAULT_WIDTH = 30;
		public static final int GUN_DEFAULT_HEIGHT = 20;

		public static final int GUN_WIDTH = (int) (Game.SCALE * GUN_DEFAULT_WIDTH);
		public static final int GUN_HEIGHT = (int) (Game.SCALE * GUN_DEFAULT_HEIGHT);
		public static final float SPEED = 2f * Game.SCALE;
	}

	public static class ObjectConstants {

		public static final int RED_POTION = 0;
		public static final int BLUE_POTION = 1;
		public static final int BARREL = 2;
		public static final int BOX = 3;
		public static final int SPIKE = 4;
		public static final int CANNON_LEFT = 5;
		public static final int CANNON_RIGHT = 6;
		public static final int RED_POTION_VALUE = 30;
		public static final int BLUE_POTION_VALUE = 50;

		public static final int CONTAINER_WIDTH_DEFAULT = 48;
		public static final int CONTAINER_HEIGHT_DEFAULT = 56;
		public static final int CONTAINER_WIDTH = (int) (Game.SCALE * CONTAINER_WIDTH_DEFAULT);
		public static final int CONTAINER_HEIGHT = (int) (Game.SCALE * CONTAINER_HEIGHT_DEFAULT);

		public static final int POTION_WIDTH_DEFAULT = 14;
		public static final int POTION_HEIGHT_DEFAULT = 24;
		public static final int POTION_WIDTH = (int) (Game.SCALE * POTION_WIDTH_DEFAULT);
		public static final int POTION_HEIGHT = (int) (Game.SCALE * POTION_HEIGHT_DEFAULT);

		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);

		public static final int CANNON_WIDTH_DEFAULT = 40;
		public static final int CANNON_HEIGHT_DEFAULT = 26;
		public static final int CANNON_WIDTH = (int) (CANNON_WIDTH_DEFAULT * Game.SCALE * 2f);
		public static final int CANNON_HEIGHT = (int) (CANNON_HEIGHT_DEFAULT * Game.SCALE * 2f);

		public static int GetSpriteAmount(int object_type) {
			switch (object_type) {
			case RED_POTION, BLUE_POTION:
				return 9;
			case BARREL, BOX:
				return 7;
			case CANNON_LEFT, CANNON_RIGHT:
				return 7;
			}
			return 1;
		}

	}

	public static class EnemyConstants {
		public static final int GOBLEM = 0;
		public static final int SOLDIER = 1;
		public static final int GOBLIN = 2;
		public static final int DEATH = 3;

		public static final int ATTACK = 0; 
		public static final int DEAD = 1; 
		public static final int HIT = 2; 
		public static final int IDLE = 3; 
		public static final int RUNNING = 4; 
		
		public static final int GOBLEM_WIDTH_DEFAULT = 72;
		public static final int GOBLEM_HEIGHT_DEFAULT = 48;
		public static final int GOBLEM_WIDTH = (int) (GOBLEM_WIDTH_DEFAULT * Game.SCALE);
		public static final int GOBLEM_HEIGHT = (int) (GOBLEM_HEIGHT_DEFAULT * Game.SCALE);
		public static final int GOBLEM_DRAWOFFSET_X = (int) (24 * Game.SCALE);
		public static final int GOBLEM_DRAWOFFSET_Y = (int) (19 * Game.SCALE);

		public static final int SOLDIER_WIDTH_DEFAULT = 100;
		public static final int SOLDIER_HEIGHT_DEFAULT = 100;
		public static final int SOLDIER_WIDTH = (int) (SOLDIER_WIDTH_DEFAULT * Game.SCALE * 1.75f);
		public static final int SOLDIER_HEIGHT = (int) (SOLDIER_HEIGHT_DEFAULT * Game.SCALE * 1.75f);
		public static final int SOLDIER_DRAWOFFSET_X = (int) (77 * Game.SCALE);
		public static final int SOLDIER_DRAWOFFSET_Y = (int) (75 * Game.SCALE);

		public static final int GOBLIN_WIDTH_DEFAULT = 90;
		public static final int GOBLIN_HEIGHT_DEFAULT = 90;
		public static final int	GOBLIN_WIDTH = (int) (GOBLIN_WIDTH_DEFAULT * Game.SCALE * 0.7f);
		public static final int GOBLIN_HEIGHT = (int) (GOBLIN_HEIGHT_DEFAULT * Game.SCALE * 0.7f);
		public static final int GOBLIN_DRAWOFFSET_X = (int) (25 * Game.SCALE);
		public static final int GOBLIN_DRAWOFFSET_Y = (int) (28 * Game.SCALE);
		
		public static final int DEATH_WIDTH_DEFAULT = 80;
		public static final int DEATH_HEIGHT_DEFAULT = 80;
		public static final int	DEATH_WIDTH = (int) (DEATH_WIDTH_DEFAULT * Game.SCALE * 3.0f);
		public static final int DEATH_HEIGHT = (int) (DEATH_HEIGHT_DEFAULT * Game.SCALE * 3.0f);
		public static final int DEATH_DRAWOFFSET_X = (int) (35 * Game.SCALE * 3.0f);
		public static final int DEATH_DRAWOFFSET_Y = (int) (54 * Game.SCALE * 3.0f); //33

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {
			switch (enemy_state) {

			case IDLE: {
				if (enemy_type == GOBLEM)
					return 4;
				else if (enemy_type == GOBLIN)
					return 5;
				else if (enemy_type == SOLDIER)
					return 6;
				else if (enemy_type == DEATH)
					return 8;
			}
			case RUNNING:
				if (enemy_type == GOBLIN)
					return 12;
				else if (enemy_type == SOLDIER || enemy_type == GOBLEM || enemy_type == DEATH)
					return 8;
			case ATTACK:
				if (enemy_type == GOBLIN)
					return 10;
				else if (enemy_type == GOBLEM || enemy_type == DEATH)
					return 8;
				else if (enemy_type == SOLDIER)
					return 6;
			case HIT:
				if (enemy_type == GOBLIN)
					return 6;
				else if (enemy_type == GOBLEM)
					return 6;
				else if (enemy_type == SOLDIER)
					return 4;
				else if (enemy_type == DEATH)
					return 2;
			case DEAD:
				if (enemy_type == GOBLIN || enemy_type == DEATH)
					return 10;
				else if (enemy_type == GOBLEM)
					return 8;
				else if (enemy_type == SOLDIER)
					return 4;
			}

			return 0;

		}

		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case GOBLEM:
				return 50;
			case SOLDIER, GOBLIN:
				return 30;
			case DEATH:
				return 500;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case GOBLEM:
				return 20;
			case SOLDIER:
				return 25;
			case GOBLIN:
				return 15;
			case DEATH:
				return 30;
			default:
				return 0;
			}
		}
	}


	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}

		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}

		public static class VolumeButtons {
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;

			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		
		public static final int IDLE = 0;
		public static final int IDLE_WITH_SWORD = 1;
		public static final int IDLE_WITH_GUN = 2;
		public static final int RUNNING = 3;
		public static final int RUNNING_WITH_SWORD = 4;
		public static final int RUNNING_WITH_GUN = 5;
		public static final int JUMP = 6;		
		public static final int JUMP_WITH_SWORD = 7;
		public static final int JUMP_WITH_GUN = 8;
		public static final int FALLING = 12;
		public static final int ATTACK = 9;
		public static final int ATTACK_WITH_SWORD = 10;
		public static final int HIT = 13;
		public static final int DEAD = 11;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {			
			case IDLE:
			case DEAD:
			case ATTACK:
			case IDLE_WITH_SWORD:
			case IDLE_WITH_GUN:
				return 5;
			case RUNNING:
			case RUNNING_WITH_SWORD:
			case RUNNING_WITH_GUN:
				return 7;
			case JUMP:
			case JUMP_WITH_SWORD:
			case JUMP_WITH_GUN:
			case ATTACK_WITH_SWORD:
				return 6;
			case HIT:
				return 4;
			default:
				return 1;
			}
		}
	}

}