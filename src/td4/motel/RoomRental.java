package td4.motel;

import java.time.LocalDate;

import td4.core.Product;

public class RoomRental implements Product {
	
	private Room room;
	private double dayPrice;
	private LocalDate beginDate;
	private int duration;
	
	public RoomRental(Room r, LocalDate b, int duration) {
		super();
		this.room = r;
		this.dayPrice = r.getPrice();
		this.beginDate = b;
		this.duration = duration;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setRoom(Room r) {
		this.room = r;
	}
	
	public LocalDate getBeginDate() {
		return this.beginDate;
	}
	
	public void setBeginDate(LocalDate d) {
		this.beginDate = d;
	}
	
	@Override
	public double getPrice() {
		return dayPrice * duration;
	}
	
	public void setPrice(double d) {
		this.dayPrice = d;
	}
	
	public boolean includeADate(LocalDate[] dates) {
		for (LocalDate d : dates) {
			if (d.equals(beginDate)) 
				return true;
			if ( (d.isAfter(beginDate)) && 
					(d.isBefore(beginDate.plusDays(duration) ) ) )
				return true;
		}
		return false;
	}

}
