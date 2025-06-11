package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] goblemArr, soldierArr, goblinArr, deathArr;
	private Level currentLevel;

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}

	public void loadEnemies(Level level) {
		this.currentLevel = level;
	}

	public void update(int[][] lvlData) {
		boolean isAnyActive = false;
		for (Goblem g : currentLevel.getGoblems())
			if (g.isActive()) {
				g.update(lvlData, playing);
				isAnyActive = true;
			}

		for (Soldier s : currentLevel.getSoldiers())
			if (s.isActive()) {
				s.update(lvlData, playing);
				isAnyActive = true;
			}

		for (Goblin go : currentLevel.getGoblins())
			if (go.isActive()) {
				go.update(lvlData, playing);
				isAnyActive = true;
			}
		
		for (Death d : currentLevel.getDeath())
			if (d.isActive()) {
				d.update(lvlData, playing);
				isAnyActive = true;
			}

		if (!isAnyActive)
			playing.setLevelCompleted(true);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawGoblems(g, xLvlOffset);
		drawSoldiers(g, xLvlOffset);
		drawGoblins(g, xLvlOffset);
		drawDeath(g, xLvlOffset);
	}

	private void drawDeath(Graphics g, int xLvlOffset) {
		for (Death d : currentLevel.getDeath())
			if (d.isActive()) {
				g.drawImage(deathArr[d.getState()][d.getAniIndex()], (int) d.getHitbox().x - xLvlOffset - DEATH_DRAWOFFSET_X + d.flipX(),
						(int) d.getHitbox().y - DEATH_DRAWOFFSET_Y + (int) d.getPushDrawOffset(), DEATH_WIDTH * d.flipW(), DEATH_HEIGHT, null);
//				d.drawHitbox(g, xLvlOffset);
////				System.out.println(xLvlOffset);
//				d.drawAttackBox(g, xLvlOffset);
			}
	}
	
	private void drawGoblins(Graphics g, int xLvlOffset) {
		for (Goblin go : currentLevel.getGoblins())
			if (go.isActive()) {
				g.drawImage(goblinArr[go.getState()][go.getAniIndex()], (int) go.getHitbox().x - xLvlOffset - GOBLIN_DRAWOFFSET_X + go.flipX(),
						(int) go.getHitbox().y - GOBLIN_DRAWOFFSET_Y + (int) go.getPushDrawOffset(), GOBLIN_WIDTH * go.flipW(), GOBLIN_HEIGHT, null);
//				go.drawHitbox(g, xLvlOffset);
//				go.drawAttackBox(g, xLvlOffset);
			}
	}

	private void drawSoldiers(Graphics g, int xLvlOffset) {
		for (Soldier p : currentLevel.getSoldiers())
			if (p.isActive()) {
				g.drawImage(soldierArr[p.getState()][p.getAniIndex()], (int) p.getHitbox().x - xLvlOffset - SOLDIER_DRAWOFFSET_X + p.flipX(),
						(int) p.getHitbox().y - SOLDIER_DRAWOFFSET_Y + (int) p.getPushDrawOffset(), SOLDIER_WIDTH * p.flipW(), SOLDIER_HEIGHT, null);
//				p.drawHitbox(g, xLvlOffset);
			}
	}

	private void drawGoblems(Graphics g, int xLvlOffset) {
		for (Goblem c : currentLevel.getGoblems())
			if (c.isActive()) {

				g.drawImage(goblemArr[c.getState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - GOBLEM_DRAWOFFSET_X + c.flipX(),
						(int) c.getHitbox().y - GOBLEM_DRAWOFFSET_Y + (int) c.getPushDrawOffset(), GOBLEM_WIDTH * c.flipW(), GOBLEM_HEIGHT, null);

//				c.drawHitbox(g, xLvlOffset);
//				c.drawAttackBox(g, xLvlOffset);
			}

	}

	public boolean checkEnemyHit(Rectangle2D.Float attackBox, int dmg) {
		for (Goblem c : currentLevel.getGoblems())
			if (c.isActive())
				if (c.getState() != DEAD && c.getState() != HIT)
					if (attackBox.intersects(c.getHitbox())) {
						c.hurt(dmg);
						return true;
					}

		for (Soldier p : currentLevel.getSoldiers())
			if (p.isActive()) {
				if (p.getState() == ATTACK && p.getAniIndex() >= 3)
					return true;
				else {
					if (p.getState() != DEAD && p.getState() != HIT)
						if (attackBox.intersects(p.getHitbox())) {
							p.hurt(dmg);
							return true;
						}
				}
			}

		for (Goblin s : currentLevel.getGoblins())
			if (s.isActive()) {
				if (s.getState() != DEAD && s.getState() != HIT)
					if (attackBox.intersects(s.getHitbox())) {
						s.hurt(dmg);
						return true;
					}
			}
		
		for (Death s : currentLevel.getDeath())
			if (s.isActive()) {
				if (s.getState() != DEAD && s.getState() != HIT)
					if (attackBox.intersects(s.getHitbox())) {
						s.hurt(dmg);
						return true;
					}
			}
		
		return false;
	}

	private void loadEnemyImgs() {
		goblemArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.GOBLEM_ATLAS), 8, 5, GOBLEM_WIDTH_DEFAULT, GOBLEM_HEIGHT_DEFAULT);
		soldierArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.SOLDIER_ATLAS), 8, 5, SOLDIER_WIDTH_DEFAULT, SOLDIER_HEIGHT_DEFAULT);
		goblinArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.GOBLIN_ATLAS), 12, 5, GOBLIN_WIDTH_DEFAULT, GOBLIN_HEIGHT_DEFAULT);
		deathArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.DEATH_ATLAS), 10, 5, DEATH_WIDTH_DEFAULT, DEATH_HEIGHT_DEFAULT);
	}

	private BufferedImage[][] getImgArr(BufferedImage atlas, int xSize, int ySize, int spriteW, int spriteH) {
		BufferedImage[][] tempArr = new BufferedImage[ySize][xSize];
		for (int j = 0; j < tempArr.length; j++)
			for (int i = 0; i < tempArr[j].length; i++)
				tempArr[j][i] = atlas.getSubimage(i * spriteW, j * spriteH, spriteW, spriteH);
		return tempArr;
	}

	public void resetAllEnemies() {
		for (Goblem c : currentLevel.getGoblems())
			c.resetEnemy();
		for (Soldier p : currentLevel.getSoldiers())
			p.resetEnemy();
		for (Goblin s : currentLevel.getGoblins())
			s.resetEnemy();
		for (Death s : currentLevel.getDeath())
			s.resetEnemy();
	}

}
