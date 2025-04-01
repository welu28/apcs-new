/** Reverses elements of array arr.
* Precondition: arr.length > 0.
* Postcondition: The elements of arr have been reversed.
* @param arr the array to manipulate
*/
public static void reverseArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        left++;
        right--;
    }
}
