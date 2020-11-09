/**
 * representing a single seat
 * @author alireza
 * @version 1.0.0
 */
public class Seat {
	//false means this seat is empty
	private boolean status;
	
	/**
	 * creating a new seat
	 */
	public Seat(){
		this.status = false;
	}
	
	/**
	 * getting status of this seat
	 * @return false if empty
	 */
	public boolean getStatus(){
		return status;
	}
	
	/**
	 * setting status of this seat
	 * @param status false if empty
	 */
	public void setStatus(boolean status){
		this.status = status;
	}
	

}
