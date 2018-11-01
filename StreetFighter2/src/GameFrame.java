

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstant {
	
	GameFrame(){
		setSize(G_WIDTH,G_HEIGHT);
		setLocation(35,20);
		setTitle(TITLE);
		Board board=new Board();
		add(board);
		setVisible(true);
	}

}
