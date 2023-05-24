import java.util.*;


public class printYear {
    public static void main(String[] args) 
    
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the year : ");
        int year = sc.nextInt();

        boolean x = (year % 4 == 0);
        boolean y = ( year % 100 != 0);
        boolean z = (year % 100 == 0) && ( year % 400 == 0);
        if (x && (y || z))
        {
            System.out.println( year + " is a leap year");
        }
        else {
            System.out.println( year + " is not a leap year");
        }


















        /**
        if(year % 4 == 0)
            {
                if (year % 100 == 0)
                {
                    
                    if ( year % 400 == 0 )
                    {
                        System.out.println("This given year is leap year.");
                    }
                    else 
                    {
                        System.out.println("This given year is not leap year.");
                    }
                }
                else 
                {
                    System.out.println("This given year is leap year.");
                }
            }
        else 
        {
                System.out.println("This given year is not leap year.");
        }
        */

    }
}

