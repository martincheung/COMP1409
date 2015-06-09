import java.util.*;
/**
 * Pool.
 * A simple data class.
 * 
 * @author  COMP 1409
 * @version 1.0 May 2015
 */
public class Pool
{
    public static final String DEFAULT_NAME = "Unnamed";
    public static final double DEFAULT_TEMPERATURE = 40.0;
    public static final double MINIMUM_TEMPERATURE = 0.0;
    public static final double MAXIMUM_TEMPERATURE = 100.0;
    public static final double DEFAULT_PH = 7.0;
    public static final double MINIMUM_PH = 0.0;
    public static final double MAXIMUM_PH = 14.0;
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.5;
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;
    
    private static int numberOfPools = 0;
    
    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    
    private ArrayList<Guppy> guppyPopulation;
    private Random randomNumberGenerator;

    /**
     * Constructor for objects of class Pool initializes
     * all fields to default.  Note that the identification number
     * is set automatically.
     */
    public Pool()
    {
        setName(DEFAULT_NAME);
        setVolume(0.0);
        setTemperature(DEFAULT_TEMPERATURE);
        setPH(DEFAULT_PH);
        setNutrientCoefficient(DEFAULT_NUTRIENT_COEFFICIENT);
        identificationNumber = ++numberOfPools;
        numberOfPools++;
        
        guppyPopulation = new ArrayList<Guppy>();
    }
    
