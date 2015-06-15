
/**
 * Guppy.
 * A simple data class.
 * 
 * @author  COMP 1409, edit by Martin Cheung
 * @version 20150609
 */
public class Guppy
{
    public static final int YOUNG_FISH = 10;
    public static final int MATURE_FISH = 30;
    public static final int MAX_AGE_WEEKS = 50;
    public static final double MIN_WATER_VOLUME_ML = 250.0;
    public static final String DEFAULT_GENUS = "Poecilia";
    public static final String DEFAULT_SPECIES = "reticulata";
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    
    private static int populationSize = 0;

    private String genus;
    private String species;
    private int ageWeeks;
    private boolean female;
    private int generation;
    private boolean alive;
    private double healthCoefficient;
    private int identificationNumber;
    
    /**
     * Default constructor for objects of class Guppy initializes
     * all fields to default.  Note that the identification number
     * is set automatically.
     */
    public Guppy()
    {
        setGenus(DEFAULT_GENUS);
        setSpecies(DEFAULT_SPECIES);
        setAge(0);
        setFemale(true);
        setGeneration(0);
        setAlive(true);
        setHealthCoefficient(DEFAULT_HEALTH_COEFFICIENT);
        identificationNumber = ++populationSize;
    }
    
    /**
     * Constructor for objects of class Guppy.  Note that the identification
     * number is set automatically.
     * @param genus a String representing the Guppy's species
     * @param species a String representing the Guppy's species
     * @param ageWeeks an int representing the age in weeks
     * @param female a boolean set to true if the Guppy is female
     * @param generation an int specifying the generation number
     * @param alive a boolean set to true if the Guppy is alive
     * @param healthCoefficient a double representing the Guppy's health must
     *                          be [0.0, 1.0] else set to DEFAULT_HEALTH_COEFFICIENT.
     */
    public Guppy(String genus,
                 String species,
                 int ageWeeks,
                 boolean female,
                 int generation,
                 boolean alive,
                 double healthCoefficient)
    {
        setGenus(genus);
        setSpecies(species);
        setAge(ageWeeks);
        setFemale(female);
        setGeneration(generation);
        setAlive(alive);
        if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT ||
            healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(DEFAULT_HEALTH_COEFFICIENT);
        } else {
            setHealthCoefficient(healthCoefficient);
        }
        
