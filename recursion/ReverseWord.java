package recursion;

public class ReverseWord {
    public static String reverse(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return reverse(word.substring(1)) + word.charAt(0);
    }

    public static void main(String[] args) {
        String word = "hello";
        System.out.println(reverse(word));
    }
}
