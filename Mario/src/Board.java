import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board  extends JPanel implements GameConstants{
	
	Camera camera;
	Timer timer;
	Player player;
	Enemy enemy;
	ArrayList<Bullets> bullets = new ArrayList<Bullets>();
//	Pipe[] pipe=new Pipe[6];
	Pipe pipe;
	
	public Board()
	{
		setSize(GWIDTH,GHEIGHT);
		camera=new Camera();
		player=new Player();
		enemy= new Enemy();
		loadPipe();
		BindEvent();
		GameLoop();
		setFocusable(true);
		
	}
	
	private void BindEvent()
	{
		KeyListener l = new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_F)
						{
							loadBullets();
						}
						if(e.getKeyCode() == KeyEvent.VK_LEFT)
						{
							player.direction(-1);
//							camera.left();
						}
						if(e.getKeyCode() == KeyEvent.VK_RIGHT)
						{
							if(player.getX()<=700){
							player.direction(1);
							}
							if(player.getX()>=(GWIDTH-300)) {
							player.state=2;
							camera.right();
							
							}
//							if(player.getX() ==KeyEvent.VK_RIGHT && player.getX()== KeyEvent.VK_SPACE)
//							{
//								player.
//							}
						}
						if(e.getKeyCode() == KeyEvent.VK_SPACE)
						{
							player.jump();
						}
						
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						player.direction(0);
						player.state=1;
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
			
				};
				this.addKeyListener(l);
	}
	private void GameLoop()
	{
		ActionListener l= new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						repaint();
						player.move();
						player.fall();
						
					}
			
				};
				timer = new Timer(DELAY,l);
				timer.start();
	}
	
	private void loadPipe()
	{
		int x= camera.getX();
//		System.out.println(x);
		pipe=new Pipe(x+600);
//		pipe[0]=new Pipe(1200);
//		pipe[1]=new Pipe(x);
//		pipe[2]=new Pipe(x);
//		pipe[3]=new Pipe(x);
//		pipe[4]=new Pipe(x);
	}
	
	private void drawPipe(Graphics g)
	{
		pipe.drawPipe(g);
	}
	private void drawEnemy(Graphics g)
	{
		enemy.drawgoombusEnemy(g);
	}
	private void drawBackground(Graphics g)
	{
		camera.drawBackground(g);
	}
	
	private void loadBullets()
	{
		int bulletX=(player.getX()+player.getW()/2);
		int bulletY=(player.getY()+player.getH()/2);
		
		Bullets bullet = new Bullets(bulletX,bulletY);
		bullets.add(bullet);
	}
	private void drawBullets(Graphics g) {
		if(bullets.size()>0)
		{
			for(Bullets bullet:bullets)
			{
				bullet.drawBullets(g);
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBackground(g);
		pipe.drawPipe(g);
		drawEnemy(g);
		player.drawPlayer(g);
		drawBullets(g);
	}
}
