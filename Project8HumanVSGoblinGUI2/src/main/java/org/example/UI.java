package org.example;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame gameWindow;
    JPanel namePanel, startButton, mainTextPanel, choicePanel, playerPanel;
    JLabel nameLabel, healthLabel, healthNumberLabel, weaponLabel, weaponNameLabel;
    JButton startButton1, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font fontForTitle = new Font("Times New Roman", Font.PLAIN, 26);
    Font fontForNormal = new Font("Times New Roman", Font.PLAIN, 20);
    public void createTheUI(Game.ChoiceHandler choiceHandler) {
        //Create The Game Window:

        gameWindow = new JFrame();
        gameWindow.setSize(800, 600);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.BLUE);
        gameWindow.setLayout(null);


        // Create the title Screen:

        namePanel = new JPanel();
        namePanel.setBounds(100, 100, 600, 500);
        namePanel.setBackground(Color.BLUE);
        nameLabel = new JLabel("Human V. Goblin Adventure Game!");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(fontForTitle);
        namePanel.add(nameLabel);
        // Create the start Button:
        startButton = new JPanel();
        startButton.setBounds(300, 400, 200, 100);
        startButton.setBackground(Color.BLUE);
        startButton1 = new JButton("Start Game!");
        startButton1.setBackground(Color.BLUE);
        startButton1.setForeground(Color.BLACK);
        startButton1.setFont(fontForNormal);
        startButton1.setFocusPainted(false);
        startButton1.addActionListener(choiceHandler);
        startButton1.setActionCommand("start");
        startButton.add(startButton1);

        gameWindow.add(namePanel);
        gameWindow.add(startButton);


        //Create the game screen:
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLUE);
        gameWindow.add(mainTextPanel);
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLUE);
        mainTextArea.setForeground(Color.BLACK);
        mainTextArea.setFont(fontForNormal);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choicePanel = new JPanel();
        choicePanel.setBounds(250, 350, 300, 150);
        choicePanel.setBackground(Color.BLUE);
        choicePanel.setLayout(new GridLayout(4, 1));
        gameWindow.add(choicePanel);

        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.BLUE);
        choice1.setForeground(Color.BLACK);
        choice1.setFont(fontForNormal);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("C1");
        choicePanel.add(choice1);
        choice2 = new JButton("choice 2");
        choice2.setBackground(Color.BLUE);
        choice2.setForeground(Color.BLACK);
        choice2.setFont(fontForNormal);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("C2");
        choicePanel.add(choice2);
        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.BLUE);
        choice3.setForeground(Color.BLACK);
        choice3.setFont(fontForNormal);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("C3");
        choicePanel.add(choice3);
        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.BLUE);
        choice4.setForeground(Color.BLACK);
        choice4.setFont(fontForNormal);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("C4");
        choicePanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.BLUE);
        playerPanel.setLayout(new GridLayout(1, 4));
        gameWindow.add(playerPanel);

        healthLabel = new JLabel("Health: ");
        healthLabel.setFont(fontForNormal);
        healthLabel.setForeground(Color.BLACK);
        playerPanel.add(healthLabel);
        healthNumberLabel = new JLabel();
        healthNumberLabel.setForeground(Color.BLACK);
        healthNumberLabel.setFont(fontForNormal);
        playerPanel.add(healthNumberLabel);
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.BLACK);
        weaponLabel.setFont(fontForNormal);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.BLACK);
        weaponNameLabel.setFont(fontForNormal);
        playerPanel.add(weaponNameLabel);




        gameWindow.setVisible(true);
    }
}
