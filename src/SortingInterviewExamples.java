
import java.util.*;

public class SortingInterviewExamples {

    public static void main(String[] args) {
        int[] num = {5, 3, 8, 4, 2, 9, 1};
        int[] quickNum = {23,53,66,12,11,65,14};


        System.out.println("Original:      " + Arrays.toString(num));
        System.out.println();

        // 1) Bubble Sort
        int[] a1 = Arrays.copyOf(num, num.length);
        bubbleSort(a1);
        System.out.println("Bubble Sort:   " + Arrays.toString(a1));

        // 2) selectionSort
        int[] a2 = Arrays.copyOf(num, num.length);
        selectionSort(a2);
        System.out.println("Select sort:" + Arrays.toString(a2));

        // 3) insertionsort
        int[] a3 = Arrays.copyOf(num, num.length);
        insertionsortwithTemp(a3);
        System.out.println("Insertion Sort with temp :" + Arrays.toString(a3));

        int[] a4 = Arrays.copyOf(num, num.length);
        insertionSortwithoutTemp(a4);
        System.out.println("Insertion sort without temp :" + Arrays.toString(a4));

        // 4) Merge sort : Divide and Conquer
        int[] a5 = Arrays.copyOf(num, num.length);
        SortingInterviewExamples sort = new SortingInterviewExamples();
        sort.mergeSort(a5);
        System.out.println("Merge sort:" + Arrays.toString(a5));


        // 5) Quick sort : Partition - exchange sort
        int[]a6 =Arrays.copyOf(quickNum,quickNum.length);
        SortingInterviewExamples quick = new SortingInterviewExamples();
        quick.quickSortRecursion(a6, 0,a6.length-1);
        System.out.println("Quick sort: " + Arrays.toString(a6));
        System.out.println();

        // 6) Heap sort
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

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
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
    // Write a program to insert an element in an array (specific position)

    public static void insertionsortwithTemp(int[] a) {

//        int arr[] = {6, 2, 4, 1, 7, 5};
//        int temp, j;

        for (int i = 1; i < a.length; i++) {

            int temp = a[i];
            int j = i;

            // // Shift larger elements to right
            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j = j - 1;
            }
            a[j] = temp;
        }
    }


    public static void insertionSortwithoutTemp(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;

                } else {
                    break;
                }
            }

        }
    }

    // Merge sort

    int[] array;
    int[] tempMergeArr;
    int length;

    public void mergeSort(int num[]) {

        this.array = num;
        this.length = num.length;
        this.tempMergeArr = new int[length];
        divideArray(0, length - 1);

    }

    public void divideArray(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            //  sort left side of the array
            divideArray(lowerIndex, middle);

            //  sort the right side of the array

            divideArray(middle + 1, higherIndex);
            // IMPORTANT: merge the two halves after they are sorted
            mergeArray(lowerIndex, middle, higherIndex);

        }
    }

    public void mergeArray(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array[i];
        }

        int i = lowerIndex; // pointer for left half (temp)
        int j = middle + 1; // pointer for right half (temp)
        int k = lowerIndex; // pointer for main array

        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergeArr[i];
            i++;
            k++;
        }
    }

    // Quick Sort


    // Robust Hoare-style partition (standard form)
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // move i right until arr[i] >= pivot
            do {
                i++;
            } while (i <= high && arr[i] < pivot);

            // move j left until arr[j] <= pivot
            do {
                j--;
            } while (j >= low && arr[j] > pivot);

            if (i >= j) {
                return j; // j is last index of left partition
            }

            // swap arr[i] and arr[j]
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    // Recursive quicksort matched to the Hoare partition above
    public void quickSortRecursion(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;

        int p = partition(arr, low, high); // p is j (end of left part)

        // Recurse on left [low..p] and right [p+1..high]
        if (low < p) quickSortRecursion(arr, low, p);
        if (p + 1 < high) quickSortRecursion(arr, p + 1, high);
    }

    // print array (single line) — clearer output for debugging
    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

//        // print array method
//        public void printArray(int[] quickNum)
//        {
//           //  for (int i : quickNum)
//            {
//               // System.out.println(i + "");
//            }
//            System.out.println(Arrays.toString(quickNum));
//
//        }
    }


















