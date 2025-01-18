package ui.client;

import ui.ViewContract;
import ui.tablemodels.*;

import javax.swing.*;
import java.awt.*;

public class ClientMode extends JPanel {
    private final ViewContract viewContract;

    public ClientMode(ViewContract viewContract) {
        this.viewContract = viewContract;
        configure();
    }

    private void configure() {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Users", createUserPanel());
        tabbedPane.addTab("Books", createBookPanel());
        tabbedPane.addTab("Book Copies", createBookCopyPanel());
        tabbedPane.addTab("Rental Histories", createRentalHistoryPanel());
        tabbedPane.addTab("Librarians", createLibrarianPanel());
        tabbedPane.addTab("Publishers", createPublisherPanel());

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(e -> viewContract.logout());
        add(back, BorderLayout.SOUTH);
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable userTable = new JTable(new MemberTableModel(viewContract.downloadMemberData()));
        userTable.setEnabled(false);
        panel.add(new JScrollPane(userTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBookPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable bookDataTable = new JTable(new BookTableModel(viewContract.downloadBookData()));
        bookDataTable.setEnabled(false);
        panel.add(new JScrollPane(bookDataTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBookCopyPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable bookCopyTable = new JTable(new CopyTableModel(viewContract.downloadCopyData()));
        bookCopyTable.setEnabled(false);
        panel.add(new JScrollPane(bookCopyTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createRentalHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable rentalHistoryTable = new JTable(new RentalHistoryTableModel(viewContract.downloadBorrowingData()));
        rentalHistoryTable.setEnabled(false);
        panel.add(new JScrollPane(rentalHistoryTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createLibrarianPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable librarianTable = new JTable(new LibrarianTableModel(viewContract.getLibrarians()));
        librarianTable.setEnabled(false);
        panel.add(new JScrollPane(librarianTable), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createPublisherPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable publisherTable = new JTable(new PublisherTableModel(viewContract.getPublishers()));
        publisherTable.setEnabled(false);
        panel.add(new JScrollPane(publisherTable), BorderLayout.CENTER);
        return panel;
    }
}