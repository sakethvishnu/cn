import java.util.*;
public class crc{
    public static String xor(String x,String y){
        String out = new String();
        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == y.charAt(i))
                out+="0";
            else
                out+="1";
        }
        return out;
    }
    public static String check(String divisor,String divident){
        String temp = divident.substring(0,divisor.length()),zeros = new String();
        int d = divisor.length();
        for(int i = 0 ; i < d ;i++)
            zeros += "0";
        for(int i = d ;i < divident.length() + d-1  ; i++){
            if((temp.charAt(0)) == '1')
                temp = xor(temp,divisor);
            else
                temp = xor(temp,zeros);
            if(i == divident.length())
            break;
            temp = temp.substring(1,d)+divident.charAt(i);
        }
        return temp.substring(1,d);
    }
    public static void main(String... aasds){
        Scanner sc = new Scanner(System.in);
        String divisor = sc.nextLine(),divident = sc.nextLine();
        String new_divident = divident;
        for(int i = 0 ; i < divisor.length() - 1 ; i++)
                new_divident+="0";
        divident += check(divisor,new_divident);
        System.out.println("Data obtained from sender "+divident);
        String s = check(divisor,divident);
        System.out.println("Result obtained from reciever : "+s);
        if(s.equals("000"))
            System.out.println("Message passes successfully");
        else
            System.out.println("Error Detected");
    }
}