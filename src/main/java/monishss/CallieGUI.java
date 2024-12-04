package monishss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CallieGUI {

    private JFrame callieFrame;
    private JPanel calliePanel;
    private JButton callieResetButton;
    private JButton callieConnectButton;
    private JButton callieDisconnectButton;
    private JLabel callieLabel;
    private JPanel keyboardRowPanel1;
    private JPanel keyboardRowPanel2;
    private JPanel keyboardRowPanel3;
    private JLabel statusLabel;
    private JPanel callieHeaderbuttonPanel;
    private JPanel callieHeaderPanel;
    private JPanel callieHeaderStatusPanel;
    private JPanel callieHeaderStatusPanelRow1;
    private JPanel callieHeaderStatusPanelRow2;
    private JLabel statusIndicator;
    private JLabel commandIndicator;

    public CallieGUI() {
        // Initialize JFrame
        callieFrame = new JFrame("Callie");
        callieFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        callieFrame.setResizable(false);
        callieFrame.setSize(700, 400);
        callieFrame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        // Initialize JPanel and set background color
        keyboardRowPanel1= new JPanel();
        keyboardRowPanel2= new JPanel();
        keyboardRowPanel3= new JPanel();



        calliePanel = new JPanel();
        calliePanel.setPreferredSize(new Dimension(700, 700));
        calliePanel.setBackground(Color.BLACK); // Set panel background to black
        calliePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); // Set layout for proper arrangement

        // Initialize JLabel
        callieLabel = new JLabel("Callie");

        try {
            // Load and apply custom font
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Billabong.otf")).deriveFont(70f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            // Apply font to label
            callieLabel.setFont(font);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set font color of JLabel to white
        callieLabel.setForeground(Color.WHITE);

        callieHeaderPanel = new JPanel();
        callieHeaderPanel.setLayout(new GridLayout(1,3));
        callieHeaderPanel.setBackground(Color.BLACK);

        // Add JLabel to JPanel
        callieHeaderPanel.add(callieLabel);

        // Initialize JButtons
        callieResetButton = new JButton("Reset");
        callieConnectButton = new JButton("Connect");
        callieDisconnectButton = new JButton("Disconnect");

        // Customize JButton to match the theme
        callieResetButton.setBackground(Color.BLACK); // Set button background to black
        callieResetButton.setForeground(Color.BLACK); // Set button font color to white
        callieResetButton.setFocusPainted(false); // Remove button focus outline

        callieConnectButton.setBackground(Color.BLACK); // Set button background to black
        callieConnectButton.setForeground(Color.BLACK); // Set button font color to white
        callieConnectButton.setFocusPainted(false);
        //callieResetButton.setBorderPainted(false); // Remove button border for flat design

        // Add JButtons to JPanel


        callieHeaderbuttonPanel = new JPanel();
        callieHeaderbuttonPanel.setLayout(new GridLayout(3,1));
        callieHeaderbuttonPanel.setBackground(Color.BLACK);

        callieHeaderbuttonPanel.add(callieResetButton);
        callieHeaderbuttonPanel.add(callieConnectButton);
        callieHeaderbuttonPanel.add(callieDisconnectButton);

        callieHeaderPanel.add(callieHeaderbuttonPanel);

        statusLabel = new JLabel("Disconnected from URSim");
        statusLabel.setForeground(Color.RED);

        callieHeaderStatusPanel = new JPanel();
        callieHeaderStatusPanel.setLayout(new GridLayout(3,1));

        callieHeaderStatusPanelRow1 = new JPanel();
        callieHeaderStatusPanelRow1.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
        callieHeaderStatusPanelRow1.setBackground(Color.BLACK);
        statusIndicator = new JLabel("Status: ");
        statusIndicator.setForeground(Color.WHITE);
        callieHeaderStatusPanelRow1.add(statusIndicator);

        callieHeaderStatusPanelRow2 = new JPanel();
        callieHeaderStatusPanelRow2.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
        callieHeaderStatusPanelRow2.setBackground(Color.BLACK);
        commandIndicator = new JLabel("Command: ");
        commandIndicator.setForeground(Color.WHITE);
        callieHeaderStatusPanelRow2.add(commandIndicator);

        callieHeaderStatusPanelRow1.add(statusLabel);

        callieHeaderStatusPanel.add(callieHeaderStatusPanelRow1);
        callieHeaderStatusPanel.add(callieHeaderStatusPanelRow2);


        callieHeaderStatusPanel.setBackground(Color.BLACK);
        //callieHeaderStatusPanel.add(new JLabel("Command: "));
        //callieHeaderPanel.add(callieHeaderStatusPanel);

        calliePanel.add(callieHeaderPanel);
        calliePanel.add(callieHeaderStatusPanel);



        //callieLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // Add JPanel to JFrame
        callieFrame.add(calliePanel);

        keyboardRowPanel1.setBackground(Color.BLACK);
        keyboardRowPanel2.setBackground(Color.BLACK);
        keyboardRowPanel3.setBackground(Color.BLACK);



        populateKeyboard();
        calliePanel.add(keyboardRowPanel1);
        calliePanel.add(keyboardRowPanel2);
        calliePanel.add(keyboardRowPanel3);

        // Set JFrame visibility after adding components
        callieFrame.setVisible(true);
    }

    public void populateKeyboard() {
        String line_1[] = new String("QWERTYUIOP").split("");
        String line_2[] = new String("ASDFGHJKL").split("");
        String line_3[] = new String("ZXCVBNM").split("");


        for (String c : line_1) {
            JButton jButton = new JButton(c);
            jButton.setPreferredSize(new Dimension(50, 50));
            keyboardRowPanel1.add(jButton);

        }
        for (String c : line_2) {
            JButton jButton = new JButton(c);
            jButton.setPreferredSize(new Dimension(50, 50));
            keyboardRowPanel2.add(jButton);

        }
        for (String c : line_3) {
            JButton jButton = new JButton(c);
            jButton.setPreferredSize(new Dimension(50, 50));
            keyboardRowPanel3.add(jButton);

        }

        callieConnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CallieController().connect(ServerConfig.URSIM_SERVER.getHost(), ServerConfig.URSIM_SERVER.getPort());
                    statusLabel.setForeground(Color.GREEN);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }


}