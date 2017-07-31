
import java.util.Scanner;
/**
 *
 * @author Ankit
 */
public class PostFix {
    
    /* array is initialize with 20 you can make it your own */
    private int array[] = new int[20];
    /* number is taken for indexing of array */
    private int number = 0;
    
    /*
    * exp is expression (String is used beacause its easy to manipulate expression)
    */
    public static void main(String[] a) {
        Scanner scan = new Scanner(System.in);
        PostFix pst = new PostFix();
        int total = 0;
        char c;
        String exp;
        System.out.println("Enter your postFix Experssion = ");
        exp = scan.nextLine();
        int i = 0;
        while (i < exp.length()) {
             c = exp.charAt(i);
           if(pst.isDigit(Character.toString(c))) {
               pst.push(Integer.parseInt(Character.toString(c)));
           }else
           {
               int fn = pst.pop();
               int nxt = pst.pop();
               total = pst.Evaluate(c, fn, nxt);
               pst.push(total);
           }
           i++;
            
        }
        
        
        pst.showToatal();
        
        
      //  pst.printAllArray();
        
    }
    
    private void showToatal() {
        for (int j=0; j <= number; j++) {
          System.out.print(" value in stack(expression) is = "+pop());  
        }
    }
    
    private int Evaluate(char c, int fstNumber, int nxtNumber) {
       switch (c) {
                case '+' : 
                       return fstNumber + nxtNumber; 
                    
                case '-' : 
                    
                        return fstNumber - nxtNumber; 
                case '/' : 
                    
                        return fstNumber / nxtNumber; 
                case '*' :
                    
                      return fstNumber * nxtNumber; 
            }
        return 0;
    }
    
    /* This method using Regex for matching that the character is digit or not 
    * if you know that Regex used for string so that's why i used string instead of character
    * i parse the character into string
    */
    private boolean isDigit(String s) {
        String pattern = "[0-9]";
        if (s.matches(pattern)) {
            return true;
        }
        else
            return false;
    }
     /*I think you know why i am using push method*/
    private void push(int num) {
        
       array[number] = num;
       number++;
       
    }
    /*I think you know why i am using pop method*/
    private int pop() {
        int numb = array[number-1];
        number--;
       
        return numb;
    }
     
}
