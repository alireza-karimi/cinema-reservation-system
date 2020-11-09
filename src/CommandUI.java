import java.util.Scanner;

/**
 * a user interface for the program
 * @author alireza
 * @version 1.0.0
 */
public class CommandUI {

	
	private static Scanner scanner = new Scanner(System.in);
	private static ReservationSystem system = new ReservationSystem();
	
	/**
	 * adding a new theater to the cinema
	 */
	private static void addTheater(){
		System.out.println("enter theater code:");
		int code = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter theater number of rows:");
		int rowsNumber = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter theater number of seats in each row:");
		int rowSeatsNumber = scanner.nextInt();
		scanner.nextLine();
		
		Theater theater = new Theater(code, rowsNumber, rowSeatsNumber);
		
		system.addTheater(theater);
		
	}
	
	/**
	 * adding some new rows to a theater in cinema
	 */
	private static void addRowToTheater(){
		System.out.println("enter theater code:");
		int code = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter number of new rows:");
		int newRowsNumber = scanner.nextInt();
		scanner.nextLine();
		
		system.addRowToTheater(code, newRowsNumber);
	}
	
	/**
	 * adding a new show
	 */
	private static void addShow(){
		System.out.println("enter show name:");
		String showName = scanner.nextLine();
		
		System.out.println("enter show day:");
		String day = scanner.nextLine();

		System.out.println("enter show period:");
		String period = scanner.nextLine();
		
		Show show = new Show(showName, Day.valueOf(day), Period.valueOf(period));
		
		System.out.println("enter theater code:");
		int theaterCode = scanner.nextInt();
		scanner.nextLine();
		
		system.addNewShow(show, theaterCode);
	}
	
	/**
	 * adding a new customer
	 */
	private static void addCustomer(){
		System.out.println("enter customer first name without space between:");
		String firstName = scanner.nextLine();
		
		System.out.println("enter customer last name without space between:");
		String lastName = scanner.nextLine();
		
		Customer customer = new Customer(firstName, lastName);
		
		system.addCustomer(customer);
	}
	
	/**
	 * reserve some seats for a customer
	 */
	private static void reserveSeat(){
		System.out.println("enter your favorite show name:");
		String showName = scanner.nextLine();
		
		System.out.println("enter customer name:");
		String customerName = scanner.nextLine();
		
		Customer customer = system.findCustomerByName(customerName);
		
		if(customer == null){
			System.out.println("There is not any customer with this name.");
			return;
		}
		
		system.reserveByShowName(showName, customer);
	}
	
	/**
	 * show a customer reservations
	 */
	private static void showReservation(){
		System.out.println("enter customer name:");
		String customerName = scanner.nextLine();
		
		Customer customer = system.findCustomerByName(customerName);
		
		if(customer == null){
			System.out.println("There is not such customer!");
			return;
		}
		
		customer.printShows();
		
	}
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Commands Help:");
		System.out.println("add theater");
		System.out.println("add show");
		System.out.println("add customer");
		System.out.println("reserve seat");
		System.out.println("show reservation");
		System.out.println("add rows to theater");
		System.out.println("end");
		
		String input = "nothing";
		input = scanner.nextLine();
		
		while(!input.equals("end")){
			
			if(input.equals("add theater")){
				addTheater();
			}
			else if(input.equals("add rows to theater")){
				addRowToTheater();
			}
			else if(input.equals("add show")){
				addShow();
			}
			else if(input.equals("add customer")){
				addCustomer();
			}
			else if(input.equals("reserve seat")){
				reserveSeat();
			}
			else if(input.equals("show reservation")){
				showReservation();
			}
			
			
			System.out.println("Commands Help:");
			System.out.println("add theater");
			System.out.println("add show");
			System.out.println("add customer");
			System.out.println("reserve seat");
			System.out.println("show reservation");
			System.out.println("add rows to theater");
			System.out.println("end");
			
			input = scanner.nextLine();
		}
		

	}

}
