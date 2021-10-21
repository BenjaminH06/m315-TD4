package td4.trip;


import java.util.ArrayList;
import java.util.List;

import td4.core.Product;

public class Trip {
	
	Description description;
	List<Product> products = new ArrayList<>();
	
	public Trip(Description d) {
		this.description = d;
	}
	
	
	public List<Product> getProducts() {
		return this.products;
	}
	
	public void setProducts(List<Product> p) {
		this.products = p;
	}
	
	public double getPrice() {
		return 0;
		
	}
	
	public void addItem(Product p) {
		this.products.add(p);
	}
	
	public String toString() {
		return null;
	}
}
