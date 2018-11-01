import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	
	private BufferedImage image;
	private Timer timer;
	private Player player;
	
	
	public Board(){
		setSize(GWIDTH,GHEIGHT);
		loadBackground();
		player=new Player();
		bindEvent();
		gameLoop();
		setFocusable(true);
	}
	
	
	private void loadBackground()
	{
		try {
			image = ImageIO.read(Board.class.getResource(BACKGROUNDIM));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void bindEvent()
	{
		KeyListener l=new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
				};
				this.addKeyListener(l);
		
	}
	private void gameLoop()
	{
		ActionListener l= new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				
			}
			
			
		};
		timer = new Timer(DELAY,l);
		timer.start();
		
	}
	
	private void drawBackground(Graphics g)
	{
		BufferedImage subimage = image.getSubimage(1567,363,2203-1567,742-363);
		g.drawImage(subimage,0,0,GWIDTH,GHEIGHT,null);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBackground(g);
		player.drawWalk(g);
	}
	
}
