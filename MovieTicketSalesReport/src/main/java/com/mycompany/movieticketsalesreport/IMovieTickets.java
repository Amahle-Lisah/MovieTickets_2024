package com.mycompany.movieticketsalesreport;

/**
 *
 * @author Amahle Lisah Khumalo
 */

public interface IMovieTickets
{
    int TotalMovieSales(int[] movieTicketSales);

    String TopMovie(String[] movies, int[] totalSales);
}

