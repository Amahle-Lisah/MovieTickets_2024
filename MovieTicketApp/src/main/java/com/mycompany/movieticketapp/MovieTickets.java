package com.mycompany.movieticketapp;

/**
 * This class implements IMovieTickets. It calculates the total
 * ticket price (with VAT) and checks that the captured data
 * follows the three validation rules from the paper.
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTickets implements IMovieTickets {

    // The VAT rate is a constant because it never changes
    // while the program is running
    private static final double VAT_RATE = 0.14;

    // Multiplies the number of tickets by the price, then adds 14% VAT
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        double vatAmount = subtotal * VAT_RATE;

        return subtotal + vatAmount;
    }

    // Checks the three validation rules from the paper.
    // If any one of them fails, the data is not valid.
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {

        // Rule 1: the movie name cannot be empty
        if (movieTicketData.getMovieName() == null || movieTicketData.getMovieName().isEmpty()) {
            return false;
        }

        // Rule 2: the ticket price cannot be 0 or less
        if (movieTicketData.getTicketPrice() <= 0) {
            return false;
        }

        // Rule 3: the number of tickets cannot be 0 or less
        if (movieTicketData.getNumberOfTickets() <= 0) {
            return false;
        }

        // If none of the rules above failed, the data is valid
        return true;
    }
}