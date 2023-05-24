import java.util.*;

public class BitManipulation 
{
    public static void OddOrEven(int n)
    {
        int bitmask = 1;
        if ( (n & bitmask) == 0 )
        {
            System.out.println("This Number is even");
        }
        else
        {
            System.out.println("This Number is odd");
        }
    }

    public static int getIthbits(int Number, int Position) 
    {
        int bitmask = 1 << Position;
        if ((bitmask & Number ) == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public static int setIthbits(int Number, int Position) {
        int bitmask = 1<<Position;
        return bitmask | Number;
    }

    public static int clearIthbits( int Number, int Position) {
        int bitMask = ~(1<<Position);
        return bitMask & Number;
    }

    public static int updateIthbits( int Number, int Position, int newBit)
    {
        // Number = clearIthbits(Number, Position);
        // int bitMask = newBit << Position;
        // return Number| bitMask;
        if( newBit == 0)
        {
            return clearIthbits(Number, Position);
        }
        else
        {
            return setIthbits(Number, Position);
        }
    }

    public static int clearIbits(int Number, int Position) 
    {
        int bitMask = (~0) << Position ;
        return bitMask & Number;

    }

    public static int  clearRangeInBits(int Number, int i, int j) 
    {
        int a = ((~0) << (j+1));
        int b = (1<<i) - 1;
        int bitMask = a|b;
        return bitMask & Number;
    }

    public static boolean isPowerOf2(int n) 
    {
        int check = n & (n-1);  
        if ( check == 0)
        {
            return true;
        } 
        else
        {
            return false;
        } 
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0)
        {
            if( (n & 1) != 0) // Check LSB
            {
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n)
    {
        int ans = 1;
        while( n > 0)
        {
            if ( ( n & 1) != 0)
            {
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    public static void main ( String args[])
    {
        
        // System.out.println(clearIthbits( 10, 1));
        
        // System.out.println(updateIthbits(10, 2, 1));
        // System.out.println(clearIbits(15, 2));
        // System.out.println(clearRangeInBits( 10, 2, 4));
        // System.out.println(Check2Power(5));
        // System.out.println(countSetBits(10));
        //System.out.println(fastExpo(3, 5));

    }
}
