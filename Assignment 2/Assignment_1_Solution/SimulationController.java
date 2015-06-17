
/**
 * Write a description of class SimulationController here.
 * 
 * @author Martin Cheung
 * @version 20150616
 */
public class SimulationController
{
    private Ecosystem simulation;
    private int week;
    
    /**
     * Default Constructor for objects of class SimulationController
     */
    public SimulationController()
    {
        simulation = new Ecosystem();
        week = 1;
    }
    
    /**
     * Non-default constructor for objects of SimulationController class
     */
    public SimulationController(Ecosystem simulation) {
        if (simulation == null) {
            this.simulation = new Ecosystem();
        }
        else this.simulation = simulation;
        week = 1;
    }
    
    /**
     * Invokes reset method on Ecosystem.
     */
    public void reset() {
        simulation.reset();
    }
    
    /**
     * Increments ages of every Guppy in the Ecosystem's Pools and returns number that
     * have died of old age
     * @return numberOfDeathsFromOldAge as int
     */
    public int incrementAges() {
        int numberOfDeathsFromOldAge = 0;
        for (Pool pool : simulation.getPools()) {
            for (Guppy guppy : pool.getGuppies()) {
                guppy.incrementAge();
                if (!guppy.isAlive()) numberOfDeathsFromOldAge++;
            }
        }
        return numberOfDeathsFromOldAge;
    }
    
    /**
     * Determines which Guppies have died of malnutrition, returns deaths caused by
     * malnutrition
     * @returns numberOfDeathsFromMalnutrition as int
     */
    public int applyNutrientCoefficients() {
        int numberOfDeathsFromMalnutrition = 0;
        for (Pool pool : simulation.getPools()) {
            numberOfDeathsFromMalnutrition += pool.applyNutrientCoefficient();
        }
        return numberOfDeathsFromMalnutrition;
    }
    
    /**
     * Removes dead Guppies from the Pools in the Ecosystem
     * @return numberRemoved as int
     */
    public int removeDeadGuppies() {
        int numberRemoved = 0;
        for (Pool pool : simulation.getPools()) {
            numberRemoved += pool.removeDeadGuppies();
        }
        return numberRemoved;
    }
    
    /**
     * Invokes simulateOneWeek() the specified number of times
     * @param numberOfWeeks as int
     */
    public void simulate(int numberOfWeeks) {
        if (numberOfWeeks <= 0) {
            int i = 1;
            while (i <= numberOfWeeks) {
                simulateOneWeek();
                i++;
            }
        }
    }
    
    /**
     * Runs the simulation for one week.
     */
    public void simulateOneWeek() {
        week++;
        int numberOfDeathsFromOldAge = incrementAges();
        int numberOfDeathsFromMalnutrition = applyNutrientCoefficients();
        int numberRemoved = removeDeadGuppies();
        int totalDiedThisWeek = numberOfDeathsFromOldAge + numberOfDeathsFromMalnutrition
                                + numberRemoved;
        displayReport(totalDiedThisWeek);
    }
    
    /**
     * Prints the week number, the number of Guppies that have died this week, and
     * then invokes the toString() method on the Ecosystem.
     */
    public void displayReport(int numberRemoved) {
        System.out.println("Week number " + week +
                            "\n Number of guppies died this week: " + numberRemoved +
                            "\n" + simulation.toString());        
    }
}










