import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	public static void main(String args[]) throws IOException
	{
		 final int PORT = 9013;
		 ServerSocket server = new ServerSocket(PORT);
		 System.out.println("Server start and waiting for client ......");
		 Socket socket = server.accept();
		 System.out.println("Client joins");
		 System.out.println("Enter the data send to client");
		 
		 Scanner scan = new Scanner(System.in);
		 String data = scan.nextLine();
	}
}
