package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 *  This Interface contains the methods that must be implemented by the MovieTickets class
 */

public interface IMovieTickets
{
    // Calculates and returns the total ticket sales for a movie
    int TotalMovieSales(int[] movieTicketSales);

    // Determines and returns the top-performing movie
    String TopMovie(String[] movies, int[] totalSales);
    
}// End of Class interface