import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Sprite implements GameConstants{

	
	BufferedImage image;
	
	Sprite()
	{
		loadSprite();
	}
	
	private void loadSprite()
	{
		try {
			image = ImageIO.read(Sprite.class.getResource(PLAYER_IM));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
