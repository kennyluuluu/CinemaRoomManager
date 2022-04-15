package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void displayCinema(char[][] cinema, int rows, int seats) {
        // print Cinema
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int j = 1; j <= seats; j++) {
            System.out.print(" " + j);
        }
        System.out.print("\n");

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= seats; j++) {
                System.out.print(" " + cinema[i-1][j-1]);
            }
            System.out.print("\n");
        }
    }

    public static int buyTicket(char[][] cinema, int rows, int seatsPerRow, Scanner sc) {
        System.out.println("Enter a row number:");
        int n = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int m = sc.nextInt();

        if (n <= 0 || n > rows || m <= 0 || m > seatsPerRow) {
            System.out.println("Wrong input!");
            return buyTicket(cinema, rows, seatsPerRow, sc);
        } else if (cinema[n-1][m-1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            return buyTicket(cinema, rows, seatsPerRow, sc);
        }

        cinema[n-1][m-1] = 'B';

        System.out.printf("%nTicket price: $");
        if (rows * seatsPerRow <= 60 || n <= rows / 2) {
            System.out.println(10);
            return 10;
        } else {
            System.out.println(8);
            return 8;
        }
    }

    public static void statistics(int ticketsSold, final int CINEMA_CAPACITY, int currentIncome, final int SOLD_OUT_INCOME) {
        System.out.printf("%nNumber of purchased tickets: %d%n", ticketsSold);
        System.out.printf("Percentage: %.2f%%%n", 100.0 * ticketsSold / CINEMA_CAPACITY);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", SOLD_OUT_INCOME);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = sc.nextInt();

        char[][] cinema = new char[rows][seatsPerRow];
        for (char[] row : cinema) {
            Arrays.fill(row, 'S');
        }

        int ticketsSold = 0;
        final int CINEMA_CAPACITY = rows * seatsPerRow;
        int currentIncome = 0;
        final int SOLD_OUT_INCOME;
        if(CINEMA_CAPACITY <= 60) {
            SOLD_OUT_INCOME = CINEMA_CAPACITY * 10;
        } else {
            SOLD_OUT_INCOME = (rows / 2) * seatsPerRow * 10 + (rows - (rows / 2)) * seatsPerRow * 8;
        }

        while(true) {
            System.out.println("");
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            switch (sc.nextInt()) {
                case 1:
                    displayCinema(cinema, rows, seatsPerRow);
                    break;
                case 2:
                    currentIncome += buyTicket(cinema, rows, seatsPerRow, sc);
                    ticketsSold++;
                    break;
                case 3:
                    statistics(ticketsSold, CINEMA_CAPACITY, currentIncome, SOLD_OUT_INCOME);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Error!");
            }
        }
    }
}