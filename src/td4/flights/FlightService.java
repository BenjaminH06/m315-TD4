package td4.flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import td4.core.Product;
import td4.core.Service;
import td4.core.Service4PI;
import td4.trip.Description;

/**
 * This class allows the management of a set of flights
 * 
 * @author Mireille Blay-Fornarino
 * @param <T>
 *
 * 
 */

public class FlightService extends Service4PI<Flight> implements Service {

	private static List<Flight> flights = new ArrayList<>();

	public FlightService(List<Flight> flights) {
		super(flights);
		FlightService.flights = flights;
	}

	/**
	 * @param aDate : {@code LocalDate}
	 * @return the list of flights available on a given date {@code LocalDate}
	 */
	public List<Flight> getFlights(LocalDate aDate) {
		Stream<Flight> parallelStream = flights.parallelStream();
		Stream<Flight> results = parallelStream.filter(f -> (f.getDepartDate().equals(aDate)));
		return results.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @param d    : : {@code LocalDate}
	 * @param from : departure airport name
	 * @param to   : arrival airport name
	 * @return the list of flights available on a given date {@code LocalDate} from
	 *         a place to another place
	 */
	public List<Flight> getFlights(LocalDate d, String from, String to) {
		Stream<Flight> parallelStream = flights.parallelStream();
		Stream<Flight> results = parallelStream.filter(f -> f.match(d, from, to));
		return results.collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * @return a copy of the flight list sorted by price. The flights themselves are
	 *         not cloned.
	 */
	public List<Flight> sortedByPrice() {
		flights.sort(Comparator.comparing(Flight::getPrice));
		return new ArrayList<>(flights);
	}
	
	public void sortPriced() {
		FlightService.flights.sort(Comparator.comparing(Flight::getPrice));
	}
	
	public Flight getLessPriced() {
		FlightService.flights.sort(Comparator.comparing(Flight::getPrice));
		return flights.get(0);
	}

	@Override
	public Product find(Description description) {
		Product bestPrice = null;
		this.sortPriced();
		List<Flight> f = this.getFlights(description.getDepartDate(), description.getDepartPlace(), description.getArrivalPlace());
		if(f.size() > 0) {
			bestPrice = f.get(0);
		}
		return bestPrice;
	}

}
