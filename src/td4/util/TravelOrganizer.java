package td4.util;

import java.util.List;

import td4.core.Service;
import td4.trip.Description;
import td4.trip.Trip;

public class TravelOrganizer implements Service {
	
	private List<Service> l;

	public TravelOrganizer() {
		
	}
	
	public TravelOrganizer(List<Service> l) {
		this.l = l;
	}
	
	public void addService(Service s) {
		
	}
	
	public Trip createATrip(Description d) {
		return null;
	}
	
}
