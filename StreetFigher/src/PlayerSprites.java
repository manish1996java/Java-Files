import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class PlayerSprites implements GameConstants {
	int x;
	int y;
	int w;
	int h;
	
	BufferedImage image;
	
	public void loadPlayerSprite()
	{
		try {
			image = ImageIO.read(PlayerSprites.class.getResource(PLAYERIM));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
