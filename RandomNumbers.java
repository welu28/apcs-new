import java.util.*;

public class RandomNumbers {
    public static final int size = 10000;

    public static void main(String[] args) {
        Number[] numbers = new Number[size];
        Random rand = new Random();
        
        for (int i = 0; i < size; i++) {
            if (rand.nextBoolean()) {
                numbers[i] = rand.nextInt(19) + 2;
            } else {
                numbers[i] = 2 + (18 * rand.nextDouble());
            }
        }
        
        Arrays.sort(numbers, (o1, o2) -> Double.compare(o1.doubleValue(), o2.doubleValue())); // lambda comparator
        
        int intCount = 0;
        int doubleCount = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (Number number : numbers) {
            if (number.doubleValue() == number.intValue()) {
                intCount++;
            } else {
                doubleCount++;
            }
            
            int key = (int) Math.round(number.doubleValue());
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }
        
        System.out.println("integers: " + intCount);
        System.out.println("doubles: " + doubleCount);
        
        for (int i = 2; i <= 20; i++) {
            System.out.println(i + ": " + counts.get(i));
        }
    }
}
