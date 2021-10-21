package td4.motel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import td4.cars.Car;
import td4.cars.CarRental;
import td4.cars.CarRentalService;
import td4.util.NotPossibleCarRentalException;

public class RoomRentalServiceTest {
	MotelService service ; 
	Room myRoom0 = new Room(50, "Ibis", "Nice", 1);
	Room myRoom1 = new Room(60, "Negressco", "Nice", 2);
	Room myRoom2 = new Room(40, "BNB", "Toulouse", 3);
	LocalDate currentDate;
	
	@Before
	public void setUp() {
		myRoom0 = new Room(50, "Ibis", "Nice", 1);
		myRoom1 = new Room(60, "Negressco", "Nice", 2);
		myRoom2 = new Room(40, "BNB", "Toulouse", 3);
		service = new MotelService( new ArrayList<>(Arrays.asList(myRoom0, myRoom1, myRoom2) )  )  ;
		
	}

	@Test
	public void testGetAvailableRooms() throws NotPossibleCarRentalException {
		LocalDate current = LocalDate.of(2020,9,11);
		List<Room> possibleRooms = 
				service.getAvailableRooms(current, 2);
		assertEquals(3, possibleRooms.size());
		
		RoomRental roomRental = service.book(myRoom0,current,2);
		assertTrue(roomRental != null);
		possibleRooms = 
				service.getAvailableRooms(current, 1);
		assertEquals(2, possibleRooms.size());
		possibleRooms = 
				service.getAvailableRooms(current, 2);
		assertEquals(2, possibleRooms.size());
		possibleRooms = 
				 service.getAvailableRooms(LocalDate.of(2020,9,12), 1);
		assertEquals(2, possibleRooms.size());
		possibleRooms = 
				service.getAvailableRooms(LocalDate.of(2020,9,13), 1);
		assertEquals(3, possibleRooms.size());
		
	}
	
	
	@Test
	public void testBookAnAvalaibleRooms() throws NotPossibleCarRentalException {
		RoomRental roomRental = service.book(myRoom0,LocalDate.of(2018,9,11), 2);
		assertFalse(roomRental==null);
		List<Room> possibleRooms =  service.getAvailableRooms(LocalDate.of(2018,9,11), 1);
		assertEquals(2, possibleRooms.size());

		possibleRooms =  service.getAvailableRooms(LocalDate.of(2018,9,12), 3);
		assertEquals(2, possibleRooms.size());
		
		possibleRooms =  service.getAvailableRooms(LocalDate.of(2018,9,13), 3);
		assertEquals(3, possibleRooms.size());
		
		possibleRooms =  service.getAvailableRooms(LocalDate.of(2018,9,9), 4);
		assertEquals(2, possibleRooms.size());
		
		possibleRooms =  service.getAvailableRooms(LocalDate.of(2018,9,19), 7);
		assertEquals(3, possibleRooms.size());
		
	}
	
	
	@Test
	public void testBookANonAvalaibleRooms() throws NotPossibleCarRentalException {
		RoomRental roomRental = service.book(myRoom0,LocalDate.of(2020,9,11), 2);
		assertFalse(roomRental==null);
		roomRental = service.book(myRoom0,LocalDate.of(2020,9,12), 2);
		assertTrue(roomRental==null);
	}
	
	@Test
	public void testGetNotAvailableCars() throws NotPossibleCarRentalException {
		service.book(myRoom0,LocalDate.of(2020,9,11), 2);
		List<Room> possibleRooms = service.getAvailableRooms(LocalDate.of(2020,9,11), 2);
		assertEquals(2, possibleRooms.size());
		possibleRooms = service.getAvailableRooms(LocalDate.of(2020,9,12), 2);
		assertEquals(2, possibleRooms.size());
		possibleRooms = service.getAvailableRooms(LocalDate.of(2020,9,13), 2);
		assertEquals(3, possibleRooms.size());
	}
	
}
