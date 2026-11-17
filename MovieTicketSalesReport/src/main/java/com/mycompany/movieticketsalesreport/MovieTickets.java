package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 */

// This class implements the IMovieTickets interface
public class MovieTickets implements IMovieTickets
{
    // Calculate the total ticket sales for one movie
    @Override
    public int TotalMovieSales(int[] movieTicketSales)
    {
        int total = 0;

        for (int sale : movieTicketSales)
        {
            total += sale;
        }

        return total;
    }

    // Determine the top performing movie
    @Override
    public String TopMovie(String[] movies, int[] totalSales)
    {
        int highestIndex = 0;

        for (int i = 1; i < totalSales.length; i++)
        {
            if (totalSales[i] > totalSales[highestIndex])
            {
                highestIndex = i;
            }
        }

        return movies[highestIndex];
    }
}