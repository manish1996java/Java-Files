import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Camera implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	private int speed;
	private BufferedImage image;
	
	public Camera(){
		w=GWIDTH;
		h=GHEIGHT;
		speed=1;

		loadBackground();
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}


	
	private void loadBackground() {
		try {
			image=ImageIO.read(Camera.class.getResource(BACKGROUND_IM));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void drawBackground(Graphics g) {
		BufferedImage subimage=image.getSubimage(x,y,300,243);
		g.drawImage(subimage,0,0,w,h,null);
	}
	
	public void right()
	{ 
			x+=speed;

	}
	

}
