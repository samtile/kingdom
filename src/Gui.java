import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class Gui extends JFrame implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JPanel kingdomPanel, actionPanel, infoPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newGame, exitGame;
    private JTextField yearLabel, yearField, areaLabel, areaField, populationLabel, populationField, goldLabel, goldField, happinessLabel, happinessField, foodLabel, foodField, militaryLabel, militaryField, agricultureLabel, agricultureField, allocateFoodLabel, allocateFoodField;
    private JButton taxesButton, foodButton, militaryButton, nextTurnButton;

    private Game currentGame;

    private JTextArea informationField;

    /**
     * Sets up the main screen on start
     */
    public Gui() {
        setTitle("Kingdom");
        setSize(WIDTH, HEIGHT);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 0));

        Color nonEditColor = new Color(225, 225, 225);
        Color editColor = new Color(255, 255, 255);
        kingdomPanel = new JPanel();
        kingdomPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(1));

        // all menu bar stuff here
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newGame = new JMenuItem("New game");
        exitGame = new JMenuItem("Exit");
        fileMenu.add(newGame);
        fileMenu.add(exitGame);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // stuff on info panel
        informationField = new JTextArea();
        informationField.setEnabled(false);
        informationField.setAutoscrolls(true);
        informationField.setVisible(true);

        JScrollPane scrollPane = new JScrollPane(informationField);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        infoPanel.add(scrollPane, BorderLayout.CENTER);
        informationField.setBackground(new Color(255, 255, 255));

        // stuff on kingdom panel
        yearLabel = new JTextField(3);
        yearField = new JTextField(5);
        areaLabel = new JTextField(3);
        areaField = new JTextField(5);
        populationLabel = new JTextField();
        populationField = new JTextField();
        goldLabel = new JTextField();
        goldField = new JTextField();
        happinessLabel = new JTextField();
        happinessField = new JTextField();
        foodLabel = new JTextField();
        foodField = new JTextField();
        militaryLabel = new JTextField();
        militaryField = new JTextField();
        agricultureLabel = new JTextField();
        agricultureField = new JTextField();
        allocateFoodLabel = new JTextField();
        allocateFoodField = new JTextField();

        yearLabel.setText("Year");
        yearLabel.setEditable(false);
        yearLabel.setHorizontalAlignment(JTextField.RIGHT);
        yearLabel.setBorder(null);
        yearLabel.setOpaque(false);
        yearField.setEditable(false);
        yearField.setBackground(nonEditColor);
        areaLabel.setText("Area");
        areaLabel.setEditable(false);
        areaLabel.setHorizontalAlignment(JTextField.RIGHT);
        areaLabel.setBorder(null);
        areaLabel.setOpaque(false);
        areaField.setEditable(false);
        areaField.setBackground(nonEditColor);
        populationLabel.setText("Population");
        populationLabel.setEditable(false);
        populationLabel.setHorizontalAlignment(JTextField.RIGHT);
        populationLabel.setBorder(null);
        populationLabel.setOpaque(false);
        populationField.setEditable(false);
        populationField.setBackground(nonEditColor);
        militaryLabel.setText("Military");
        militaryLabel.setEditable(false);
        militaryLabel.setHorizontalAlignment(JTextField.RIGHT);
        militaryLabel.setBorder(null);
        militaryLabel.setOpaque(false);
        militaryField.setEditable(false);
        militaryField.setBackground(nonEditColor);
        agricultureLabel.setText("Agriculture");
        agricultureLabel.setEditable(false);
        agricultureLabel.setHorizontalAlignment(JTextField.RIGHT);
        agricultureLabel.setBorder(null);
        agricultureLabel.setOpaque(false);
        agricultureField.setEditable(false);
        agricultureField.setBackground(nonEditColor);
        happinessLabel.setText("Happiness");
        happinessLabel.setEditable(false);
        happinessLabel.setHorizontalAlignment(JTextField.RIGHT);
        happinessLabel.setBorder(null);
        happinessLabel.setOpaque(false);
        happinessField.setEditable(false);
        happinessField.setBackground(nonEditColor);
        goldLabel.setText("Gold");
        goldLabel.setEditable(false);
        goldLabel.setHorizontalAlignment(JTextField.RIGHT);
        goldLabel.setBorder(null);
        goldLabel.setOpaque(false);
        goldField.setEditable(false);
        goldField.setBackground(nonEditColor);
        foodLabel.setText("Food");
        foodLabel.setEditable(false);
        foodLabel.setHorizontalAlignment(JTextField.RIGHT);
        foodLabel.setBorder(null);
        foodLabel.setOpaque(false);
        foodField.setEditable(false);
        foodField.setBackground(nonEditColor);
        allocateFoodLabel.setText("Food to allocate");
        allocateFoodLabel.setEditable(false);
        allocateFoodLabel.setHorizontalAlignment(JTextField.RIGHT);
        allocateFoodLabel.setBorder(null);
        allocateFoodLabel.setOpaque(false);
        allocateFoodField.setEditable(true);
        allocateFoodField.setBackground(editColor);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 3, 14);
        c.ipadx = 30;
        c.gridx = 0;
        c.gridy = 0;
        kingdomPanel.add(yearLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(yearField, c);
        c.gridy = 1;
        c.ipadx = 30;
        c.gridx = 0;
        kingdomPanel.add(areaLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(areaField, c);
        c.gridy = 3;
        c.ipadx = 30;
        c.gridx = 0;
        kingdomPanel.add(populationLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(populationField, c);
        c.gridy = 4;
        c.gridx = 0;
        c.ipadx = 30;
        //  c.insets = new Insets(0,0,3,14);
        kingdomPanel.add(militaryLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(militaryField, c);
        c.gridy = 5;
        c.gridx = 0;
        c.ipadx = 30;
        kingdomPanel.add(agricultureLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(agricultureField, c);
        kingdomPanel.add(happinessLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(happinessField, c);
        c.gridy = 10;
        c.gridx = 0;
        c.ipadx = 30;
        kingdomPanel.add(goldLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(goldField, c);
        c.gridy = 11;
        c.gridx = 0;
        c.ipadx = 30;
        kingdomPanel.add(foodLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(foodField, c);
        c.gridy = 12;
        c.gridx = 0;
        c.ipadx = 30;
        kingdomPanel.add(allocateFoodLabel, c);
        c.gridx = 1;
        c.ipadx = 50;
        kingdomPanel.add(allocateFoodField, c);

        kingdomPanel.setBackground(new Color(240, 240, 250));

        // stuff on action panel
        taxesButton = new JButton();
        foodButton = new JButton();
        militaryButton = new JButton();
        nextTurnButton = new JButton();

        taxesButton.setText("Taxes");
        foodButton.setText("Food");
        militaryButton.setText("Militay");
        nextTurnButton.setText("Next turn");

        actionPanel.add(taxesButton);
        actionPanel.add(foodButton);
        actionPanel.add(militaryButton);
        actionPanel.add(nextTurnButton);

        actionPanel.setBackground(new Color(240, 240, 250));

        // add all 3 panels to the content pane
        pane.add(kingdomPanel, BorderLayout.WEST);
        pane.add(infoPanel, BorderLayout.CENTER);
        pane.add(actionPanel, BorderLayout.SOUTH);

        // action listeners
        newGame.addActionListener(this);
        nextTurnButton.addActionListener(this);

        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New game"))
            startNewGame();
        if (e.getActionCommand().equals("Next turn"))
            nextTurn();
    }

    /**
     * Starts a new game (after checking and ending any current game
     */
    public void startNewGame() {
        if (currentGame != null) { // TODO: dialog check to start new game
            return;
        }
        // create the game
        currentGame = new Game();
        currentGame.startNewGame();
        // update the GUI
        this.setTitle("Kingdom - " + currentGame.getPlayerName() + ", ruler of the kingdom of " +
                currentGame.getKingdomName());
        updateKingdomPanel();
        informationField.setText("Welcome");
        validate();
        repaint();
    }

    /**
     * Runs when the user clicks the button to move on a year. Performs all actions for the turn
     */
    public void nextTurn() {
        currentGame.nextTurn();
        updateKingdomPanel();
    }

    /**
     * Updates all items on the kingdom panel with the latest info
     * Used whenever stuff may have changed (very often!)
     */
    public void updateKingdomPanel() {
        NumberFormat f = NumberFormat.getInstance();
        yearField.setText(f.format(currentGame.getYear()));
        areaField.setText(f.format(currentGame.getArea()) + " acres");
        populationField.setText(f.format(currentGame.getPopulation()));
        foodField.setText(f.format(currentGame.getFood()));
    }
}