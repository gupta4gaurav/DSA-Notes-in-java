import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static boolean isAnagram(String str, String str1) {
        char[] arr1 = str.toCharArray();
        char[] arr2 = str1.toCharArray();

        // sort
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // compare Sorted array
        return Arrays.equals(arr1, arr2);

    }

    public static void main(String[] args) {

        String str = "Silent", str1 = "listen";

        System.out.println(isAnagram(str, str1));

    }
}