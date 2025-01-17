package ui;

import domain.Presenter;
import domain.SettingsSetter;
import ui.admin.LibrarianMode;
import ui.client.ClientMode;
import ui.menu.MenuPanel;
import ui.menu.MenuPanelCallback;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements MenuPanelCallback {
    private static final Dimension frameSize = new Dimension(1000, 600);
    private final SettingsSetter settingsSetter = new SettingsSetter(this);

    private final Presenter presenter = new Presenter();

    private final MenuPanel menuPanel = new MenuPanel(frameSize, this);

    public void openMainJFrame() {
        configure();

        SettingsSetter.setParametersToObjects(this);
    }

    public void configure(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameSize);
        this.setLayout(null);
        this.setLocationRelativeTo(null);   // center the window
        this.setTitle("Library Management System");

        add(menuPanel);
    }

    @Override
    public void openAdminMode() {
        remove(menuPanel);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Librarian Mode", new LibrarianMode());
        tabbedPane.addTab("Client Mode", new ClientMode());
        // Add more tabs as needed

        add(tabbedPane, BorderLayout.CENTER);
        SettingsSetter.setParametersToObjects(this);

        repaint();
        revalidate();
    }
}
