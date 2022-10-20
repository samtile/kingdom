import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Represents an instance of the game
 *
 * @author Sammo
 */
public class Game {
    /**
     * Sets up a game and contains all kingdom info
     */
    private String playerName;
    private String kingdomName; // Name of the kingdom e.g. Cyprus
    private String adjective; // Adjective of the kingdom e.g. Cyprian
    // kingdom variables
    private int year, area, population, food;
    // resultant turn variables
    private int overcrowdedDead, overcrowdedPop, foodCreated, agricultureUsed, foodConsumed, populationStarved, peopleStarved, order;
    // below is the parameter data that will affect how the game runs	private final int livingPerKmSq = 500;
    private final int foodPerPerson = 20;
    private final int populationPerKmSquare = 20;
    private final double minYieldPerAcre = 1;
    private final double maxYieldPerAcre = 55;
    private double yieldPerAcre;
    private final int personCanFarm = 10;

    public Game() {
    }

    public void startNewGame() {
        // get info from player
        playerName = JOptionPane.showInputDialog(null,
                "What is your name?",
                "Enter your name",
                JOptionPane.QUESTION_MESSAGE);
        // get info from player
        kingdomName = JOptionPane.showInputDialog(null,
                "Over which kingdom will you rule?",
                "Enter your kingdom",
                JOptionPane.QUESTION_MESSAGE);
        // get info from player
        adjective = JOptionPane.showInputDialog(null,
                "What is the adjective for something from the kingdom of " + kingdomName + "?",
                "Enter your kingdom's adjective",
                JOptionPane.QUESTION_MESSAGE);
        // set the starting values
        year = 1;
        area = 1000;
        food = 3000;
        population = 100;
    }

    /**
     * Runs when the user clicks the button to move on a year. Performs all actions for the turn
     */
    public void nextTurn() {
        getUserInput();
        createFood(); // produce and buy food
        feedPopulation(); // feeds and checks for hunger
        //agePopulation();
        //checkOvercrowding();
        //testRevolution();
        resetPlayerTurnVariables();
        year++;
    }

    /**
     * User enters their choices
     */
    public void getUserInput() {

        JOptionPane.showInputDialog("How much food will you give to the people?");

    }

    /**
     * Works out how much food is produced
     */
    public void createFood() {
        yieldPerAcre = getRandomDouble(minYieldPerAcre, maxYieldPerAcre);
        if (area > population * personCanFarm)
            foodCreated = (int) (population * yieldPerAcre);
        else
            foodCreated = (int) (area * yieldPerAcre);

        food = food + foodCreated;
        return;
    }

    /**
     * Feeds population with the food in storage
     */
    public void feedPopulation() {
        if ((foodPerPerson * population) <= food) { // there is enough food
            populationStarved = 0;
            foodConsumed = foodPerPerson * population;
            food = food - foodConsumed;
        } else { // there is a shortage
            populationStarved = population - (food / foodPerPerson);
            foodConsumed = food;
            food = 0;
            // death of starvation
            population = population - populationStarved;
        }
    }

    /*
     * birth and death of old age
     */
    public void agePopulation() {

    }

    public void checkOvercrowding() {
        overcrowdedPop = population - (area * populationPerKmSquare);
        // half of overcrowded people die
        overcrowdedDead = overcrowdedPop / 2;
    }

    public void testRevolution() {
        if (order < 0) { // revolution! Kill between

        }
    }

    public void resetPlayerTurnVariables() {

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public void setKingdomName(String kingdomName) {
        this.kingdomName = kingdomName;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public int getYear() {
        return year;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    private double getRandomDouble(double aStart, double aEnd) {
        Random r = new Random();
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        double range = (double) aEnd - (double) aStart + 1;
        // compute a fraction of the range, 0 <= fraction < range
        double fraction = range * r.nextDouble();
        double randomNumber = fraction + aStart;
        return randomNumber;
    }
}