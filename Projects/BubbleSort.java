
import java.util.HashMap;
import java.util.Map;

public class BubbleSort {

    public static void bubbleSort(int[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && arr[j] > arr[j + 1]) || (!ascending && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static Map<Integer, Integer> getMap(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 5, 2, 3, 8, 8, 1};

        System.out.println("original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();

        // ascending
        bubbleSort(array, true);
        System.out.println("sorted ascending");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();

        // duplicates
        Map<Integer, Integer> duplicates = getMap(array);
        System.out.println("duplicates:");
        for (Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }

        // descending
        bubbleSort(array, false);
        System.out.println();
        System.out.println("sorted descending");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
