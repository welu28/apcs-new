package FRQ4;

public abstract class Bird
{
    private String name;
    private String noise;
    /** Constructor for objects of class Bird */
    public Bird(String birdName, String birdNoise)
    {
        name = birdName;
        noise = birdNoise;
    }

    public String getName()
    { return name; }

    public String getNoise()
    { return noise; }
    
    public abstract String getFood();
}
