package td4.motel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import td4.cars.Car;
import td4.cars.CarRental;
import td4.util.DateTools;

public class RoomRentalTest {
	Room myRoom ;
	RoomRental RoomRental;
	
	@BeforeEach
	public void setUp() {
		myRoom = new Room(50, "Ibis", "Nice", 1);
	}


	@Test
	public void testRoomRentalCreation() {
		RoomRental = new RoomRental(myRoom, LocalDate.of(2018, 8, 30), 3);
		assertEquals( myRoom.getPrice()*3, RoomRental.getPrice());
	}

	@Test
	public void testRoomRentalAvailability() {
		RoomRental = new RoomRental(myRoom, LocalDate.of(2018, 8, 30), 3);
		LocalDate[] dates = DateTools.getDays(LocalDate.of(2018, 8, 30), 3);
		assertEquals(3, dates.length );
		dates = DateTools.getDays(LocalDate.of(2018, 8, 30), 1);
		assertTrue(RoomRental.includeADate(dates),"date de début OK");
		
		dates = DateTools.getDays(LocalDate.of(2018, 8, 29), 1);
		assertFalse(RoomRental.includeADate(dates),"date à un jour avant");
		
		dates = DateTools.getDays(LocalDate.of(2018, 9, 2), 1);
		assertFalse(RoomRental.includeADate(dates),"date à un jour après");
		
		dates = DateTools.getDays(LocalDate.of(2018, 8, 25), 10);
		assertTrue(RoomRental.includeADate(dates),"date incluse après");
		
		dates = DateTools.getDays(LocalDate.of(2018, 9, 1), 1);
		assertTrue(RoomRental.includeADate(dates),"date incluse sur la fin");
		dates = DateTools.getDays(LocalDate.of(2018, 8, 31), 10);
		assertTrue(RoomRental.includeADate(dates),"date incluse sur la fin");
	}

	@Test
	public void testGetPrice() {
		RoomRental = new RoomRental(myRoom, LocalDate.of(2017, 8, 31), 3);
		assertEquals(50,myRoom.getPrice());
		assertEquals(50.0*3,RoomRental.getPrice());
	}

}
