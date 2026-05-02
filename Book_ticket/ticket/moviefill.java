package ticket;
import java.io.*;
import core_and_data.Time;
import java.util.*;
import java.nio.file.*;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

class MovieShow {
    String title;
    ArrayList<Time> showtimes = new ArrayList<Time>();
    LocalTime du;

    public MovieShow(String title, ArrayList<String> times, ArrayList<SeatMap> arr) {
        this.title = title;
        for (int i = 0; i < times.size(); i++) {
            showtimes.add(new Time(times.get(i)));
            showtimes.get(i).s = arr.get(i);
        }
    }

    public MovieShow() {
        this.title = "";
        this.showtimes = new ArrayList<Time>();
    }

    public void Moviefill(File file) {
        try {
            String filename;
            if (file.getName().endsWith(".txt")) {
                filename = file.getName().substring(0, file.getName().length() - 4);
                title = filename;
            } else {
                throw new Exception("(.txt) ??");
            }
            List<String> lines = Files.readAllLines(file.toPath());
            int i = 0;
            StringTokenizer st;
            try {
                this.du = LocalTime.parse(lines.get(i).trim());
                i++;
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                return;
            }
            while (i < lines.size()) {
                if (lines.get(i).trim().isEmpty()) {
                    i++;
                    continue;
                }
                Time temp = new Time(lines.get(i).trim());
                i++;
                temp.screen = lines.get(i).trim();
                i++;
                st = new StringTokenizer(lines.get(i), "x");
                int rows = Integer.parseInt(st.nextToken().trim());
                int cols = Integer.parseInt(st.nextToken().trim());
                temp.s = new SeatMap(rows, cols);
                i++;
                for (int r = 0; r < rows; r++) {
                    st = new StringTokenizer(lines.get(i));
                    for (int c = 0; c < cols; c++) {
                        if (st.nextToken().equals("X")) {
                            temp.s.bookSeat(r, c);
                        }
                    }
                    i++;
                }
                showtimes.add(temp);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
class listmovies {
    ArrayList<MovieShow> movies = new ArrayList<MovieShow>();
    public void fillAtstart(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    MovieShow movie = new MovieShow();
                    movie.Moviefill(file);
                    movies.add(movie);
                }
            }
        } else {
            System.out.println("Directory not found or is empty.");
        }
    }

    public void showMovies() {
        for (MovieShow movie : movies) {
            System.out.println("Movie: " + movie.title);
            System.out.println("Duration: " + movie.du);
            for (Time t : movie.showtimes) {
                System.out.println(t.toString());
                t.s.displaySeatMap();
            }
        }
    }
    
    public ArrayList<MovieShow> getMovies() {
        return movies;
}}
public class moviefill {
    public static void main(String[] args) {
        listmovies l = new listmovies();
        l.fillAtstart("Book_ticket/core_and_data/Movies");
        l.showMovies();
        MovieShow movie = l.getMovies().get(0);
        movie.showtimes.get(0).s.bookSeat(0, 0);
        l.showMovies();
    }
}