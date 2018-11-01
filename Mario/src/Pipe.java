import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Pipe extends FullSprite implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	
	public Pipe()
	{
		
	}
	
	public Pipe(int x)
	{
		this.x=x;
		y=FLOOR-200;
		w=200;
		h=200;
	}
	
	public void drawPipe(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(613,45,647-613,79-45);
		g.drawImage(subimage, x, y, w, h,null);
	}

}
