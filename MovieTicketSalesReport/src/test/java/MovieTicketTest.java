import com.mycompany.movieticketsalesreport.MovieTickets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Amahle Lisah Khumalo
 */

public class MovieTicketTest
{
    public MovieTicketTest()
    {

    }

    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales()
    {
        int[] movieTicketSales =
        {
            3000, 1500, 1700
        };

        MovieTickets movieObj = new MovieTickets();

        int expected = 6200;
        int actual = movieObj.TotalMovieSales(movieTicketSales);

        assertEquals(expected, actual);
    }

    @Test
    public void TopMovieSales_ReturnsTopMovie()
    {
        String[] movies =
        {
            "Napoleon",
            "Oppenheimer"
        };

        int[] totalSales =
        {
            6200,
            6300
        };

        MovieTickets movieObj = new MovieTickets();

        String expected = "Oppenheimer";
        String actual = movieObj.TopMovie(movies, totalSales);

        assertEquals(expected, actual);
    }
}