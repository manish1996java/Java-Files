
import static java.lang.System.out;
import java.util.Scanner;

enum Day{SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}

public class Test {

	Day day;
	
	public Test(Day day) {
		this.day = day;
	}
	
	public void dayIsLike() {
		switch(day) {
		
		case SUNDAY: System.out.println("Intresting day");
		break;
		case MONDAY: System.out.println("working time");
		break;
		case TUESDAY: System.out.println("project submission ");
		break;
		case WEDNESDAY: System.out.println("viva");
		break;
		case THURSDAY: System.out.println("online test");
		break;
		case FRIDAY: System.out.println("fast day");
		break;
		case SATURDAY: System.out.println("thekaa day");
		break;
		
		}
	}
	
	public static void main(String args[]) {
		out.println("Enter the name of day :");
//		System.out.println("Enter the name of day :");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		Test test = new Test(Day.valueOf(str.toUpperCase()));
		test.dayIsLike();
	}
	
	
	
}
//	public Test(Day day){
//		this.day = day;
//	}
//	
//	public void dayIsLike(Day) {
//		
//	}
//	public static void main(String args[])
//	{
//		Test test = new test()
//	}
//	
//}
