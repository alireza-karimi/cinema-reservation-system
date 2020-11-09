import java.util.ArrayList;

/**
 * this class represents a reservation system for a cinema
 * @author alireza
 * @version 1.0.0
 */
public class ReservationSystem {
	
	//storing all theaters in this cinema
	private ArrayList<Theater> theaters;
	//storing all customers of this cinema
	private ArrayList<Customer> customers;
	
	/**
	 * creating a new reservation system
	 */
	public ReservationSystem(){
		theaters = new ArrayList<>();
		customers = new ArrayList<>();
	}
	
	/**
	 * adding theater to cinema
	 * @param theater theater
	 */
	public void addTheater(Theater theater){
		
		for(Theater item : theaters){
			if(item.getCode() == theater.getCode()){
				System.out.println("Theater exists with this code!");
				return;
			}
		}
		
		theaters.add(theater);
		System.out.println("Theater added successfully!");
	}
	
	/**
	 * adding some new rows to a theater
	 * @param code theater unique code
	 * @param newRowsNumber number of new rows
	 */
	public void addRowToTheater(int code, int newRowsNumber){
		
		for(Theater item : theaters){
			
			if(item.getCode() == code){
				item.addRowToTheater(newRowsNumber);
			}
		}
	}
	
	/**
	 * adding a new show
	 * @param show show
	 * @param theaterCode theater unique code in which show is going to be displayed
	 */
	public void addNewShow(Show show, int theaterCode){
		Theater theater = null;
		
		int flag = 0;
		for(Theater item : theaters){
			if(item.getCode() == theaterCode){
				theater = item;
				flag = 1;
				break;
			}
		}
		
		if(flag == 0){
			System.out.println("There is not theater with such code!");
			return;
		}
		
		theater.addShow(show);
		
	}
	
	/**
	 * adding a new reservation
	 * @param customerName customer full name
	 * @param showName show name
	 * @param showDay show day
	 * @param showPeriod show period
	 */
	public void addNewReserve(String customerName, String showName, String showDay, String showPeriod){

		Customer customer = findCustomerByName(customerName);
		if(customer == null){
			return;
		}
		
		Theater theater = checkShowInTheaters(showName, showDay, showPeriod);
		if(theater == null){
			System.out.println("There is not such show in any theater");
			return;
		}
		
		
	}
	
	/**
	 * finding a customer by its name
	 * @param name name of customer
	 * @return customer object (if not exists, return null)
	 */
	public Customer findCustomerByName(String name){
		
		String[] splittedName = name.split("\\s");
		String firstName = splittedName[0];
		String lastName = splittedName[1];
		
		//finding customer
		for(Customer item : customers){
			if(item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)){
				return item;
			}
		}
		
		return null;

	}
	
	/**
	 * checking if a show exists in cinema
	 * @param showName show name
	 * @param showDay show day
	 * @param showPeriod show period
	 * @return the show object (null if does not exist)
	 */
	private Theater checkShowInTheaters(String showName, String showDay, String showPeriod){
		
		for(Theater item : theaters){
			if(item.showExist(showName, showDay, showPeriod)){
				return item;
			}
		}
		
		return null;		
	}
	
	/**
	 * adding a new customer
	 * @param customer customer object
	 */
	public void addCustomer(Customer customer){
		
		if(findCustomerByName(customer.getFirstName() + " " + customer.getLastName()) == null){
			customers.add(customer);
			System.out.println("Customer added!");
		}
		else{
			System.out.println("There is a cutomer with this name before!");
		}
	}
	
	/**
	 * checking if reserving is possible (checks name of show)
	 * @param showName show name
	 * @return true if reserve is possible
	 */
	public Theater reserveByShowNameIsPossible(String showName){
		
		for(Theater theater : theaters){
			if(theater.reservationIsPossible(showName)){
				return theater;
			}
		}
		
		return null;
	}
	
	/**
	 * reserving some seats
	 * @param showName show name
	 * @param customer customer object
	 */
	public void reserveByShowName(String showName, Customer customer){
		
		Theater theater = reserveByShowNameIsPossible(showName);
		
		if(theater == null){
			System.out.println("Reservation is not possible!");
			return;
		}
		
		theater.reserveByShowName(showName, customer);	
	}
	
	/**
	 * printing all reservations of a customer
	 * @param customer
	 */
	public void printCustomerReservations(Customer customer){
		customer.printShows();
	}
	
}
