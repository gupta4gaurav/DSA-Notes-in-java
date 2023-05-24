import java.util.*;
import java.math.*;


public class JavaBasics 
{
    public static void Hollow_Rectangle(int totRow, int totCol)
    {   // outer Loop
        for( int i = 1; i <= totRow; i++)
        {   // inner loop
            for( int j = 1; j <= totCol; j++)
            {
                if(i==1 || i == totRow || j == 1 || j == totCol)
                {
                    System.out.print("*");
                }else{
                System.out.print(" ");}
            }
            System.out.println();

        }
    }
    
    
    public static void main(String args[])
    {
        Hollow_Rectangle(4, 5);
        

    }
}