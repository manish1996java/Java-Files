

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Sprite implements GameConstant {
	int x,y,w,h;
	BufferedImage image;
	
	Sprite(){
		loadPlayerSprite();
	}

	void loadPlayerSprite() {
		try {
			image=ImageIO.read(Sprite.class.getResource(P_SPRITE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	
}
