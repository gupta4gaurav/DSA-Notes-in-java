public class BackTracking {
    public static void findAllSubset(StringBuilder str, int i, StringBuilder ans) {
        // Base Case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("Null");
                return;
            }
            else{
                System.out.println(ans.toString());
                return;
            }
        }
        //Recursive Case
        ans.append(str.charAt(i));
        findAllSubset(str, i + 1, ans); // Yes Choice
        ans.deleteCharAt(ans.length() - 1);

        findAllSubset(str, i + 1, ans); // No
    }
    public static void main(String[] args) {
        // Initialize a string
        StringBuilder str = new StringBuilder();
        str.append("ab");
        // call the recursive method findAllSubset with the string builder, starting index of 0,
        // and a new empty stringbuilder object as te initial subset.
        findAllSubset(str, 0, new StringBuilder() );
    }
}
