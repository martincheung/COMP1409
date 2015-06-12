
/**
 * Write a description of class Stream here.
 * 
 * @author Martin Cheung
 * @version 20150612
 */
public class Stream
{
    private static final String DEFAULT_NAME = "Unnamed";
    
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
        
    }
    
    /**
     * Non-default constructor for objects of class Stream
     */
    

}
