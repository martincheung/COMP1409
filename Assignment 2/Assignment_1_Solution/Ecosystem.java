import java.util.*;
/**
 * Write a description of class Ecosystem here.
 * 
 * @author Martin Cheung
 * @version 20150616
 */
public class Ecosystem
{
    private ArrayList<Pool> pools;
    private ArrayList<Stream> streams;

    /**
     * Default Constructor for objects of class Ecosystem
     */
    public Ecosystem()
    {
        pools = new ArrayList<Pool>();
        streams = new ArrayList<Stream>();
    }

    /**
     * Returns array list of pools.
     * @return pools as ArrayList<Pool>
     */
    public ArrayList<Pool> getPools() {
        return pools;
    }
    
    /**
     * Sets array list pools.
     * @param pools as ArrayList<Pool>
     */
    public final void setPools(ArrayList<Pool> pools) {
        if (pools != null) this.pools = pools;
    }
    
    /**
     * Returns array list of streams.
     * @return streams as ArrayList<Stream>
     */
    public ArrayList<Stream> getStreams() {
        return streams;
    }
    
    /**
     * Sets array list of streams.
     * @param streams as ArrayList<Stream>
     */
    public final void setStreams(ArrayList<Stream> streams) {
        if (streams != null) this.streams = streams;
    }
    
    /**
     * Adds the Stream passed as a parameter to the Collection of Streams
     * @param newStream as Stream
     */
    public void addStream(Stream newStream) {
        if (newStream != null) streams.add(newStream);
    }
    
    /**
     * Adds the Pool passed as a parameter to the Collection of Pools
     * @param newPool as Pool
     */
    public void addPool(Pool newPool) {
        if (newPool != null) pools.add(newPool);
    }
    
    /**
     * Resets the Ecosystem by emptying Collection
     */
    public void reset() {
        streams.clear();
        pools.clear();
    }
    
    /**
     * Returns total number of living Guppies in the Ecosystem.
     * Note: Does not make use of Pool Class getPopulation() method as it does not return
     * only live guppies
     * @return aliveGuppyCount as int
     */
    public int getGuppyPopulation() {
        int aliveGuppyCount = 0;
        for (Pool pool : pools) {
            for (Guppy guppy : pool.getGuppies()) {
                if (guppy.isAlive()) {
                    aliveGuppyCount++;}
            }
        }
        return aliveGuppyCount;
    }
    
    /**
     * Prints total Guppy population in the Ecosystem, and toString() of each Pool and
     * Stream in the Ecosystem
     */
    public String toString() {
        return "Number of living guppies: " + getGuppyPopulation() +
                "\n" + pools.toString() +
                "\n" + streams.toString();
    }
    
    /**
     * Prints Ecosystem's details
     */
    public void printDetails() {
        System.out.println(toString());
    }
}











