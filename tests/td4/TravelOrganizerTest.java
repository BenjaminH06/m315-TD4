package td4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import td4.cars.Car;
import td4.cars.CarRentalService;
import td4.core.Service;
import td4.flights.Flight;
import td4.flights.FlightService;
import td4.motel.MotelService;
import td4.motel.Room;
import td4.trip.Description;
import td4.trip.Trip;
import td4.util.TravelOrganizer;


class TravelOrganizerTest {

	CarRentalService havis;
	CarRentalService easyCar;
	
	FlightService easyJet;
	FlightService airFrance;
	
	Description description;
	TravelOrganizer travelOrganizer;

	Flight niceParis;
	Flight niceParisNow;
	@BeforeEach
	void setUp() {
		Car myCar0 = new Car("1111 AB 06", 50);
		Car myCar1 = new Car("1111 AB 75", 100);
		Car myCar2 = new Car("1111 AB 83", 75);
		havis = new CarRentalService(new ArrayList<>(Arrays.asList(myCar0, myCar1, myCar2)));

		Car yourCar0 = new Car("1111 AB 06", 50);
		Car yourCar1 = new Car("1111 AB 75", 100);
		Car yourCar2 = new Car("1111 AB 83", 75);
		easyCar = new CarRentalService(new ArrayList<>(Arrays.asList(yourCar0, yourCar1, yourCar2)));

		ArrayList<Flight> list = new ArrayList<>();
		Flight belfortParis = new Flight("Belfort");
		//System.out.println(belfortParis);
		list.add(belfortParis);
		list.add(new Flight("Nice"));

		easyJet = new FlightService(list);

		list = new ArrayList<>();
		niceParis = new Flight(100, LocalDate.of(2017, 12, 24), LocalTime.of(7, 45), "Nice", "Paris");
		list.add(niceParis);
		list.add(new Flight(150, LocalDate.of(2017, 12, 24), LocalTime.of(9, 30), "Nice", "Paris"));
		niceParisNow = new Flight(150, LocalDate.now(), LocalTime.of(9, 30), "Nice", "Paris");
		list.add(niceParisNow);
		list.add(new Flight(150, LocalDate.of(2017, 12, 24), LocalTime.of(18, 30), "Paris", "Nice"));

		airFrance = new FlightService(list);

		description = new Description(LocalDate.of(2017, 12, 24), "Nice", "Paris", 3);

		travelOrganizer = new TravelOrganizer();
	}

	@Test
	void testcreateATripwithCars() {
		initcars();
		Trip trip = travelOrganizer.createATrip(description);
		assertTrue(trip != null);
		assertEquals(2, trip.getProducts().size());
	}

	@Test
	void testcreateATripwithFlight() {
		initFlights();
		Trip trip = travelOrganizer.createATrip(description);
		//System.out.println(trip.getProducts());
		assertTrue(trip != null);
		assertEquals(2, trip.getProducts().size());
		assertEquals(niceParis, trip.getProducts().get(0));
		description = new Description(LocalDate.now(), "Nice", "Paris", 3);
		trip = travelOrganizer.createATrip(description);
		//System.out.println(trip.getProducts());
		assertTrue(trip != null);
		assertEquals(2, trip.getProducts().size());
	}

	@Test
	void testcreateATripwithFlightAndCars() {
		initcars();
		initFlights();
		Trip trip = travelOrganizer.createATrip(description);
		
		assertTrue(trip != null);
		//System.out.println(trip.getProducts());
		assertEquals(4, trip.getProducts().size());
	}

	private void initcars() {
		travelOrganizer.addService(havis);
		travelOrganizer.addService(easyCar);
	}

	private void initFlights() {
		travelOrganizer.addService(easyJet);
		travelOrganizer.addService(airFrance);
	}
	private void initHotels() {
		Room myRoom0 = new Room(50, "Ibis", "Nice", 1);
		Room myRoom1 = new Room(60, "Negressco", "Nice", 2);
		Room myRoom2 = new Room(40, "BNB", "Toulouse", 3);
		Service service = new MotelService( new ArrayList<>(Arrays.asList(myRoom0, myRoom1, myRoom2) )  )  ;
		travelOrganizer.addService(service);
	}
	
	@Test
	void testcreateATripwithFlightAndCarsReduced() {
		initcars();
		initFlights();
		description = new Description(LocalDate.now(), "Belfort", "Paris", 3);
		Trip trip = travelOrganizer.createATrip(description);
		assertTrue(trip != null);
		//System.out.println(trip.getProducts());
		assertEquals(4, trip.getProducts().size());
	}
	
	@Test
	void testcreateATripwithFlightAndCarsAndHotel() {
		initHotels();
		initcars();
		initFlights();
		Trip trip = travelOrganizer.createATrip(description);
		
		assertTrue(trip != null);
		//System.out.println(trip.getProducts());
		assertEquals(5, trip.getProducts().size());
	}

	@Override
	public String toString() {
		return "TravelOrganizerTest [havis=" + havis + ", easyCar=" + easyCar + ", easyJet=" + easyJet + ", airFrance="
				+ airFrance + ", description=" + description + ", travelOrganizer=" + travelOrganizer + "]";
	}
	
	
	
}