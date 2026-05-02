package core_and_data;

import ticket.SeatMap;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;

public class Time {
    public LocalTime time;
    public String screen;
    public SeatMap s = new SeatMap(0, 0);

    @Override
    public String toString() {
        return "Showtime: " + this.time + " Screen:" + this.screen;
    }

    public Time(String t) {
        try {
            this.time = LocalTime.parse(t);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
    }

}