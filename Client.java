import java.net.*;
import java.util.*;
import java.io.*;

class Client{
    public static void main(String... args) throws Exception {
        final String host = "localhost";
        final int port = 1064;
        Socket s = new Socket(host,port);

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Na to send to server :");
        String str = sc.nextLine();
        
        OutputStreamWriter osr = new OutputStreamWriter(s.getOutputStream());
        PrintWriter p = new PrintWriter(osr);
        p.println(str);
        osr.flush();
        System.out.println("Name sent"+str);
        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader b = new BufferedReader(isr);
        String str1 = b.readLine();
        System.out.println(str1);

        System.out.println("Server Disconnected");
    }
}