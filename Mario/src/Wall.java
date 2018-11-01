import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Wall extends FullSprite implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	
	public Wall()
	{
		
	}
	
	private void horizontalWall(Graphics g)
	{
		BufferedImage subimage = image.getSubimage();
		g.drawImage(subimage, x, y, width, height, bgcolor, null);
	}
	
	private void verticalWall(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(x, y, w, h);
		g.drawImage(subimage, x, y, width, height, bgcolor, null);
	}
	
	private void verticalPipe(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(x, y, w, h);
		g.drawImage(subimage, x, y, width, height, bgcolor, null);
		
	}
	
	private void Castle(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(x, y, w, h);
		g.drawImage(subimage, x, y, width, height, bgcolor, null);
		
	}

}
