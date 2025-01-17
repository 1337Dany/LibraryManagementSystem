package ui.client;

import javax.swing.*;
import java.awt.*;

public class ClientMode extends JPanel {

    public ClientMode() {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Search Books", createSearchBooksPanel());
        tabbedPane.addTab("My Rentals", createMyRentalsPanel());
        // Add more tabs as needed

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createSearchBooksPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Add components for searching books
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JTable searchResultsTable = new JTable(); // Initialize with appropriate model

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(searchResultsTable), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createMyRentalsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Add components for displaying user's rentals
        JTable rentalsTable = new JTable(); // Initialize with appropriate model
        panel.add(new JScrollPane(rentalsTable), BorderLayout.CENTER);

        return panel;
    }
}