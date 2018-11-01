


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstant {

	
	private BufferedImage bimage;
	private Image image;
	private Dhalsim dhalsim;
	private Ryu ryu;
	private Timer timer;
	
	
	public Board(){
		setSize(G_WIDTH,G_HEIGHT);
		image= new ImageIcon(Board.class.getResource(BG_IMAGE2)).getImage();
		loadBackGroundsp();
		ryu=new Ryu();
		dhalsim= new Dhalsim();
		bindEvent();
		gameLoop();
		setFocusable(true);
	}
	
	private void loadBackGroundsp()
	{
		try {
			bimage = ImageIO.read(Board.class.getResource(BG_IMAGE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void drawBackGround(Graphics g) {
//		BufferedImage subimage= bimage.getSubimage(1, 225,767-1 ,479-225);
		
		g.drawImage(image,0,0,G_WIDTH,G_HEIGHT,null);
	}
	
	private void gameLoop() {
		ActionListener l=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				dhalsim.move();
				ryu.move();
				ryu.fall();
				
			}
		};
		timer =new Timer(DELAY,l);
		timer.start();
	}
	
	public void bindEvent() {
		KeyListener l=new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					ryu.setState(4);
					ryu.direction(-1);
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					ryu.setState(3);
					ryu.direction(1);
					
				}
				
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					ryu.setState(2);
					ryu.jump();
				}
				
				
				if(e.getKeyCode()==KeyEvent.VK_X) {
			
					ryu.setState(5);
					ryu.jump();
					
				}
				if(e.getKeyCode()==KeyEvent.VK_O) {
					
					dhalsim.setState(11);
				}
				if(e.getKeyCode()==KeyEvent.VK_Z) {
					ryu.setState(6);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
					ryu.setState(7);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_A) {
					ryu.setState(8);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_C) {
					ryu.setState(9);
					
				}
				if(e.getKeyCode()==KeyEvent.VK_Q) {
					ryu.setState(10);
					ryu.jump();
					
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
                   ryu.setState(1);				
			       ryu.direction(0);	
			}
			
		};
		this.addKeyListener(l);
	}	
	
	private void Timer(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial",Font.BOLD,80));
		g.drawString("00", 595, 85);
	}
	
	private void ryuPic(Graphics g)
	{
		BufferedImage subimage = bimage.getSubimage(795, 17, 1311-795, 479-17);
		g.drawImage(subimage, 10, 10, 100, 100,null);
	}
	
	private void dhalsimPic(Graphics g)
	{
		BufferedImage subimage = bimage.getSubimage(1313, 25, 1835-1313, 477-25);
		g.drawImage(subimage, G_WIDTH-120, 10, 100, 100, null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackGround(g);	
		ryu.drawRyu(g);
		dhalsim.drawDhalsim(g);
		ryu.powerBoard(g);
		dhalsim.powerBoard(g);
		ryu.power(g);
		dhalsim.power(g);
		Timer(g);
		ryuPic(g);
		dhalsimPic(g);
	}
}
