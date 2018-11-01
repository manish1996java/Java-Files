import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {
	GameFrame()
	{
		setLocation(0,0);
		setSize(GWIDTH,GHEIGHT);
		setTitle(TITLE);
		Board board = new Board();
		add(board);
		setVisible(true);
	}

}
