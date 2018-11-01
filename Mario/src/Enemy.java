import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Sprite implements GameConstants ,PlayerState{
	private int x;
	private int y;
	private int w;
	private int h;
	private int state=1;
	
	public Enemy()
	{
		goombusEnemy();
		leftDuckEnemy();
		rightDuckEnemy();
		
		
	}

	
	
	BufferedImage[] Goombusenemy = new BufferedImage[2];
	private void goombusEnemy() {
		Goombusenemy[0] = image.getSubimage(294,185,313-294,204-185);
		Goombusenemy[1] = image.getSubimage(313,185,332-313,204-185);
		
	}
	
	int GoombusIndex = 0;
	int GoombusDelay = 0;
	public void drawgoombusEnemy(Graphics g)
	{
		
		if(GoombusIndex>=2) {
			GoombusIndex=0;
		}
		g.drawImage(Goombusenemy[GoombusIndex],300,200,50,50,null);
		
		if(GoombusDelay>=8) {
			GoombusDelay=0;
			GoombusIndex++;
			
		}
		GoombusIndex++;
	}
	
	
	
	
	private void goombusSmashed(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(275,193,295-275,231-193);
		g.drawImage(subimage, x, y, 20, 20,null);
	}
	
	
	
	
	BufferedImage[] leftFaceDuck = new BufferedImage[2];
	private void leftDuckEnemy()
	{
		leftFaceDuck[0] = image.getSubimage(199,205,219-199,231-205);
		leftFaceDuck[1] = image.getSubimage(180,204,199-180,232-204);
		
	}
	
	int leftDuckEnemyIndex = 0;
	int leftDuckEnemyDelay = 0;
	public void drawLeftDuckEnemy(Graphics g)
	{
		if(leftDuckEnemyIndex>=2) {
			leftDuckEnemyIndex=0;
		}
		g.drawImage(leftFaceDuck[leftDuckEnemyIndex],x,y,w,h,null);
		
		if(leftDuckEnemyDelay>=3) {
			leftDuckEnemyDelay=0;
			leftDuckEnemyIndex++;
			
		}
		leftDuckEnemyDelay++;
	}
	
	
	
	
	BufferedImage[] rightFaceDuck = new BufferedImage[2];
	private void rightDuckEnemy()
	{
		leftFaceDuck[0] = image.getSubimage(295,205,314-295,231-205);
		leftFaceDuck[1] = image.getSubimage(314,205,332-314,231-205);
		
	}
	
	int rightDuckEnemyIndex = 0;
	int rightDuckEnemyDelay = 0;
	public void drawRightDuckEnemy(Graphics g)
	{
		if(rightDuckEnemyIndex>=2) {
			rightDuckEnemyIndex=0;
		}
		g.drawImage(rightFaceDuck[rightDuckEnemyIndex],x,y,w,h,null);
		
		if(rightDuckEnemyDelay>=3) {
			rightDuckEnemyDelay=0;
			rightDuckEnemyIndex++;
			
		}
		rightDuckEnemyDelay++;
	}
	
	
	
	private void duckSmashed(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(143,214,161-143,231-214);
		g.drawImage(subimage, x, y, width, height,null);
	}
	
	public void printEnemy(Graphics g)
	{
		if(state==WALK)
		{
			drawgoombusEnemy(g);
		}
		if(state==2)
		{
			goombusSmashed(g);
		}
	}
	 
}
