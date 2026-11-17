package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTicketSalesReport {

    public static void main(String[] args)
    {
        // Store the movie names in a single-dimensional array
        String[] movies =
        {
            "Napoleon",
            "Oppenheimer"
        };

        // Store the monthly ticket sales in a two-dimensional array
        int[][] movieTicketSales =
        {
            {3000, 1500, 1700},
            {3500, 1200, 1600}
        };

        // Store the total sales calculated for each movie
        int[] totalSales = new int[movies.length];

        // Create an object of the MovieTickets class
        MovieTickets movieObj = new MovieTickets();

        // Display the report heading
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();

        // Display the column headings
        System.out.printf("%-15s %-10s %-10s %-10s%n",
                "", "JAN", "FEB", "MAR");

        System.out.println("-----------------------------------------------------");

        // Display movie sales data and calculate total sales
        for (int row = 0; row < movieTicketSales.length; row++)
        {
            // Display the movie name
            System.out.printf("%-15s", movies[row]);

            // Display the monthly sales for each movie
            for (int col = 0; col < movieTicketSales[row].length; col++)
            {
                System.out.printf("%-10d", movieTicketSales[row][col]);
            }

            // Calculate and store the total sales for the current movie
            totalSales[row] =
                    movieObj.TotalMovieSales(movieTicketSales[row]);

            System.out.println();
        }

        System.out.println();

        // Display the total sales for each movie
        for (int i = 0; i < movies.length; i++)
        {
            System.out.println("Total movie ticket sales for "
                    + movies[i] + ": "
                    + totalSales[i]);
        }

        System.out.println();

        // Display the top-performing movie based on total sales
        System.out.println("Top performing movie: "
                + movieObj.TopMovie(movies, totalSales));
    }
}