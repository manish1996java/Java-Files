import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient1 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket = new Socket("local host",9013);
		System.out.println("client is here :)");
	}

}
