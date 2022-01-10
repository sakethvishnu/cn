import java.util.*;

class Hamming{
    public static void main(String... s){
        Scanner sc = new Scanner(System.in);
        String redundant_bits = sc.nextLine();
        int x = 0,m = redundant_bits.length();
        for(int i = 0 ; i < m ; i++)
        {
            if(Math.pow(2,i) >= m+i+1){
                x = i;
                break;
            }
        }
        int bits = x;
        int tot_bits = x+m,k = 0,l = m-1;
        char[] hamming = new char[tot_bits];
        for(int i = 0 ; i < tot_bits ; i++)
        {
            if(Math.pow(2,k) == i+1){
                hamming[i] = 'r';
                k++;
            }else
                hamming[i] = redundant_bits.charAt(l--);
        }

        char binary[][] = new char[tot_bits][4];
        int r = 0;
        for(int i = 1 ; i <= tot_bits ; i++)
        {
            String bin  = Integer.toBinaryString(i);
            while(bin.length() < bits)
                bin = "0"+bin;
            for(int j = 0 ; j < bin.length() ; j++)
                binary[r][j] = bin.charAt(j);
            r++;
        }
        int no_of_ones[][] = new int[bits][r];  
        for(int i = 0 ; i < bits ; i++)
            for(int j = 0 ; j < r ; j++)
                no_of_ones[i][j] = 0;
        
        for(int i = 0 ; i < bits ; i++){
            int ind = 0;
            for(int j = 0 ; j < r  ; j++){
                if(binary[j][i] == '1')
                    no_of_ones[i][ind++] = j+1;
            }
        }
        for(int i = bits-1 ; i >= 0 ; i--){ 
        int count = 0;
            for(int j = 0 ;j < r ; j++){
                if(no_of_ones[i][j] != 0){
                    if(hamming[no_of_ones[i][j] - 1] == '1')
                        count++;
                }
            }
            if(count%2 == 0)
                hamming[no_of_ones[i][0]-1] = '0';
            else
                hamming[no_of_ones[i][0]-1] = '1'; 
        }
        String ans = new String();
        for(int i = hamming.length-1 ; i >= 0 ; i--)
            ans+= Character.toString(hamming[i]);
        System.out.println("No of hamming bits : "+bits);
        System.out.println("Generated Hamming COde : "+ans);
    }
}