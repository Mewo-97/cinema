package ticket;

public class SeatMap  {
    public boolean[][] seats;

    public SeatMap(int rows, int columns) {
        seats = new boolean[rows][columns];
    }
    // It ensures the row and column exist in the seat map
    public boolean isValidSeat(int row, int col) {
        return (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length);
    }
    
    public boolean bookSeat(int row, int col) {
        if (!isValidSeat(row, col)) return false;
        if (seats[row][col]) return false; 
        seats[row][col] = true;
        return true;
    }

    public void cancelSeat(int row, int col) {
        if (isValidSeat(row, col)) {
            seats[row][col] = false;
        }
    }
    public void displaySeatMap() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }
}
