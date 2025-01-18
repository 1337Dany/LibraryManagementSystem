package ui;

import data.entity.*;
import domain.Presenter;
import domain.PresenterContract;
import domain.SettingsSetter;
import ui.admin.LibrarianMode;
import ui.client.ClientMode;
import ui.menu.MenuPanel;
import ui.menu.MenuPanelCallback;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JFrame implements MenuPanelCallback, ViewContract {
    private static final Dimension frameSize = new Dimension(1000, 600);

    private final PresenterContract presenter = new Presenter();

    private final MenuPanel menuPanel = new MenuPanel(frameSize, this);
    private JPanel modePanel;

    {
        new SettingsSetter(this);
    }

    public void openMainJFrame() {
        configure();

        SettingsSetter.setParametersToObjects(this);
    }

    public void configure() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameSize);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);   // center the window
        this.setTitle("Library Management System");

        add(menuPanel, BorderLayout.CENTER);
    }

    @Override
    public void openAdminMode() {
        remove(menuPanel);
        add(modePanel = new LibrarianMode(this), BorderLayout.CENTER);
        SettingsSetter.setParametersToObjects(this);

        repaint();
    }

    @Override
    public void openClientMode() {
        remove(menuPanel);
        add(modePanel = new ClientMode(this), BorderLayout.CENTER);
        SettingsSetter.setParametersToObjects(this);

        repaint();
    }

    @Override
    public void logout() {
        remove(modePanel);
        add(menuPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    @Override
    public List<Book> downloadBookData() {
        return presenter.getBooks();
    }

    @Override
    public void createBook(Book book) {
        presenter.createBook(book);
    }

    @Override
    public List<Member> downloadMemberData() {
        return presenter.getMembers();
    }

    @Override
    public void createMember(Member member) {
        presenter.createMember(member);
    }

    @Override
    public List<Copy> downloadCopyData() {
        return presenter.getCopies();
    }

    @Override
    public List<Borrowing> downloadBorrowingData() {
        return presenter.getBorrowings();
    }

    @Override
    public List<Librarian> getLibrarians() {
        return presenter.getLibrarians();
    }

    @Override
    public List<Publisher> getPublishers() {
        return presenter.getPublishers();
    }
}
