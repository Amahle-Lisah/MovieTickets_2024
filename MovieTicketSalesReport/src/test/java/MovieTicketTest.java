/* CODE ATTRIBUTION
 * TITLE: Java Tutorial
 * AUTHOR: W3Scools
 * DATE ACCESSED: 18/11/26
 * AVAILABILITY:  https://www.w3schools.com/java/
 *
 *TITLE: Node.js testing
 *AUTHOR: W3Schools
 *DATE ACCESSED: 18/11/26
 *AVAILABILITY: https://www.w3schools.com/nodejs/nodejs_testing.asp
 */

import com.mycompany.movieticketsalesreport.MovieTickets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the MovieTickets class.
 *
 * @author Amahle Lisah Khumalo
 */

public class MovieTicketTest
{
    // constructor
    public MovieTicketTest()
    {

    }

    // Tests the TotalMovieSales method. This test checks whether the method correctly calculates the total ticket sales for a movie.
    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales()
    {
        // Sample monthly ticket sales for Napoleon
        int[] movieTicketSales =
        {
            3000, 1500, 1700
        };

        // Creates MovieTickets object
        MovieTickets movieObj = new MovieTickets();

        // Expected total sales
        int expected = 6200;

        // Actual result returned by the method
        int actual = movieObj.TotalMovieSales(movieTicketSales);

        // Verify that expected and actual values are equal
        assertEquals(expected, actual);
    }

    /**
     * Test the TopMovie method.
     * This test checks whether the method correctly identifies
     * the movie with the highest total sales.
     */
    @Test
    public void TopMovieSales_ReturnsTopMovie()
    {
        // Movie names
        String[] movies =
        {
            "Napoleon",
            "Oppenheimer"
        };

        // Total sales for each movie
        int[] totalSales =
        {
            6200,
            6300
        };

        // Create MovieTickets object
        MovieTickets movieObj = new MovieTickets();

        // Expected top-performing movie
        String expected = "Oppenheimer";

        // Actual result returned by the method
        String actual = movieObj.TopMovie(movies, totalSales);

        // Verify that expected and actual values are equal
        assertEquals(expected, actual);
    }
}// end of juint test class

