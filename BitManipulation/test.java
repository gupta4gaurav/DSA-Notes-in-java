import javax.swing.text.Position;

public class test {
    
    public static int setIthbits(int Number, int Position) {
        int bitmask = 1 << Position;
        return bitmask | Number;
    }

    public static int clearIthbits(int Number, int Position) {
        int bitMask = ~(1 << Position);
        return bitMask & Number;
    }

    public static int updateIthbits(int Number, int Position, int newBit) {
        Number = clearIthbits(Number, Position);
        int bitmask = newBit << Position;
        return Number | bitmask;
    }
    public static int clearLastIthbits(int number, int postitions){
        int bitMask = (~0) << postitions;
        return number & bitMask;
    }
    public static int clearRangeIthbits(int number, int startIndex, int endIndex){
        int a = (~0) << endIndex + 1;
        int b = (1 << startIndex ) - 1;
        int bitmask = a | b;
        return number & bitmask;
    }
    public static boolean isPoweroftwo(int number) {
        return ((number & (number - 1)) == 0);
        
    }
    public static int countSetBits(int number) {
        int count = 0 ;
        while(number > 0){
            if((number & 1 ) != 0){
                count++;
            }
        number = number >> 1;
        }

        return count;
    }
    public static int fastExpo(int number, int power) {
        int ans = 1;
        while (power > 0){
            if((power & 1 ) != 0){
                ans = ans * number;
            }
            number = number * number ;
            power = power >> 1;
        }
        return ans;
        
    }
    public static long modularExpo(long base, long exponent, long modulus){
        long result = 1;
        base %= modulus;
        while ( exponent > 0 ){
            if((exponent & 1 ) != 0){
                result = (result * base) % modulus;
            }
            base = ( base * base ) % modulus;
            exponent >>= 1;
        }
        return result;
        
    }
    public static void main(String[] args) {
        System.out.println(modularExpo(3978432, 5, 1000000007));
    }
}
