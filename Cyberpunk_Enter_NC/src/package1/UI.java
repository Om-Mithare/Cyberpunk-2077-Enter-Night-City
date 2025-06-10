package package1;


import java.awt.*;
import javax.swing.*;
import package1.Game.ChoiceHandler;

public class UI {
    JFrame window;
    JPanel titlePanel, titleNamePanel, titleDescPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, titleNameDesc, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, meleeWeaponLabel, meleeWeaponName, eddiesLabel, eddiesNumber;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Play", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font normalBoldFont = new Font("Times New Roman", Font.BOLD, 26);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font smallBoldFont = new Font("Times New Roman", Font.BOLD, 22);
    // Image image = new Image("\"C:\\Users\\omman\\Downloads\\drop-your-best-cyberpunk-2077-wallpapers-zedge-is-filled-v0-en1n92zwynsc1.webp\"");

    public void createUI(ChoiceHandler cHandler)
    {
        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);

        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 92);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("CYBERPUNK\n");
        titleNameLabel.setForeground(Color.white); 
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        titleDescPanel = new JPanel();
        titleDescPanel.setBounds(100, 195, 600, 60);
        titleDescPanel.setBackground(Color.black);
        titleNameDesc = new JLabel("Enter Night City");
        titleNameDesc.setForeground(Color.white);
        titleNameDesc.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        titleDescPanel.add(titleNameDesc);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 150);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(180, 350, 400, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,2));

        choice1 = new JButton("Choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(2,6));

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(smallBoldFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(smallFont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);
        weaponLabel = new JLabel("Gun:");
        weaponLabel.setFont(smallBoldFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(smallFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);    
        meleeWeaponLabel = new JLabel("Melee:");
        meleeWeaponLabel.setFont(smallBoldFont);
        meleeWeaponLabel.setForeground(Color.white);
        playerPanel.add(meleeWeaponLabel);
        meleeWeaponName = new JLabel();
        meleeWeaponName.setFont(smallFont);
        meleeWeaponName.setForeground(Color.white);
        playerPanel.add(meleeWeaponName);

        eddiesLabel = new JLabel("Eddies: ");
        eddiesLabel.setFont(smallBoldFont);
        eddiesLabel.setForeground(Color.white);
        playerPanel.add(eddiesLabel);
        eddiesNumber = new JLabel();
        eddiesNumber.setFont(smallFont);
        eddiesNumber.setForeground(Color.white);
        playerPanel.add(eddiesNumber);

        window.add(startButtonPanel);
        window.add(playerPanel);
        window.add(choiceButtonPanel);
        window.add(mainTextPanel);
        window.add(titleNamePanel);
        window.add(titleDescPanel);
        // window.setVisible(true);

    }
}
