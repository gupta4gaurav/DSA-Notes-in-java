public class BasicSortingAlgorithm {
    
    public static void printArr(int arr[]) 
    {
        for ( int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void bubbleSort(int arr[]) {
        for ( int turn = 0; turn <= arr.length - 2; turn++)
        {
            int count = 0;
            for(int index = 0; index <= arr.length - 2 - turn; index++)
            if(arr[index]> arr[index+1])
            {
                //swap
                int temp = arr[index];
                arr[index] = arr[index+1];
                arr[index+1] = temp;
                count++;
            }
            
        }
    }


    public static void main(String args[])
    {
        int arr[] = { 1,2,3,4,5};
        bubbleSort(arr);
        printArr(arr);
    }
}
