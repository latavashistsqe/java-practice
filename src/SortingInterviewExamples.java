import java.lang.reflect.Array;
import java.util.*;

public class SortingInterviewExamples {

    public static void main(String[] args) {
        int[] original = {5, 3, 8, 4, 2, 9, 1};

        System.out.println("Original:      " + Arrays.toString(original));
        System.out.println();

        // 1) Bubble Sort
        int[] a1 = Arrays.copyOf(original, original.length);
        bubbleSort(a1);
        System.out.println("Bubble Sort:   " + Arrays.toString(a1));

        // 2) selectionSort
        int[] a2 = Arrays.copyOf(original,original.length);
        selectionSort(a2);
        System.out.println("Select sort:" + Arrays.toString(a2));

        // 3)
    }

    // ---------- 1. Bubble Sort (teaching) ----------
    // Stable, in-place, O(n^2) time

    // Bubble sort repeatedly scans the array from left to right, comparing each adjacent pair.
    // If a pair is out of order, it swaps them.
    //Bubble sort is simple and stable,
    // but not efficient for large inputs.

    // Space complexity: O(1) extra space (in-place).

    //Stable? — Yes (if you use > for swap condition and not >=).
    // Equal elements are not swapped, so their relative order stays the same.

    //Adaptive? — Yes, with the swapped flag the algorithm runs
    // faster on nearly-sorted arrays (best-case linear time).

    //When to use — Mainly for teaching, simple implementations,
    // or if n is tiny / nearly sorted. For production or big arrays prefer
    // Arrays.sort(...) (built-in, optimized).

    public static void bubbleSort(int[] a) {

        int n = a.length; // number of elements
        boolean Swapped; // a flag to detect swap happened or not and to stop if sort is done

        for (int pass = 0; pass < n - 1; pass++) { // n-1 will pass to sort n items
            Swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    Swapped = true;
                }
            }
            if (!Swapped) break; // already sorted
        }
    }

// example 2 : selection Sort

    // It’s like selecting the smallest item in a list of numbers again and again until everything is in order.
// We divide the array into sorted and unsorted parts.
//In each pass, we select the smallest element from the unsorted part and place it in the correct position.
//It’s in-place but not stable, with O(n²) time complexity.

    public static void selectionSort(int[] a){
        int n = a.length;
        for (int i=0; i< n-1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
                int temp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = temp;

            }
        }

// Example 3: Insertion sort


    }









