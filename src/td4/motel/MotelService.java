package td4.motel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import td4.cars.Car;
import td4.cars.CarRental;
import td4.core.Product;
import td4.core.Service;
import td4.core.Service4PI;
import td4.flights.Flight;
import td4.trip.Description;
import td4.util.DateTools;
import td4.util.NotPossibleCarRentalException;

public class MotelService extends Service4PI<RoomRental> implements Service {
	
	private List<Room> rooms = new ArrayList<>();
	
	private static List<RoomRental> roomRentals = new ArrayList<>();

	public MotelService(List<Room> rooms) {
		super(roomRentals);
		this.rooms = rooms;
	}

	@Override
	public Product find(Description description) {
		return null;
	}
	
	public RoomRental book(Room r, LocalDate fromDate, int numberOfDays) throws NotPossibleCarRentalException  {
		RoomRental roomRental = null;
		if (rooms == null || !(rooms.contains(r)) )
			throw new NotPossibleCarRentalException("Not known car");
		LocalDate[] dates = DateTools.getDays(fromDate, numberOfDays);
		if (isAvailable(r, dates)) {
			roomRental = new RoomRental(r, fromDate, numberOfDays);
			roomRentals.add(roomRental);
		}
		return roomRental;
	}
	
	public List<Room> getAvailableRooms(LocalDate d, int nbDays) {
		ArrayList<Room> availableCars = new ArrayList<>();
		LocalDate[] dates = DateTools.getDays(d, nbDays);
		for (Room r : rooms) {
			if (isAvailable(r, dates)) {
				availableCars.add(r);
			}
		}
		return availableCars;
	}
	
	private boolean isAvailable(Room r, LocalDate[] dates) {
		for (RoomRental roomRental : roomRentals) {
			if (r.equals(roomRental.getRoom()) &&
				(roomRental.includeADate(dates)) ) {
				return false;	
			}	
		}
		return true;
	}
	
}
