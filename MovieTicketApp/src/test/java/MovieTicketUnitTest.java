package com.mycompany.movieticketapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class tests the MovieTickets class.
 * It must be placed in the Test Packages folder of the project,
 * not in the normal Source Packages folder.
 *
 * If your NetBeans project uses JUnit 4 instead of JUnit 5,
 * change the imports to:
 * import org.j unit.Before;
 * import org.j unit.Test;
 * import static org.j unit.Assert.assertEquals;
 * import static org.j unit.Assert.assertFalse;
 * and change @BeforeEach to @Before
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTicketUnitTest {

    // The object being tested
    private MovieTickets movieTickets;

    // This runs before every test, so each test starts with a fresh object
    @BeforeEach
    public void setUp() {
        movieTickets = new MovieTickets();
    }

    // Tests that CalculateTotalTicketPrice returns the correct total.
    // 3 tickets x R100 = R300, plus 14% VAT (R42) = R342
    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        assertEquals(342.0, movieTickets.CalculateTotalTicketPrice(3, 100.0), 0.001);
    }

    // Tests that ValidateData returns false when the ticket price is
    // 0 or less, which is one of the three validation rules
    @Test
    public void ValidateData_ReturnsFalseForInvalidTicketPrice() {
        MovieTicketData invalidData = new MovieTicketData("Napoleon", 0, 3);

        assertFalse(movieTickets.ValidateData(invalidData));
    }
}