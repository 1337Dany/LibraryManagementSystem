package ui.admin;

import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LibrarianMode extends JPanel{

    private JTable userTable;
    private JTable bookTable;
    private JTable bookCopyTable;
    private JTable rentalHistoryTable;

    public LibrarianMode() {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Users", createUserPanel());
        tabbedPane.addTab("Books", createBookPanel());
        tabbedPane.addTab("Book Copies", createBookCopyPanel());
        tabbedPane.addTab("Rental Histories", createRentalHistoryPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        userTable = new JTable(); // Initialize with appropriate model
        panel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add User");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add user logic
            }
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        bookTable = new JTable(); // Initialize with appropriate model
        panel.add(new JScrollPane(bookTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField isbnField = new JTextField();
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);
        formPanel.add(new JLabel("Publication Year:"));
        formPanel.add(yearField);
        formPanel.add(new JLabel("ISBN:"));
        formPanel.add(isbnField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add book logic
            }
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookCopyPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        bookCopyTable = new JTable(); // Initialize with appropriate model
        panel.add(new JScrollPane(bookCopyTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        JTextField bookField = new JTextField();
        JTextField copyIdField = new JTextField();
        formPanel.add(new JLabel("Book:"));
        formPanel.add(bookField);
        formPanel.add(new JLabel("Copy ID:"));
        formPanel.add(copyIdField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book Copy");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add book copy logic
            }
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createRentalHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        rentalHistoryTable = new JTable(); // Initialize with appropriate model
        panel.add(new JScrollPane(rentalHistoryTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JTextField userField = new JTextField();
        JTextField bookCopyField = new JTextField();
        JTextField rentalDateField = new JTextField();
        JTextField returnDateField = new JTextField();
        formPanel.add(new JLabel("User:"));
        formPanel.add(userField);
        formPanel.add(new JLabel("Book Copy:"));
        formPanel.add(bookCopyField);
        formPanel.add(new JLabel("Rental Date:"));
        formPanel.add(rentalDateField);
        formPanel.add(new JLabel("Return Date:"));
        formPanel.add(returnDateField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Rental History");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add rental history logic
            }
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
}