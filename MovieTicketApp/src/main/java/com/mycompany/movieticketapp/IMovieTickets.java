package com.mycompany.movieticketapp;

/**
 * This is the interface for the movie tickets application.
 * It only lists the two methods that must exist. The MovieTickets
 * class writes the actual code for each one.
 *
 * @author Amahle Lisah Khumalo
 */
public interface IMovieTickets {

    // Returns the total ticket price, including 14% VAT
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);

    // Returns true only if the movie name, price and number of
    // tickets are all valid
    boolean ValidateData(MovieTicketData movieTicketData);
}