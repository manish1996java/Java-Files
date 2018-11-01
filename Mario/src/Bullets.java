import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullets extends FullSprite implements GameConstants {
	private int x;
	private int y;
	private int h;
	private int w;
	private int speed;
	
	public Bullets(int x, int y)
	{
		this.x = x;
		this.y = y;
		w =10;
		h =10;
		speed=10;
	}
	
	public void move()
	{
			x+=speed;
	}
	
	public void drawBullets(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(860, 635, 1285-860, 1063-635);
		g.drawImage(subimage, x, y, w, h, null);
		move();
	}

}
