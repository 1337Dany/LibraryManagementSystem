package ui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
    private final MenuPanelCallback callback;

    private final JButton adminModeButton = new JButton("admin mode");
    private final JButton clientModeButton = new JButton("client mode");

    public MenuPanel(Dimension frameSize, MenuPanelCallback callback) {
        this.callback = callback;

        configure(frameSize);
    }

    public void configure(Dimension frameSize){
        setBackground(Color.DARK_GRAY);
        setLayout(new GridBagLayout());
        setSize(frameSize);
        setLocation(0, 0);

        Dimension buttonSize = new Dimension(200, 50); // Set the preferred size for the buttons

        adminModeButton.setPreferredSize(buttonSize);
        adminModeButton.setMaximumSize(buttonSize);
        clientModeButton.setPreferredSize(buttonSize);
        clientModeButton.setMaximumSize(buttonSize);

        adminModeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                callback.openAdminMode();
            }
        });

        clientModeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                callback.openClientMode();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        add(adminModeButton, gbc);
        add(clientModeButton, gbc);
    }
}