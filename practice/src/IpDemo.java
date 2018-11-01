import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IpDemo {

	public static void main(String... args) throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
		System.out.println(" Enter the HOST ");
		String hostName = new Scanner(System.in).nextLine();
		
		InetAddress net[] = InetAddress.getAllByName(hostName);
		
		for(InetAddress i : net) {
			System.out.println(i.getHostAddress());
		}
	}
}
