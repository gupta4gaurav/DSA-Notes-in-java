package conditional_Statement;
import java.util.*;


public class printNo {
    public static void main(String[] args){
    // Print number positive or negative
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    if (number >= 0)
    {
        System.out.println("The number is positive");

    }
    else 
    {
        System.out.println("The number is negative");
    }
}
}
