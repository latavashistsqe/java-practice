import java.util.*;

public class ProgramsList {

    public static void main(String[] args) {
        example1(); // Create and Print a List
        example2(); // Iterate Through a List
        example3(); // Program 3: Reverse a list
        example4(); // Program 4: Covert Array to list and list to array
        example5(); // Program 5: Find min and max in list
        example6(); // Program 6: Convert List to Set (Remove Duplicates)
        example7(); // Program 7: Iterate Through a Set
    }

    // Create and Print a List
    public static void example1() {
        List<String> list = new ArrayList<>();
        list.add("Science");
        list.add("maths");
        list.add("CS");

        System.out.println(list);
    }

    // Iterate Through a List
    public static void example2() {
        List<String> list = Arrays.asList("One", "Two", "Three");

        // by for- each loop
        for (String s : list) {
            System.out.println(s);
        }

        // By Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // Program 3 : Reverse a list
    public static void example3() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        System.out.println("Original list : " + list);

        Collections.reverse(list);

        System.out.println("Reversed list:" + list);
    }

    // Program 4: Covert Array to list and list to array
    public static void example4() {
        String[] arr = {"java", "Python", "PHP"};
        // Array to list
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("List to array:" + list);

        //list to array
        String[] newArr = list.toArray(new String[0]);
        System.out.println("List to Array:" + Arrays.toString(newArr));
    }

    // Program 5: Find min and max in list
    public static void example5() {
        List<Integer> numbers = Arrays.asList(15, 17, 45, 27, 63, 27);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

        System.out.println("List: " + numbers);
        System.out.println("Maximum:" + max);
        System.out.println("min:" + min);
    }

    // Program 6: Convert List to Set (Remove Duplicates)
    public static void example6() {
        List<String> list = Arrays.asList("A", "b", "a", "A", "D");
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }

    // Program 7 :Iterate Through a Set
    // in set > no preservation of insertion order unless linkedhashset is used
    public static void example7() {
        Set<String> set = new HashSet<>(Arrays.asList("Dog", "cat", "Elephant"));

        for (String s : set) {
            System.out.println(s);
        }
    }
}
