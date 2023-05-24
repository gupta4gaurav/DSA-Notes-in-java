import javax.lang.model.element.Element;

public class test {
    public static void oddOReven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 1)
        {
            System.out.println("Odd");
        }
        else{
            System.out.println("Even");
        }
        
    }
    public static void main(String[] args) {

        oddOReven(77);
    }
}
