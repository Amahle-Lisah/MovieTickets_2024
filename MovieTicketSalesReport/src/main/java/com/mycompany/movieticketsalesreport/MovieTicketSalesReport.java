package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTicketSalesReport {
    
    public static void main(String[] args)
    {
        // Single-dimensional array for movie names
        String[] movies =
        {
            "Napoleon",
            "Oppenheimer"
        };

        // Two-dimensional array for monthly ticket sales
        int[][] movieTicketSales =
        {
            {3000, 1500, 1700},
            {3500, 1200, 1600}
        };

        // Single-dimensional array for total sales
        int[] totalSales = new int[movies.length];

        MovieTickets movieObj = new MovieTickets();

        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();

        System.out.printf("%-15s %-10s %-10s %-10s%n",
                "", "JAN", "FEB", "MAR");

        System.out.println("-----------------------------------------------------");

        // Display rows and columns and calculate totals
        for (int row = 0; row < movieTicketSales.length; row++)
        {
            System.out.printf("%-15s", movies[row]);

            for (int col = 0; col < movieTicketSales[row].length; col++)
            {
                System.out.printf("%-10d", movieTicketSales[row][col]);
            }

            totalSales[row] =
                    movieObj.TotalMovieSales(movieTicketSales[row]);

            System.out.println();
        }

        System.out.println();

        // Display total sales for each movie
        for (int i = 0; i < movies.length; i++)
        {
            System.out.println("Total movie ticket sales for "
                    + movies[i] + ": "
                    + totalSales[i]);
        }

        System.out.println();

        // Display top performing movie
        System.out.println("Top performing movie: "
                + movieObj.TopMovie(movies, totalSales));
    }
}