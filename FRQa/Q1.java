package FRQa;

public class Q1 {
    // Part A
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Part B
    private int[][] mat;

    public Q1(int[][] m) {
        mat = m;
    }

    public void reverseAllRows() {
        for (int[] row : mat) {
            reverseArray(row);
        }
    }

    // Part C
    public void reverseMatrix() {
        reverseAllRows();
        int top = 0, bottom = mat.length - 1;
        while (top < bottom) {
            int[] temp = mat[top];
            mat[top] = mat[bottom];
            mat[bottom] = temp;
            top++;
            bottom--;
        }
    }
}
