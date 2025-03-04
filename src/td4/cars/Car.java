package td4.cars;

import td4.core.Product;

/**
 * This class defines the notion of a car to be rented by associating it with a price per day.
 *
 *  @author Mireille Blay-Fornarino
 *
 * @version 1.0
 */

public class Car implements Product {

	private String numberPlate;
	private double dayPrice;
	
	
	public Car(String numberPlate, double dayPrice) {
		this.numberPlate = numberPlate;
		this.dayPrice = dayPrice;
	}
	
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public double getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + // ", rentals=" + rentals + 
				", dayPrice=" + dayPrice + "]";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
