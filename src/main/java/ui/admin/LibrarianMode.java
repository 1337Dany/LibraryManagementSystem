package ui.admin;

import data.entity.Book;
import data.entity.Member;
import data.entity.Publisher;
import ui.ViewContract;
import ui.tablemodels.*;

import javax.swing.*;
import java.awt.*;

public class LibrarianMode extends JPanel {
    private final ViewContract viewContract;
    private JTable userTable;
    private JTable bookTable;
    private JTable bookCopyTable;
    private JTable rentalHistoryTable;
    private JTable bookDataTable;
    private JTable librarianTable;
    private JTable publisherTable;

    private JTabbedPane tabbedPane = new JTabbedPane();

    public LibrarianMode(ViewContract viewContract) {
        this.viewContract = viewContract;
        configure();
    }

    private void configure() {
        setLayout(new BorderLayout());
        tabbedPane.addTab("Users", createUserPanel());
        tabbedPane.addTab("Books", createBookPanel());
        tabbedPane.addTab("Book Copies", createBookCopyPanel());
        tabbedPane.addTab("Rental Histories", createRentalHistoryPanel());
        tabbedPane.addTab("Librarians", createLibrarianPanel());
        tabbedPane.addTab("Publishers", createPublisherPanel());

        add(tabbedPane, BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(e -> viewContract.logout());
        add(back, BorderLayout.SOUTH);

    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        userTable = new JTable(new MemberTableModel(viewContract.downloadMemberData()));
        panel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField addressField = new JTextField();
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add User");
        addButton.addActionListener(e -> {
            // Add user logic
            Member member = new Member();
            member.setId(Integer.parseInt(idField.getText()));
            member.setName(nameField.getText());
            member.setEmail(emailField.getText());
            member.setPhoneNumber(phoneField.getText());
            member.setAddress(addressField.getText());

            viewContract.createMember(member);
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        bookDataTable = new JTable(new BookTableModel(viewContract.downloadBookData()));
        panel.add(new JScrollPane(bookDataTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField publisherField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField isbnField = new JTextField();
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);
        formPanel.add(new JLabel("Publisher:"));
        formPanel.add(publisherField);
        formPanel.add(new JLabel("Publication Year:"));
        formPanel.add(yearField);
        formPanel.add(new JLabel("ISBN:"));
        formPanel.add(isbnField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            // Add book logic
            Book book = new Book();
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            Publisher newPublisher = new Publisher();
            newPublisher.setName(publisherField.getText());
            book.setPublisher(newPublisher);
            book.setPublicationYear(Integer.parseInt(yearField.getText()));
            book.setIsbn(isbnField.getText());

            viewContract.createBook(book);
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createBookCopyPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        bookCopyTable = new JTable(new CopyTableModel(viewContract.downloadCopyData()));
        panel.add(new JScrollPane(bookCopyTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JTextField bookField = new JTextField();
        JTextField copyIdField = new JTextField();
        JTextField statusField = new JTextField();
        formPanel.add(new JLabel("Book:"));
        formPanel.add(bookField);
        formPanel.add(new JLabel("Copy number:"));
        formPanel.add(copyIdField);
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book Copy");
        addButton.addActionListener(e -> {
            // Add book copy logic
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createRentalHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        rentalHistoryTable = new JTable(new RentalHistoryTableModel(viewContract.downloadBorrowingData()));
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
        formPanel.add(new JLabel("Borrow Date:"));
        formPanel.add(rentalDateField);
        formPanel.add(new JLabel("Return Date:"));
        formPanel.add(returnDateField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Rental History");
        addButton.addActionListener(e -> {
            // Add rental history logic
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createLibrarianPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        librarianTable = new JTable(new LibrarianTableModel(viewContract.getLibrarians()));
        panel.add(new JScrollPane(librarianTable), BorderLayout.CENTER);

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
        JButton addButton = new JButton("Add Librarian");
        addButton.addActionListener(e -> {
            // Add librarian logic
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createPublisherPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        publisherTable = new JTable(new PublisherTableModel(viewContract.getPublishers()));
        panel.add(new JScrollPane(publisherTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JTextField nameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField phoneField = new JTextField();
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Publisher");
        addButton.addActionListener(e -> {
            // Add publisher logic
        });
        buttonPanel.add(addButton);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


}