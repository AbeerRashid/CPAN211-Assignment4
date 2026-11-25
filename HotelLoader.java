//Person 2 - Abeer Hotel Loader
// Classes used to read files and then store hotel collections into a list
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelLoader {
    //reads hotel information from hotel.txt and then retuns as a list of hotel objects
    public static List<Hotel> loadHotels(String filename) {
        //Store all hotel objects read from the file
        List<Hotel> hotels = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            //read file one at a time until end of file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    System.out.println("Invalid record skipped: " + line);
                    continue; // Skip invalid line and move to next record
                }
                String hotelName = parts[0].trim();

                int starRating = Integer.parseInt(parts[1].trim());

                double price = Double.parseDouble(parts[2].trim());

                Hotel hotel = new Hotel(hotelName, starRating, price);

                // Add to collection
                hotels.add(hotel);
                }

            }
        // File cannot be found
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found -> " + filename);
        }

        // Star rating or price contains invalid data
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format found in file.");
        }

        // Any other file reading errors
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Return the completed list of hotels
        return hotels;
    }
}