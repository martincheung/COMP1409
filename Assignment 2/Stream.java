
/**
 * Write a description of class Stream here.
 * 
 * @author Martin Cheung
 * @version 20150612
 */
public class Stream
{
    private static final String DEFAULT_NAME = "Unnamed";
    
    private static int numberStreams = 0;
    
    private String name;
    private Pool sourcePool;
    private Pool destinationPool;
    private int idNumber;

    /**
     * Constructor for objects of class Stream
     */
    public Stream()
    {
        name = DEFAULT_NAME;
        sourcePool = new Pool();
        destinationPool = new Pool();
        numberStreams++;
        idNumber = numberStreams;
    }
    
    /**
     * Non-default constructor for objects of class Stream
     */
    public Stream(String name, Pool sourcePool, Pool destinationPool)
    {
        setName(name);
        setSourcePool(sourcePool);
        setDestinationPool(destinationPool);
        numberStreams++;
        idNumber = numberStreams;
    }
    
    /** 
     * Sets name of Stream
     * @param name as String
     */
    public final void setName(String name) {
        if (name != null && name.equals("")) {
            this.name = name;
        }
        
    }
    
    /**
     * Gets name of Stream
     * @return name as String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets source pool.
     * @param sourcePool as Pool
     */
    public final void setSourcePool(Pool sourcePool) {
        if (sourcePool != null) this.sourcePool = sourcePool;
    }
    
    /**
     * Gets source pool.
     * @return sourcePool as Pool
     */
    public Pool getSourcePool() {
        return sourcePool;
    }
    
    /**
     * Sets destination pool.
     * @param destinationPool as Pool
     */
    public final void setDestinationPool(Pool destinationPool) {
        if (destinationPool != null) this.destinationPool = destinationPool;
    }
    
    /**
     * Gets destination pool.
     * @return destinationPool as Pool
     */
    public Pool getDestinationPool() {
        return destinationPool;
    }
    
    /**
     * Get Stream ID number.
     * @return idNumber as int
     */
    public int getID() {
        return idNumber;
    }
    
    /**
     * Returns total number of Streams created.
     * @return numberStreams as int
     */
    public static int getNumberCreated() {
        return numberStreams;
    }
    
    /**
     * Returns String description of Stream.
     */
    public String toString() {
        return "\nStream Name: " + name + 
                " ID: " + idNumber +
                " Source pool: " + sourcePool.getIdentificationNumber() +
                " Destination pool: " + destinationPool.getIdentificationNumber();
                
    }
    
    /**
     * Prints Stream's details
     */
    public void printDetails() {
        System.out.println(toString());
    }
}
