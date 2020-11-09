import java.util.ArrayList;

/**
 * representing a row of seats in a theater
 * @author alireza
 * @version 1.0.0
 */
public class Row {
	//number of seats in this row
	private int rowSeatsNumber;
	//seats in this row
	private ArrayList<Seat> seats;
	
	/**
	 * creating a new row
	 * @param rowSeatsNumber number of seats in this row
	 */
	public Row(int rowSeatsNumber){
		this.rowSeatsNumber = rowSeatsNumber;
		
		seats = new ArrayList<>();
		
		for(int i = 0; i < rowSeatsNumber; i++){
			seats.add(new Seat());
		}
		
	}
	
	/**
	 * getting seats of this row
	 * @return seats of this row
	 */
	public ArrayList<Seat> getSeats(){
		return seats;
	}
	
	/**
	 * checking if this row has empty seats 
	 * @return true if has empty seats
	 */
	public boolean hasEmptySeats(){
		
		for(Seat seat : seats){
			if(!seat.getStatus()){
				return true;
			}
		}
		
		return false;
	}
	

}
