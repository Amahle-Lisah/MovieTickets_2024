package com.mycompany.movieticketapp;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is the window (JFrame) for the movie tickets application.
 * It only displays information and reads what the user typed -
 * all of the calculating and validating is done by the
 * MovieTickets class.
 *
 * @author Amahle Lisah Khumalo
 */
public class MovieTicketForm extends JFrame {

    // The GUI components used on the form
    private JComboBox<String> cmbMovie;
    private JTextField txtNumberOfTickets;
    private JTextField txtTicketPrice;
    private JTextArea txtAreaReport;

    // This object does the calculating and validating for the form
    private final MovieTickets movieTickets;

    // The constructor builds the whole window
    public MovieTicketForm() {
        movieTickets = new MovieTickets();

        buildMenuBar();
        buildComponents();

        setTitle("MOVIE TICKETS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 420);
        setLocationRelativeTo(null); // opens in the middle of the screen
    }

    // Creates the File menu (Exit) and the Tools menu (Process, Clear)
    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // ---------- File menu ----------
        JMenu menuFile = new JMenu("File");

        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(evt -> System.exit(0));

        menuFile.add(menuItemExit);

        // ---------- Tools menu ----------
        JMenu menuTools = new JMenu("Tools");

        JMenuItem menuItemProcess = new JMenuItem("Process");
        menuItemProcess.addActionListener(evt -> processMovieTicket());

        JMenuItem menuItemClear = new JMenuItem("Clear");
        menuItemClear.addActionListener(evt -> clearForm());

        menuTools.add(menuItemProcess);
        menuTools.add(menuItemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);

        setJMenuBar(menuBar);
    }

    // Creates the combo box, the two text fields and the report text area
    private void buildComponents() {
        // The combo box is populated with the three required movies
        cmbMovie = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});

        txtNumberOfTickets = new JTextField(10);
        txtTicketPrice = new JTextField(10);

        // The text area only displays the report - the user cannot type in it
        txtAreaReport = new JTextArea(8, 25);
        txtAreaReport.setEditable(false);

        // A panel that stacks the components one under the other
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMovie = new JLabel("Movie:");
        JLabel lblTickets = new JLabel("Number of Tickets:");
        JLabel lblPrice = new JLabel("Ticket Price:");
        JLabel lblReport = new JLabel("Ticket Report:");

        lblMovie.setAlignmentX(Component.LEFT_ALIGNMENT);
        cmbMovie.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblTickets.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtNumberOfTickets.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblPrice.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtTicketPrice.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblReport.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lblMovie);
        panel.add(cmbMovie);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblTickets);
        panel.add(txtNumberOfTickets);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblPrice);
        panel.add(txtTicketPrice);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblReport);
        panel.add(new JScrollPane(txtAreaReport));

        add(panel);
    }

    // Called when the Process menu item is clicked.
    // It reads the form, validates it, calculates the total,
    // displays the report and saves it to report.txt.
    private void processMovieTicket() {
        String movieName = (String) cmbMovie.getSelectedItem();

        // The number of tickets and the ticket price must be numbers.
        // If the user typed letters instead, show a message and stop.
        int numberOfTickets;
        double ticketPrice;

        try {
            numberOfTickets = Integer.parseInt(txtNumberOfTickets.getText().trim());
            ticketPrice = Double.parseDouble(txtTicketPrice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number of tickets and ticket price.");
            return;
        }

        // Put the captured data into one object, so it can be validated
        MovieTicketData movieTicketData = new MovieTicketData(movieName, ticketPrice, numberOfTickets);

        // Only valid data may be processed
        if (!movieTickets.ValidateData(movieTicketData)) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid movie name, ticket price and number of tickets.");
            return;
        }

        // Calculate the total ticket price, including VAT
        double totalTicketPrice = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Build the report text in the same format as the sample
        StringBuilder report = new StringBuilder();
        report.append("MOVIE TICKET REPORT\n");
        report.append("***********************************\n");
        report.append("MOVIE NAME: ").append(movieName).append("\n");
        report.append("MOVIE TICKET PRICE: R ").append(ticketPrice).append("\n");
        report.append("NUMBER OF TICKETS: ").append(numberOfTickets).append("\n");
        report.append("TOTAL TICKET PRICE: R ").append(totalTicketPrice).append("\n");
        report.append("***********************************\n");

        txtAreaReport.setText(report.toString());

        // Save the same report to report.txt, straight after it is shown
        saveReportToFile(report.toString());
    }

    // Writes the report text to a file named report.txt
    private void saveReportToFile(String reportText) {
        // try-with-resources closes the file automatically when done
        try (PrintWriter out = new PrintWriter(new FileWriter("report.txt"))) {
            out.print(reportText);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save report.txt: " + ex.getMessage());
        }
    }

    // Called when the Clear menu item is clicked.
    // It resets the form back to its default state.
    private void clearForm() {
        cmbMovie.setSelectedIndex(0);
        txtNumberOfTickets.setText("");
        txtTicketPrice.setText("");
        txtAreaReport.setText("");
    }

    // Starts the application
    public static void main(String[] args) {
        // This makes sure the window is built on the correct thread
        java.awt.EventQueue.invokeLater(() -> {
            new MovieTicketForm().setVisible(true);
        });
    }
}