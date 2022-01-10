import java.util.*;
class Hamming_c{
    public static void main(String... sasda){
        Scanner sc = new Scanner(System.in);
        String redundant_bits = sc.nextLine();
        int x = 0 , m = redundant_bits.length();
        int bits = (Integer.toBinaryString(m)).length();
        System.out.println(bits);
        char[] hamming = new char[m];
        for(int i = m-1 ; i >= 0; i--)
            hamming[i] = redundant_bits.charAt(i);
        System.out.println(Arrays.toString(hamming));
        char[][] binary = new char[m][bits];
        int r = 0;

        for(int i = 1 ; i <= m ; i++){
            String bin = Integer.toBinaryString(i);
            while(bin.length() < bits)
                bin = "0"+bin;
            for(int j = 0 ; j < bits;j++)
                binary[r][j] = bin.charAt(j);
            r++;
        }
        int no_of_ones[][] = new int[bits][r];
        for(int i = 0 ; i < bits ; i++)
            for(int j = 0 ; j < r ; j++)
                no_of_ones[i][j] = 0;
        
        for(int i = 0 ; i < bits ; i++){
            int ind = 0;
            for(int j = 0 ; j < r; j++){
                if(binary[j][i] == '1')
                    no_of_ones[i][ind++] = j+1;
            }
        }
        String s = new String();
        for(int i = bits-1 ; i >= 0 ;i--)
        {
        int count = 0 ;
            for(int j = 0 ; j < r ; j++){
                if(no_of_ones[i][j] != 0 ){
                    if(hamming[no_of_ones[i][j] - 1] == '1')
                        count++;
                }
            }
            if(count%2 == 0)
                s = "0"+s;
            else
                s += "1"+s;
        }
        System.out.println("parity bits :"+s);
        int n = Integer.parseInt(s,2);
        System.out.println(n);
        String rv = new String();
        if(n!=0){
        int l=redundant_bits.length();
        String ka = (redundant_bits.charAt(n-1) == '0')?"1":"0";
        for(int i = hamming.length-1 ; i >=0  ; i--){
            if(i+1 == n)
                rv += ka;
            else
                rv += Character.toString(hamming[i]);
            l++;
        }
        }else
            rv = redundant_bits;
        System.out.println(n);
        System.out.println("Hamming code after correction : "+rv);
    }
}