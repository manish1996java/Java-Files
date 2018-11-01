import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Sprite implements GameConstants,PlayerState{
	
	private int x;
	private int y;
	private int h;
	private int w;
	private boolean isJump;
	
	int speed;
	int state;
	int force;
	Camera camera;
	
	public Player()
	{
	
		state=1;
		x=100;
		y=FLOOR-60;
		w=50;
		h=60;
		camera = new Camera();
		loadRightwalk();
		loadLeftwalk();
		loadJump();
		loadwalk();
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



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}



	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public BufferedImage getWalk() {
		return walk;
	}



	public void setWalk(BufferedImage walk) {
		this.walk = walk;
	}



	BufferedImage[] rightwalk=new BufferedImage[3];
	public void loadRightwalk()
	{
		
		rightwalk[0]=image.getSubimage(294,0,312-294,34);
		rightwalk[1]=image.getSubimage(314,0,329-314,34);
		rightwalk[2]=image.getSubimage(330,0,349-330,33);
		
	}
	
	int rightwalkIndex=0;
	int rightwalkDelay=0;
	public void drawRightwalk(Graphics g)
	{
		if(rightwalkIndex>=3)
		{
			rightwalkIndex=0;
		}
		
		g.drawImage(rightwalk[rightwalkIndex],x,y,w,h,null);
		
		if(rightwalkDelay>=3)
		{
		rightwalkDelay=0;
		rightwalkIndex++;
		}
		rightwalkDelay++;
		
	}
	
	BufferedImage[] leftwalk=new BufferedImage[3];
	public void loadLeftwalk()
	{
		
		leftwalk[0]=image.getSubimage(199,0,218-199,33);
		leftwalk[1]=image.getSubimage(182,0,199-182,33);
		leftwalk[2]=image.getSubimage(165,0,183-165,33);
		
	}
	
	int leftwalkIndex=0;
	int leftwalkDelay=0;
	public void drawLeftwalk(Graphics g)
	{
		
		if(leftwalkIndex>=3)
		{
			leftwalkIndex=0;
		}
		
		g.drawImage(leftwalk[leftwalkIndex],x,y,w,h,null);
		
		if(leftwalkDelay>=3)
		{
		leftwalkDelay=0;
		leftwalkIndex++;
		}
		leftwalkDelay++;
	}
	
	
	
	public void direction(int dir)
	{
		if(dir==1)
		{
			state=2;
		}
		if(dir==-1)
		{
			state=3;
		}
		speed=5;
		speed=speed*dir;
	}
	
	
	
	
	
	BufferedImage walk;
	public void loadwalk() {
		walk=image.getSubimage(257,0,275-257,33);
	}
	
	public void drawWalk(Graphics g)
	{
		g.drawImage(walk,x,y,w,h,null);
	}
	
	public void move() {
		if(x>=700)
		{
			x=700;
		}
		x+=speed;
		
		
	}
	
	
	
	
	BufferedImage[] jump=new BufferedImage[3];
	public void loadJump()
	{
		
		jump[0]=image.getSubimage(367,0,387-367,34);
		jump[1]=image.getSubimage(367,0,387-367,34);
		jump[2]=image.getSubimage(367,0,387-367,34);
		
	}
	
	int jumpIndex=0;
	int jumpDelay=0;
	public void drawJump(Graphics g)
	{
		if(jumpIndex>=3)
		{
			jumpIndex=0;
		}
		
		g.drawImage(jump[jumpIndex],x,y,w,h,null);
		
		if(jumpDelay>=3)
		{
		jumpDelay=0;
		jumpIndex++;
		}
		jumpDelay++;
	}
	
	public void setJump(boolean isjump)
	{
		this.isJump=isjump;
	}
	public boolean isJump()
	{
		return isJump;
	}
	
	public void jump()
	{
		if(!isJump())
		{
		isJump=true;
		state=4;
		force=-25;
		y+=force;
		}
	}
	
	public void fall()
	{
		if(y>=(FLOOR-h))
		{
			isJump=false;
			y=(FLOOR-h);
		}
		
		if(y<(FLOOR-h))
		{
			force+=GRAVITY;
			
			y+=force;
			x+=4;

		}
	}
	
	public void drawPlayer(Graphics g)
	{
		if(state==WALK) {
			drawWalk(g);	
		}
		if(state==RIGHTWALK)
		{
			drawRightwalk(g);
		}
		if(state==LEFTWALK)
		{
			drawLeftwalk(g);
		}
		if(state==JUMP)
		{
			drawJump(g);
		}
		
	}
	

}
