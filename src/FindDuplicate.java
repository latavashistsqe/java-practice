import java.util.*;

// 💬 Real-world analogy
//Imagine your array is like a tray of cupcakes 🧁
//In a normal for loop, you’re saying:
//“I’ll pick cupcake number 0, then 1, then 2... until I reach the end.”
//In a for-each loop, you’re saying:
//“Just give me one cupcake at a time until the tray is empty.” 🍰
//You don’t care about the cupcake’s position — just the cupcake itself!

public class FindDuplicate {

public static void main(String[] args) {
DuplicateByLoop();
    hashSet();
}

public static void DuplicateByLoop(){

    String arr[] = {"Java", "py", "PHP", "java"};
    boolean flag = false;

    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i].equals(arr[j])) {
                // In Java, == compares memory addresses, not content.
             //   might be true sometimes (because of string pooling),
             //Use .equals() method — it compares actual string values.

                System.out.println("Found Duplicate element: " + arr[i]);
                flag = true;

            }
        }
    }
if (flag==false)
    {
        System.out.println("No Duplicate Found");
    }

}
public static void hashSet() {

    String arr[] = {"java", "py", "java", "C", "py", ".net"};

    Set<String> seen = new HashSet<>();
    boolean flag = false;

    for (String s : arr) {
        if (!seen.add(s)) {
            System.out.println("Found duplicate array: " + s);
            flag = true;

        }
    }
    if (!flag) {
        System.out.println("No duplicates found");
    }


}

}