import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	
	
public class Player extends PlayerSprites implements GameConstants,PlayerState {
	
	private int state;
	
	BufferedImage[] walk=new BufferedImage[7];
	
	Player()
	{
		state=1;
		x=300;
		y=FLOOR-h;
		h=150;
		w=100;
		loadwalk();
		
	}

	
	
	
	public void loadwalk()
	{
		walk[0] = image.getSubimage(1849,1641,1915-1849,1745-1641);
		walk[1] = image.getSubimage(1922,1646,1996-1922,1744-1646);
		walk[2] = image.getSubimage(2001,1647,2071-2001,1743-1647);
		walk[3] = image.getSubimage(2080,1646,2151-2080,1743-1646);
		walk[4] = image.getSubimage(2162,1647,2232-2162,1744-1647);
		walk[5] = image.getSubimage(2240,1644,2310-2240,1744-1644);
		walk[6] = image.getSubimage(2267,1759,2334-2267,1854-1759);
	}
	
	int walkIndex=0;
	int walkDelay=0;
	
	public void drawWalk(Graphics g)
	{
		if(walkIndex>=7)
		{
			walkIndex=0;
		}
		
		g.drawImage(walk[walkIndex],x,y,w,h,null);
		
		if(walkIndex>=3)
		{
			walkDelay=0;
			walkIndex++;
		}
		walkDelay++;
		
	}
	
	public void drawPlayer(Graphics g)
	{
		if(state==WALK)
		{
			drawWalk(g);
		}
	}
}
