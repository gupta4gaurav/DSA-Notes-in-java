import java.util.*;
public class Strings 
{
    public static void printString(String str)
    {
        for( int i = 0; i < str.length(); i++)
        {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str){
        for (int i = 0; i <= str.length()/2; i++)
        {
            if ( str.charAt(i) != str.charAt(str.length() - 1 -i))
            {
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) 
    {
        int x = 0, y = 0;
        for( int i = 0; i < path.length(); i++)
        {
            char dir = path.charAt(i);

            if ( dir == 'N')
            {
                y++;
            }
            else if ( dir == 'S')
            {
                y--;
            }
            else if (dir == 'E')
            {
                x++;
            }
            else 
            { 
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }
    public static void main(String[] args) {

        // String str = new String("Hello");
        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));
        // String str = "Gaurav";
        // printString(str);

        // System.out.println(isPalindrome(str));
        

    }
}