        identificationNumber = ++populationSize;
    }
    
    /**
     * Returns the genus.
     * @return genus as a String
     */
    public String getGenus()
    {
        return genus;
    }
    
    /**
     * Sets the genus in title case.  Ignores null and empty
     * String parameters.
     * @param genus a String
     */
    public final void setGenus(String genus)
    {
        if (genus != null && genus.trim().length() > 0) {
            this.genus = formatName( genus.trim() );
        }
        if (this.genus == null) { // Used by the non-default constructor
            this.genus = DEFAULT_GENUS;
        }
    }
    
    /**
     * Returns the species.
     * @return species as a String
     */
    public String getSpecies()
    {
        return species;
    }
    
    /**
     * Sets the species in lower case.  Ignores null and empty
     * String parameters.
     * @param species a String
     */
    public final void setSpecies(String species)
    {
        if (species != null && species.trim().length() > 0) {
            this.species = species.trim().toLowerCase();
        }
        if (this.species == null) { // Used by the non-default constructor
            this.species = DEFAULT_SPECIES;
        }
    }
    
    /**
     * Returns the age in weeks.
     * @return age in weeks an int
     */
    public int getAge()
    {
        return ageWeeks;
    }
    
    /**
     * Sets the age in weeks.  Ignores parameters less than 0 or
     * greater than MAX_AGE_WEEKS.
     * @param ageWeeks an int
     */
    public final void setAge(int ageWeeks)
    {
        if (ageWeeks >= 0 && ageWeeks <= MAX_AGE_WEEKS) {
            this.ageWeeks = ageWeeks;
            if (ageWeeks == MAX_AGE_WEEKS) alive = false;
        }
    }
    
    /**
     * Returns true if this Guppy is a female.
     * @return true if female, false if male
     */
    public boolean isFemale()
    {
        return female;
    }
    
    /**
     * Sets the sex of the Guppy.
     * @param female a boolean which is true if this is a female
     */
    public final void setFemale(boolean female) 
    {
        this.female = female;
    }
    
    /**
     * Returns the generation number of this Guppy.
     * @return generation an int
     */
    public int getGeneration()
    {
        return generation;
    }
    
    /**
     * Sets the generation.  Ignores negative parameters.
     * @param generation an int
     */
    public final void setGeneration(int generation)
    {
        if (generation >= 0) {
            this.generation = generation;
        }
    }
    
    /**
     * Returns true if this Guppy is alive.
     * @return true if alive, false if dead
     */
    public boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Sets whether this Guppy is alive.
     * @param alive a boolean true if this Guppy is alive
     */
    public final void setAlive(boolean alive) 
    {
        this.alive = alive;
    }
    
    /**
     * Returns the health coefficient.
     * @return healthCoefficient a double
     */
    public double getHealthCoefficient()
    {
        return healthCoefficient;
    }
    
    /**
     * Sets the health coefficient.  Ignores parameters that are
     * less than MINIMUM_HEALTH_COEFFICIENT or greater than
     * MINIMUM_HEALTH_COEFFICIENT.
     * @param health coefficient a double
     */
    public final void setHealthCoefficient(double healthCoefficient) 
    {
        if (healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT &&
            healthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoefficient;
        }
    }
    
    /**
     * Returns this Guppy's identification number.
     * @return identificationNumber as an int
     */
    public int getIdentificationNumber()
    {
        return identificationNumber;
    }
    
    /**
     * Increments the age by one week. Guppy is not alive after MAX_AGE_WEEKS.
     */
    public void incrementAge()
    {
        this.ageWeeks += 1;
        if (ageWeeks >= MAX_AGE_WEEKS) {
            alive = false;
        }
    }
    
    /**
     * Returns the volume of water this Guppy requires.
     * @return volume in mL a double
     */
    public double getVolumeNeeded()
    {
        if (getAge() < YOUNG_FISH) {
            return MIN_WATER_VOLUME_ML;
        }
        if (getAge() >= YOUNG_FISH && getAge() <= MATURE_FISH) {
            return MIN_WATER_VOLUME_ML * (getAge() / 10.0);
        }
        if (getAge() > MATURE_FISH && getAge() <= MAX_AGE_WEEKS) {
            return MIN_WATER_VOLUME_ML * 1.5;
        }
        return 0.0;
    }
    
    /**
     * Changes the health coefficient by the specified delta.
     * The health coefficient will remain in the range [0.0, 1.0].
     * @param delta the amount to change the health coeffficient a double
     */
    public void changeHealthCoefficient(double delta)
    {
        double newHealthCoefficient = getHealthCoefficient() + delta;
        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MINIMUM_HEALTH_COEFFICIENT);
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MAXIMUM_HEALTH_COEFFICIENT);
        } else {
            setHealthCoefficient(newHealthCoefficient);
        }
    }
    
    /**
     * Returns a description of this Guppy.
     * @return description of this Guppy as a String.
     */
    public String toString()
    {
        String thisGuppy = "";
        thisGuppy += "Identification Number: " + getIdentificationNumber() + "\n";
        thisGuppy += "Genus: " + getGenus() + "\n";
        thisGuppy += "Species: " + getSpecies() + "\n";
        thisGuppy += "Age (weeks): " + getAge() + "\n";
        if (isFemale() == true) {
            thisGuppy += "Sex: female \n";
        } else {
            thisGuppy += "Sex: male \n";
        }
        thisGuppy += "Generation: " + getGeneration() + "\n";
        thisGuppy += "Is alive: " + isAlive() + "\n";
        thisGuppy += "Health Coefficient: " + getHealthCoefficient();
        return thisGuppy;
    }

    /**
     * Prints this Guppy's details.
     */
    public void printDetails()
    {
        System.out.println(this.toString());
    }
    
    /**
     * Formats a name and returns it with the first letter in
     * upper case and the rest in lower case (title case).
     * @param name the name to format
     * @return the correctly formatted name, as a String
     */
    public static final String formatName(String name)
    {
        if (name != null && name.trim().length() > 0) {
            String firstLetter = name.trim().toUpperCase().substring(0, 1);
            String theRest = name.trim().toLowerCase().substring(1);
            return firstLetter + theRest;
        }
        return null;
    }
    
    /**
     * Returns the total number of Guppies created.
     * @return populationSize as int
     */
    public static int getNumberCreated()
    {
        return populationSize;        
    }
}
