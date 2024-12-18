package FRQ4;

public class BirdSanctuary
{
    /** The list of birds */
    private Bird[] birdList;
    /** Precondition: Each Bird in birdList has a getFood
    * method implemented for it.
    * Postcondition: For each Bird in the birdList array, its name
    * followed by the result of a call to its getFood
    * method has been printed, one line per Bird.
    */
    public void allEat()
    { 
        for(Bird b: birdList) {
            String res = b.getName() + " eats " + b.getFood();
            System.out.println(res);
        }
    }
    //The constructor and other methods are not shown.
}