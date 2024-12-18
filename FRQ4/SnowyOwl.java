package FRQ4;
import java.util.Random;

public class SnowyOwl extends Owl {

    public SnowyOwl() {
        super("Snowy owl");
    }

    @Override
    public String getFood() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        if(x == 0) return "hare";
        else if(x == 1) return "lemming";
        else return "small bird";
    }
}
