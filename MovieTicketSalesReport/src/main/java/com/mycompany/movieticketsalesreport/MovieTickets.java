package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 */

// This class implements the methods declared in the IMovieTickets interface
public class MovieTickets implements IMovieTickets
{
    // Calculates the total ticket sales for a single movie
    @Override
    public int TotalMovieSales(int[] movieTicketSales)
    {
        // Variable used to store the running total
        int total = 0;

        // Loop through each month's ticket sales
        for (int sale : movieTicketSales)
        {
            total += sale;
        }

        // Return the total ticket sales
        return total;
    }

    // Determines which movie has the highest total ticket sales
    @Override
    public String TopMovie(String[] movies, int[] totalSales)
    {
        // Assume the first movie has the highest sales initially
        int highestIndex = 0;

        // Compare the remaining movie sales against the current highest
        for (int i = 1; i < totalSales.length; i++)
        {
            if (totalSales[i] > totalSales[highestIndex])
            {
                highestIndex = i;
            }
        }

        // Return the name of the top-performing movie
        return movies[highestIndex];
    }
}