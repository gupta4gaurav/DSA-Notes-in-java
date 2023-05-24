import java.util.ArrayList;
public class PairSum {

    // Brute Force Approach 
    public static boolean findSumPair(ArrayList<Integer> list, int target){
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }
        // 2 Pointer Approach
    public static boolean findSumPairUsing2Pointer(ArrayList<Integer> list, int target) {
        int lP = 0, rP = list.size() - 1;
        while ( lP != rP){
            // Case - 1 
            if(list.get(lP) + list.get(rP) == target){
                return true;
            }
            // Case - 2
            if(list.get(lP) + list.get(rP) < target){
                lP++;
            }
            // Case - 3 
            else{
                rP--;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target = 5;

        System.out.println(findSumPairUsing2Pointer(list, 5));


    }
}
