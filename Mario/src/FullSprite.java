import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class FullSprite implements GameConstants{
	protected BufferedImage image;
	
	public FullSprite()
	{
		loadSprite();
	}
	
	private void loadSprite()
	{
		try {
			image=ImageIO.read(FullSprite.class.getResource(FULLSPRITE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
