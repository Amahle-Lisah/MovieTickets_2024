package com.mycompany.movieticketapp;

/**
 *
 * @author Amahle Lisah Khumalo
 * This is the main method of the application, its starts the app
 */

public class MovieTicketApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MovieTicketForm().setVisible(true);
        });
    }
}



