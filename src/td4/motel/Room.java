package td4.motel;

import td4.core.Product;

public class Room implements Product {

	private double dayPrice;
	private String Motel;
	private String City;
	private int Number;
	
	public Room(double dayPrice, String Motel, String City, int Number) {
		this.dayPrice = dayPrice;
		this.Motel = Motel;
		this.City = City;
		this.Number = Number;
	}
	
	@Override
	public double getPrice() {
		return this.dayPrice;
	}
	
	public void setPrice(double dayPrice) {
		this.dayPrice = dayPrice;
	}
	
	public String getMotel() {
		return this.Motel;
	}
	
	public void setMotel(String Motel) {
		this.Motel = Motel;
	}
	
	public String getCity() {
		return this.City;
	}
	
	public void setCity(String City) {
		this.City = City;
	}
	
	public int getNumber() {
		return this.Number;
	}
	
	public void setNumber(int Number) {
		this.Number = Number;
	}

}
