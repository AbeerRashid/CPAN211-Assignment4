import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelApp extends Application {

    static class Hotel {
        String name;
        int stars;
        double price;

        Hotel(String name, int stars, double price) {
            this.name = name;
            this.stars = stars;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " | " + stars + " Stars | $" + price;
        }
    }

    @Override
    public void start(Stage stage) {
        ObservableList<Hotel> hotels = FXCollections.observableArrayList(
            new Hotel("Grand Royal Hotel", 5, 250),
            new Hotel("Comfort Inn", 3, 100),
            new Hotel("Luxury Palace", 5, 350),
            new Hotel("City View Hotel", 4, 180),
            new Hotel("Budget Stay", 2, 75)
        );

        ListView<Hotel> hotelList = new ListView<>(hotels);

        Button starButton = new Button("Sort by Star Rating");
        Button priceButton = new Button("Sort by Lowest Price");

        starButton.setOnAction(event ->
            FXCollections.sort(
                hotels,
                Comparator.comparingInt((Hotel h) -> h.stars).reversed()
            )
        );

        priceButton.setOnAction(event ->
            FXCollections.sort(
                hotels,
                Comparator.comparingDouble((Hotel h) -> h.price)
            )
        );

        Label heading = new Label("Hotel Sorting Application");

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(heading, hotelList, starButton, priceButton);

        Scene scene = new Scene(layout, 450, 400);
        stage.setTitle("Hotel Sorting App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}