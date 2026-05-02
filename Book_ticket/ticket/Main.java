import java.util.*;

class MovieShow {
    String title;
    String time;
    SeatMap seatMap;

    public MovieShow(String title, String time, SeatMap seatMap) {
        this.title = title;
        this.time = time;
        this.seatMap = seatMap;
    }

    public MovieShow(String title, String time) {
        this(title, time, new SeatMap(5, 5));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieShow movie = new MovieShow("Avengers", "7 PM");
        System.out.println("Enter row:");
        int row = input.nextInt();
        System.out.println("Enter column:");
        int col = input.nextInt();
        if (movie.seatMap.bookSeat(row, col)) {
            System.out.println("Booking successful");
        } else {
            System.out.println("Seat already taken or invalid");
        }
        
        // check if seats are empty or not and print x if is taken  
        for (int i = 0; i < movie.seatMap.seats.length; i++) {
            for (int j = 0; j < movie.seatMap.seats[i].length; j++) {
                System.out.print(movie.seatMap.seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }
}