    /**
     * Constructor for objects of class Pool.  Note that the identification
     * number is set automatically.
     * @param name the Pool's name, a String
     * @param volumeLitres a double representing the Pool's volume in litres
     * @param temperatureCelsius a double representing the Pool's temperature.  Must be
     *        in the range [MINIMUM_TEMPERATURE, MAXIMUM_TEMPERATURE] else set to default.
     * @param pH a double representing the Pool's pH.  Must be
     *        in the range [MINIMUM_PH, MAXIMUM_PH] else set to default.
     * @param nutrientCoefficient a double representing the Pool's nutrientCoefficient.  Must be
     *        in the range [MINIMUM_NUTRIENT_COEFFICIENT, MAXIMUM_NUTRIENT_COEFFICIENT]
     *        else set to default.
     */
    public Pool(String name,
                double volumeLitres,
                double temperatureCelsius,
                double pH,
                double nutrientCoefficient)
    {
        setName(name);
        setVolume(volumeLitres);
        setTemperature(temperatureCelsius);
        
        if (temperatureCelsius < MINIMUM_TEMPERATURE || temperatureCelsius > MAXIMUM_TEMPERATURE) {
            setTemperature(DEFAULT_TEMPERATURE);
        } else {
            setTemperature(temperatureCelsius);
        }
        
        if (pH < MINIMUM_PH || pH > MAXIMUM_PH) {
            setPH(DEFAULT_PH);
        } else {
            setPH(pH);
        }
        
        if (nutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT ||
            nutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(DEFAULT_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(nutrientCoefficient);
        }
        
        identificationNumber = ++numberOfPools;
        numberOfPools++;
        
        guppyPopulation = new ArrayList<Guppy>();
    }
    
    /**
     * Returns the name.
     * @return name as a String
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the name in title case..  Ignores null and empty
     * String parameters.
     * @param name a String
     */
    public final void setName(String name)
    {
        if (name != null && name.trim().length() > 0) {
            this.name = Guppy.formatName( name.trim() ); // This is how we call the static method in Guppy
        }                                                // from a client class or object (in this case a Pool).
        if (this.name == null) { // Used by the non-default constructor
            this.name = DEFAULT_NAME;
        }
    }
    
    /**
     * Returns the volume in litres of this Pool.
     * @return volumeLitres a double
     */
    public double getVolume()
    {
        return volumeLitres;
    }
    
    /**
     * Sets the volume of this Pool in litres.  Ignores negative parameters.
     * @param volumeLitres a double
     */
    public final void setVolume(double volumeLitres)
    {
        if (volumeLitres >= 0) {
            this.volumeLitres = volumeLitres;
        }
    }
    
    /**
     * Returns the temperature of this Pool in degrees Celsius.
     * @return temperatureCelsius a double
     */
    public double getTemperature()
    {
        return temperatureCelsius;
    }
    
    /**
     * Sets the temperature of this Pool in degrees Celsius. Ignores parameters
     * outside of range [MINIMUM_TEMPERATURE, MAXIMUM_TEMPERATURE].
     * @param temperatureCelsius a double
     */
    public final void setTemperature(double temperatureCelsius)
    {
        if (temperatureCelsius >= MINIMUM_TEMPERATURE && temperatureCelsius <= MAXIMUM_TEMPERATURE) {
            this.temperatureCelsius = temperatureCelsius;
        }
    }
    
    /**
     * Returns the pH of this Pool.
     * @return pH a double
     */
    public double getPH()
    {
        return pH;
    }
    
    /**
     * Sets the pH of this Pool. Ignores parameters
     * outside of range [MINIMUM_PH, MAXIMUM_PH].
     * @param pH a double
     */
    public final void setPH(double pH)
    {
        if (pH >= MINIMUM_PH && pH <= MAXIMUM_PH) {
            this.pH = pH;
        }
    }
    
    /**
     * Returns the nutrient coefficient.
     * @return nutrientCoefficient a double
     */
    public double getNutrientCoefficient()
    {
        return nutrientCoefficient;
    }
    
    /**
     * Sets the nutrient coefficient. Ignores parameters outside of
     * range [MINIMUM_NUTRIENT_COEFFICIENT, MAXIMUM_NUTRIENT_COEFFICIENT].
     * @param nutrient coefficient a double
     */
    public final void setNutrientCoefficient(double nutrientCoefficient) 
    {
        if (nutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT &&
            nutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }
    
    /**
     * Returns this Pool's identification number.
     * @return identificationNumber as an int
     */
    public int getIdentificationNumber()
    {
        return identificationNumber;
    }
    
    /**
     * Changes the nutrient coefficient by the specified delta.
     * The nutrient coefficient will remain in the range [0.0, 1.0].
     * @param delta the amount to change the nutrient coeffficient a double
     */
    public void changeNutrientCoefficient(double delta)
    {
        double newNutrientCoefficient = getNutrientCoefficient() + delta;
        
        if (newNutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MINIMUM_NUTRIENT_COEFFICIENT);
        } else if (newNutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MAXIMUM_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(newNutrientCoefficient);
        }
    }
    
    /**
     * Changes the temperature by the specified delta.
     * The temperature will remain in the range [0.0, 100.0].
     * @param delta the amount to change the temperature a double
     */
    public void changeTemperature(double delta)
    {
        double newTemperature = getTemperature() + delta;
        
        if (newTemperature < MINIMUM_TEMPERATURE) {
            setTemperature(MINIMUM_TEMPERATURE);
        } else if (newTemperature > MAXIMUM_TEMPERATURE) {
            setTemperature(MAXIMUM_TEMPERATURE);
        } else {
            setTemperature(newTemperature);
        }
    }
    
    /**
     * Gets guppy population as ArrayList
     * @return guppyPopulation a ArrayList
     */
    public ArrayList<Guppy> getGuppies() {
    	return guppyPopulation;
    }
    
    /**
     * Sets guppy population
     * @param guppyPopulation a ArrayList<Guppy>
     */
    public void setGuppies(ArrayList<Guppy> guppyPopulation) {
    	if (guppyPopulation != null) {
    		this.guppyPopulation = guppyPopulation;
    	}
    }
    
    /**
     * Returns total number of Pools created.
     * @return numberOfPools a int
     */
    public static int getNumberCreated() {
    	return numberOfPools;
    }
    
    /**
     * Returns a description of this Pool.
     * @return description of this Pool as a String.
     */
    public String toString()
    {
        String thisPool = "";
        thisPool += "Identification Number: " + getIdentificationNumber() + "\n";
        thisPool += "Name: " + getName() + "\n";
        thisPool += "Volume (Litres): " + getVolume() + "\n";
        thisPool += "Temperature (Celsius):" + getTemperature() + "\n";
        thisPool += "pH: " + getPH() + "\n";
        thisPool += "Nutrient Coefficient: " + getNutrientCoefficient();
        return thisPool;
    }

    /**
     * Prints this Pool's details.
     */
    public void printDetails()
    {
        System.out.println(this.toString());
    }
}
