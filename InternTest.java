
import java.util.Scanner;

public class InternTest {
    
    // Ans.1 ..........................
    //The program passes the provided test cases, but I've made certain assumptions to handle edge cases
    // Assumptions made:
    // 1. If a valid decimal number is given, we will output the corresponding INTGER (Since, we need integer)
    // 2. We are ignoring the left and right white spaces, if only valid integers are present 
    // 3. Invalid output will  be sown if more than one decimal points present
    // 4. In order to genrate proper output, the number should be within appropriate limit
    private static Integer getIntegerFromString(String value) throws ArithmeticException,NumberFormatException{
        long res=0;
        boolean neg=false;
        value=value.trim();
        if(value.length()<1) throw new NumberFormatException("Invalid Input");
        
        // checking negative case
        if(value.length()>0&&value.charAt(0)=='-'){
            neg=true;
            value=value.substring(1);
        }
        
        if(!checkValidNumber(value)) throw new NumberFormatException("Invalid Input");
        
        for(int i=0;i<value.length();i++){
            if(value.charAt(i)=='.') break;
            res=(res*10)+(value.charAt(i)-'0');
        }
        if(neg) res*=-1;
        return Math.toIntExact(res);
    }

    //Handles decimal numbers
    // Checks if the decimal number is valid or not
    private static boolean checkValidNumber(String value){
        int countDots=0;
        for(int i=0;i<value.length();i++){
            if(value.charAt(i)=='.') countDots++;
            else if(!(value.charAt(i)>='0'&&value.charAt(i)<='9')) return false;
        }
        
        if(countDots>1) return false;
        if(countDots==1&&value.charAt(value.length()-1)=='.') return false;
        return true;
    }
    
  // ......................END OF QUESTION 1....................................................................................
  //............................................................................................................................ 
    
    //ANSWER. 2
    //detects whether integer is present in the string
     private static boolean isNumberPresent(String value){
         for(int i=0;i<value.length();i++)
           if(value.charAt(i)>='0'&&value.charAt(i)<='9') return true;
        
        return false;
     }
    // ......................END OF QUESTION 2....................................................................................
 
     
     //Driver Functions to run
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int d=0;
        do{
            System.out.println("1. getIntegerFromString");
            System.out.println("2. isNumberPresent ");
            System.out.println("3. exit");
            System.out.print("Choose From above: ");
            d=sc.nextInt();
            String value="";
            if(d==1){
                try{
                    System.out.print("Enter String Value: ");
                    value=sc.next();

                    System.out.println(getIntegerFromString(value));
                }catch(ArithmeticException ex){
                    System.out.println("Invalid Input");
                }catch(NumberFormatException ex){
                    System.out.println("Invalid Input");
                }catch(Exception ex){
                    System.out.println("Invalid Input");
                }
            }else if(d==2){
                System.out.print("Enter String Value: ");
                value=sc.next();
                System.out.println(isNumberPresent(value));
            }
            
        }while(d!=3);
        
        
        
    }
}