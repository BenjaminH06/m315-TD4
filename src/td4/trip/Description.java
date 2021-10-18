package td4.trip;

import java.time.LocalDate;

public class Description {
	private LocalDate departDate;
	private String departPlace;
	private String arrivalPlace;
	private int duration;
	
	public Description(LocalDate departDate, String departPlace, String arrivalPlace, int duration) {
		this.departDate = departDate;
		this.departPlace = departPlace;
		this.arrivalPlace = arrivalPlace;
		this.duration = duration;
	}
	
	public LocalDate getDepartDate() {
		return this.departDate;
	}
	
	public String getDepartPlace() {
		return this.departPlace;
	}
	
	public String getArrivalPlace() {
		return this.arrivalPlace;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	
	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
