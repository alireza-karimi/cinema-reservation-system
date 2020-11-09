import java.util.ArrayList;

/**
 * this class represents a customer
 * @author alireza
 * @version 1.0.0
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	//reserved shows of this customer
	private ArrayList<Show> shows;
	
	/**
	 * creating a new customer
	 * @param firstName customer first name
	 * @param lastName customer last name
	 */
	public Customer(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		shows = new ArrayList<>();
	}
	
	/**
	 * getting first name of customer
	 * @return first name of customer
	 */
	public String getFirstName(){
		return firstName;
	}
	
	/**
	 * getting last name of customer
	 * @return last name of customer
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * adding a show to customer reservations
	 * @param show
	 */
	public void addShow(Show show){
		shows.add(show);
	}
	
	/**
	 * printing all customer reservations
	 */
	public void printShows(){
		for(Show show : shows){
			show.print();
		}
	}
}
