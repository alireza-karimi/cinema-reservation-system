import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class represents a show in an specific day and period and all seats in the show theater
 * @author alireza
 * @version 1.0.0
 */
public class Show {
	private String showName;
	private Day day;
	private Period period;
	//collection of rows in this theater
	private ArrayList<Row> rows;
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * creating a new show
	 * @param showName name of show
	 * @param day day of show
	 * @param period period of show
	 */
	public Show(String showName, Day day, Period period){
		this.showName = showName;
		this.day = day;
		this.period = period;
		
		rows = new ArrayList<>();
	}
	
	/**
	 * getting rows of seats for this show
	 * @return rows for this show
	 */
	public ArrayList<Row> getRows(){
		return rows;
	}
	
	/**
	 * getting day of this show
	 * @return Day object
	 */
	public Day getDay(){
		return day;
	}
	
	/**
	 * getting period of this show
	 * @return Period object
	 */
	public Period getPeriod(){
		return period;
	}
	
	/**
	 * getting name of this show
	 * @return name of show
	 */
	public String getName(){
		return showName;
	}
	
	/**
	 * checking if there is any empty seat for this show
	 * @return true if seat is available
	 */
	public boolean hasEmptySeat(){
		
		for(Row row : rows){
			if(row.hasEmptySeats()){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * showing seats plan for this show
	 * @param rowSeatsNumber number of seats in each row for this show
	 */
	public void showPlan(int rowSeatsNumber){
		
		for(int i = 0; i < rows.size(); i++){
			
			for(int j = 0; j < rowSeatsNumber; j++){
				
				if(rows.get(i).getSeats().get(j).getStatus()){
					System.out.print(" \t");
				}
				else{
					System.out.print(i * rowSeatsNumber + j + "\t");
				}
			}	
			
			System.out.println();

		}	
		
	}
	
	/**
	 * checking if reserving a group of seats for this show if possible
	 * @param neededSeats array of needed seats
	 * @param rowSeatsNumber number of seats in each row for this show
	 * @return true if possible
	 */
	public boolean reserveIsPossible(int[] neededSeats, int rowSeatsNumber){
		
		for(int item : neededSeats){
			
			if(rows.get( ( item - (item % rowSeatsNumber) ) / rowSeatsNumber).getSeats().get(item % rowSeatsNumber).getStatus()){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * reserving some seats for this show
	 * @param rowSeatsNumber
	 * @param customer
	 */
	public void reserve(int rowSeatsNumber, Customer customer){
		showPlan(rowSeatsNumber);
		System.out.println("enter number of seats that you need seperating them by space:");
		String input = scanner.nextLine();
		String[] splittedInput = input.split("\\s");
		
		int[] neededSeats = new int[splittedInput.length];
		for(int i = 0; i < splittedInput.length; i++){
			neededSeats[i] = Integer.parseInt(splittedInput[i]);
		}
		
		boolean flag = reserveIsPossible(neededSeats, rowSeatsNumber);
		
		if(flag){
			
			for(int item : neededSeats){
				rows.get( ( item - (item % rowSeatsNumber) ) / rowSeatsNumber).getSeats().get(item % rowSeatsNumber).setStatus(true);
				customer.addShow(this);
			}
			
			System.out.println("Seats reserved successfully!");
			
		}
		else{
			System.out.println("These seats are not empty!");
		}
	}
	
	/**
	 * printing information of this show
	 */
	public void print(){
		System.out.println("show name: " + showName + " show day: " + day + " show period: " + period);
	}
	
	
}
