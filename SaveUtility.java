import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveUtility {
    public static void saveHotels(List<Hotel> hotels) {
        try (PrintWriter writer = new PrintWriter("Sorted.txt")) {
            for (Hotel hotel : hotels) {
                writer.println(hotel.getHotelName() + "," + hotel.getStarRating() + "," + hotel.getHotelPrice()
                );
            }
            System.out.println("Hotel information saved to Sorted.txt");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
