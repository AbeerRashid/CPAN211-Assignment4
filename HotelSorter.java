// Person 3 - Eton Price Sorting and Console Output

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelSorter {

    // Sort hotels by star rating and hotel name //
    public static void sortByStarRating(List<Hotel> hotels) {
        Collections.sort(hotels);
    }

    // Sort hotels from lowest to highest price //
    public static void sortByPrice(List<Hotel> hotels) {
        Comparator<Hotel> priceComparator =
                Comparator.comparingDouble(Hotel::getHotelPrice);

        Collections.sort(hotels, priceComparator);
    }

    // Print hotel information to the console //
    public static void printHotels(List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            System.out.println(
                hotel.getHotelName() + " | " +
                hotel.getStarRating() + " Stars | $" +
                String.format("%.2f", hotel.getHotelPrice())
            );
        }
    }

    // Display both sorting orders //
    public static void displaySortedHotels(List<Hotel> hotels) {

        System.out.println("\nHotels sorted by star rating and name:");
        sortByStarRating(hotels);
        printHotels(hotels);

        System.out.println("\nHotels sorted by lowest price:");
        sortByPrice(hotels);
        printHotels(hotels);
    }
}