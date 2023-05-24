public class pattern {
    public static void Hollow_Rectangle(int totRow, int totCol) // #1
    {
        for(int i = 1; i <= totRow; i++)
        {
            // outer
            for ( int j = 1; j <= totCol; j++ )
            {
                if ( i == 1 || i == totRow || j == 1 || j == totCol)
                {
                    System.out.print("*");
                }
                else
                { 
                    System.out.print(" ");
                }
                
            }
        System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n) 
    {
        for(int i = 1; i <= n; i++)
        { // outer
            for (int j = 1; j <= n - i; j++)
            {
                System.out.print(" "); // inner space
            }
            for ( int j = 1; j <= i; j++)
            {
                System.out.print("*"); // inner star
            }
        System.out.println();
        }
    }

    public static void inverted_half_pyramid_with_number(int n)
    {
        for ( int i = 1; i <= n; i++)
        {
            for ( int j = 1; j <= n - i + 1; j++ )
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void Floyd_triangle(int n)
    {
        int counter = 1;
        for( int i = 1; i <= n; i++)
        {
            // outer
            for ( int j = 1; j <= i; j++)
            {
                System.out.print(counter + " ");
                counter++;

            }
            System.out.println();
        }
    }

    public static void butterfly(int n)
    {
        // 1st half
        for (int i = 1; i<=n; i++) // outer
        {
            for(int j = 1; j <= i; j++) //stars
                {
                System.out.print("*");
                }
            for(int j = 1; j <= 2*(n-i); j++) //spaces
                {
                System.out.print(" ");
                }
            for(int j = 1; j <= i; j++) // stars
                {  
                System.out.print("*");
                }
        System.out.println();
        }
        // 2nd half
        for (int i = n; i>=1; i--)
        {
            for (int j = 1; j <= i; j++) // stars
            {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) // spaces
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) // stars
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void _0_1s_Triangle(int n ) {
        
        for( int i = 1; i<=n; i++)
        {
            for ( int j = 1; j<=i; j++)
            {
                if((i+j) % 2 == 0)
                {
                    System.out.print("1");
                
                } 
                else
                {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n )
    {
        for( int i = 1; i <= n; i++) // outer 
        {
            for(int j = 1; j<=(n-i); j++) //spaces
            {
                System.out.print(" ");
            }
            for( int j = 1; j <= n; j++) // stars
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollow_rhombus(int n)
    {
        for (int i = 1; i<=n; i++ ) // outer
        {
            for (int j = 1; j<=(n-i); j++) // spaces
            {
                System.out.print(" ");
            }
            // stars
            for ( int j = 1; j<=n; j++)
            {
                if(i==1 || i == n || j == 1 || j == n )
                {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        System.out.println();
        }
    }
    public static void diamond(int n )
    {   //1st half
        for ( int i = 1; i <= n ; i++)
        { // spaces
            for ( int j = 1; j <= n-i; j++ )
            {
                System.out.print(" ");
            }
            // stars
            for(int j = 1; j <= (2*i)-1; j++ )
            {
                System.out.print("*");
            }
        System.out.println();
        }
        //2nd half
        for ( int i = n; i >= 0 ; i--)
        {
            for ( int j = 1; j <= (n-i); j++ )
            {
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i)-1; j++ )
            {
                System.out.print("*");
            }
        System.out.println();
        }
    }
    public static void number_pyramid(int n)
    {
        for ( int i = 1; i <= n; i++ ) // outer
        {
            for ( int j = 1; j<=(n-i); j++ ) // spaces
            {
                System.out.print(" ");
            }

            for (int j = 1; j <= i ; j++)
            {
                System.out.print(i + " ");
            }
        System.out.println();
        }
    }
    public static void palandromicPatternwithNumbers(int n)
    {
        //Outer
        for ( int i = 1; i <= n; i++)
        {
        // Spaces
            for (int j = 1; j <= (n-i); j++)
            {
                System.out.print(" ");
            }
        // Descending
            for (int j = i; j >= 1; j--)
            {
                System.out.print(j);
            }
        // Ascending
            for (int j = 2; j <= i; j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }

    }

    public static void main(String args[])
    {

        //number_pyramid(9);
        palandromicPatternwithNumbers(5);
    }
}
