package com.mycompany.movieticketapp;

/**
 * This class simply holds the data captured on the form: the movie
 * name, the ticket price and the number of tickets. It does not
 * calculate or validate anything itself - it is just a container,
 * so the data can be passed into the ValidateData method as one
 * object instead of three separate values.
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTicketData {

    private final String movieName;
    private final double ticketPrice;
    private final int numberOfTickets;

    public MovieTicketData(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}