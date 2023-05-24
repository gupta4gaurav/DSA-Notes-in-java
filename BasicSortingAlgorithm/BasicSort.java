public class BasicSort {
    public static void bubbleSortinDescend(int arr[]){
        int n = arr.length;
        for(int turn = 0; turn <= n - 2; turn++){
            for(int j = 0; j <= n - turn - 2; j++){
                if(arr[j] < arr[j+1]){
                    //Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectSortDecend(int arr[]){
        int n = arr.length;

        for(int i = 0; i <= n-2; i++){
            int maximumPosition = i;
            for(int j = i+1; j<= n-2; j++ ){
                if (arr[maximumPosition] < arr[j]){
                    //swap
                    maximumPosition = j;
                }
                //swap 
                int temp = arr[maximumPosition];
                arr[maximumPosition] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void countingSortDescend(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            largest = Math.max( largest, arr[i]);
        }
        int count[] = new int[largest + 1];  // I got Trapped in this line
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = count.length - 1; i >= 0; i--){
        while(count[i] > 0){
            arr[j] = i;
            j++;
            count[i]--;
            }
        }
    }

    public static void insertSortDescend(int arr[]) {
        for( int i = 1 ; i < arr.length ; i++){
            int current = arr[i];
            int previous = i - 1;
            // Finding out correct position to insert
            while( previous >= 0 && arr[previous] < current){
                arr[previous + 1] = arr[previous];
                previous--;
            }
            //insertion
            arr[previous + 1] = current;

        }
    }

    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length;i++ ){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        // bubbleSortinDescen(arr);
        //selectSortDecend(arr);
        // insertSortDescend(arr);
        countingSortDescend(arr);
        printArr(arr);
    }
    
}
