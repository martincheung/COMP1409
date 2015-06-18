import java.util.ArrayList;
import java.util.Random;

/**
 * Tests Assignment 2
 * You can run your program using this class.  Right-click the Tester
 * class in the BlueJ window and choose the main
 * 
 * @author  COMP 1409
 * @version June 2015
 */
public class Tester
{
    public static final int POOLS = 3;
    public static final int GUPPIES = 2000;
    public static final int MAXIUMUM_AGE = 50;
    public static final int WEEKS = 50; // <-- Change this to see what happens
    
    /**
     * Constructor for objects of class Tester
     */
    public Tester() {
    }

    /**
     * Conducts the program
     */
    public static void main(String[] args)
    {
        Random random = new Random();
        Ecosystem simulation = new Ecosystem();
        
        int numberOfPoolsMade = 0;
        int numberOfGuppiesMade = 0;
        
        while (numberOfPoolsMade < POOLS) {
            
            Pool newPool = new Pool("Pool " + (numberOfPoolsMade + 1), 1000, 40, 8, 0.99);
            numberOfGuppiesMade = 0;
            
            while (numberOfGuppiesMade < GUPPIES) {
                
                Guppy guppy = new Guppy();
                guppy.setAge(random.nextInt(MAXIUMUM_AGE));
                newPool.addGuppy(guppy);
                ++numberOfGuppiesMade;
            }
            
            simulation.addPool(newPool);
            ++numberOfPoolsMade;
        }
        
        SimulationController simulationController = new SimulationController(simulation);
        simulationController.simulate(WEEKS);
    }
}







