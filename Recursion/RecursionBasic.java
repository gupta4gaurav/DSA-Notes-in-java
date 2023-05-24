public class RecursionBasic {
    public static void printDecres(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(n + " ");
        printDecres(n - 1);
    }

    public static void printIncre(int n){
        if (n == 1) {
            System.out.print(n+" ");
            return;
        }
        printIncre(n - 1);
        System.out.print(n + " ");
        
    }

    public static int fact(int n ){
        if(n == 0){
            return 1;
        }
        int fnM1 = fact(n - 1);
        int fn = n * fnM1;
        return fn;
    }

    public static int calcSum(int n){
        if(n == 0){
            return 1;
        }
        int SnM1 = calcSum( n - 1);
        int Sn = n + SnM1;
        return Sn;
    }

    public static int fib(int n){
        if ( n == 0 || n == 1){
            return n;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

    public static boolean isSorted(int arr[], int i){
        if(i == arr.length - 1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int key, int i) {
        if ( i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        
        return firstOccur(arr, key, i+1);
    }

    public static int lastOccur(int arr[], int key, int i) {
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccur(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int pow(int x, int i){
        if(i == 0){
            return 1;
        }
        int power = x * pow(x, i-1);
        return power;
    }
    
    public static int optimizedPow(int x, int i){
        if(i == 0){
            return 1;
        }
        int halfPower = optimizedPow(x, i/2);
        int halfPowerSq = halfPower * halfPower;
        if ( i % 2 != 0){
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingProblem(int n) {
        //Base
        if(n == 0 || n == 1){
            return 1;
        }
        //Kaam
        //vertical choice
        int verticleTiles = tilingProblem(n-1);

        // Horizontal Choice
        int horizontalTiles = tilingProblem(n-2);

        int totTiles = verticleTiles + horizontalTiles;

        return totTiles;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            //Duplicate
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendPairing(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        int single = friendPairing(n-1);
        int pair = (n - 1) * friendPairing(n - 2);
        int totWay = single + pair;
        return totWay;
        // return friendPairing(n-1) + (n-1) * friendPairing(n+2);
    }

    public static void printBinString(int n, int lastPlace, String str){
        if(n == 0){ // base case
            System.out.println(str);
            return;
        }
        // Kaam
        printBinString(n-1, 0, str+"0");
        if(lastPlace == 0){
            printBinString(n - 1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        printBinString(190, 0, "");
     }
}