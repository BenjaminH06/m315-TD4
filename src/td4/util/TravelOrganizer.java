package td4.util;

import java.util.ArrayList;
import java.util.List;

import td4.core.Product;
import td4.core.Service;
import td4.trip.Description;
import td4.trip.Trip;

public class TravelOrganizer  {
	
	private List<Service> services = new ArrayList<>();

	public TravelOrganizer() {
		
	}
	
	public TravelOrganizer(List<Service> l) {
		this.services = l;
	}
	
	public void addService(Service s) {
		this.services.add(s);
	}
	
	public Trip createATrip(Description d) {
		Trip trip = new Trip(d);
		for(int i = 0; i < services.size(); i++) {
			trip.addItem(services.get(i).find(d));
		}
		return trip;
	}
	
}
