public class KeypadCombination {
    final static char[][] L = { {}, {}, {'a', 'b', 'c'},//2
    {'d', 'e', 'f'},//3
    {'g', 'h', 'i'},//4
    {'j', 'k', 'l'},//5
    {'m', 'n', 'o'}, //6
    {'p','q', 'r', 's'}, //7
    {'t', 'u', 'v'}, // 8
    {'w','x','y','z'} //9
    };

    public static void letterCombinations(String D) {
        int len = D.length();
        if(len == 0){
            System.out.println("");
            return;
        }
        bfs(0,len, new StringBuilder(), D);
    }

    public static void bfs(int pos, int len, StringBuilder sb, String D) {
        if(pos == len){
            System.out.println(sb.toString());
        }
        else{
            char[] letter = L[Character.getNumericValue(D.charAt(pos))];
            for(int i = 0; i<letter.length; i++){
                bfs(pos + 1, len, new StringBuilder(sb).append(letter[i]), D);
            }
        }
    }
    public static void main(String[] args) {
        letterCombinations("232");
    }
}
