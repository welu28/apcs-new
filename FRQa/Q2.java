package FRQa;

import java.util.*;

public class Q2 {
    // Part A
    private String sentence;

    public Q2(String sentence) {
        this.sentence = sentence;
    }

    public List<Integer> getBlankPositions() {
        List<Integer> blankPos = new ArrayList<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                blankPos.add(i);
            }
        }
        return blankPos;
    }

    // Part B
    public int countWords() {
        if (sentence.trim().isEmpty()) return 0; // handle empty ones, cant return 1 if only spaces
        return getBlankPositions().size() + 1;
    }

    // Part C
    public String[] getWords() {
        if (sentence.trim().isEmpty()) return new String[0];

        String[] words = sentence.split(" ");
        return words;
    }
}
