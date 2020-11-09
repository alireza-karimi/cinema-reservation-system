import java.util.ArrayList;

/**
 * represents a theater in cinema
 * @author alireza
 * @version 1.0.0
 */
public class Theater {
	//code of this theater
	private int code;
	//number of seats in a row
	private int rowSeatsNumber;
	//number of rows in this theater
	private int rowsNumber;
	//storing all shows list
	private ArrayList<Show> shows;
	
	/**
	 * creating a new theater
	 * @param code unique code of this theater
	 * @param rowSeatsNumber number of seats in each row of this theater
	 * @param rowsNumber number of rows of this theater
	 */
	public Theater(int code, int rowSeatsNumber, int rowsNumber){
		this.code = code;
		this.rowsNumber = rowsNumber;
		this.rowSeatsNumber = rowSeatsNumber;	
		shows = new ArrayList<>();
	}
	
	/**
	 * getting unique code of this theater
	 * @return unique code of this theater
	 */
	public int getCode(){
		return code;
	}
	
	/**
	 * adding some new rows to theater
	 * @param newRowsNumber number of new rows to be added
	 */
	public void addRowToTheater(int newRowsNumber){
		
		rowsNumber += newRowsNumber;
		
		for(Show show : shows){
			show.getRows().add(new Row(rowSeatsNumber));
		}
		
		System.out.println("New rows added!");
	}
	
	/**
	 * checking if a show exists in this theater
	 * @param showName show name
	 * @param showDay show day
	 * @param showPeriod show period
	 * @return true if exists
	 */
	public boolean showExist(String showName, String showDay, String showPeriod){
		
		for(Show item : shows){
			if(item.getName().equals(showName)){
				if(item.getDay().equals(Day.valueOf(showDay)) && item.getPeriod().equals(Period.valueOf(showPeriod))){
					return true;
				}
			}
		}
		
		return false;	
	}	
	
	/**
	 * checking if adding an specific show to this theater is possible or not
	 * @param show show object
	 * @return true if possible
	 */
	private boolean addingShowIsPossible(Show show){
		
		Day showDay = show.getDay();
		Period showPeriod = show.getPeriod();
		
		for(Show item : shows){
			
			if(item.getDay().equals(showDay) && item.getPeriod().equals(showPeriod)){
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * adding a show to this theater
	 * @param show show object
	 */
	public void addShow(Show show){

		if(addingShowIsPossible(show)){
			shows.add(show);
			
			for(int i = 0; i < rowsNumber; i++){
				show.getRows().add(new Row(rowSeatsNumber));
			}
			
			System.out.println("show added!");
		}
		else{
			System.out.println("Adding this show to the theater is not possible!");
			return;
		}
		
	}
	
	/**
	 * checking if reserving a show in this theater is possible or not
	 * @param showName show name
	 * @return true if possible
	 */
	public boolean reservationIsPossible(String showName){
		
		Show show = null;
		
		for(Show item : shows){
			if(item.getName().equals(showName)){
				show = item;
			}
		}
		
		if(show == null){
			return false;
		}
		
		//checking if the show has empty seats
		if(!show.hasEmptySeat()){
			return false;		
		}
		
		return true;
		
	}
	
	/**
	 * reserving some seats for a show in this theater
	 * @param showName show name
	 * @param customer customer object
	 */
	public void reserveByShowName(String showName, Customer customer){
		
		if(reservationIsPossible(showName)){
			
			//getting the show object
			Show show = null;
			for(Show item : shows){
				if(item.getName().equals(showName)){
					show = item;
				}
			}
			
			show.reserve(rowSeatsNumber, customer);
		}

	}

	
}
