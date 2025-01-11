package ui;

import domain.Presenter;
import domain.SettingsSetter;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements MenuPanelCallback{
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
}
