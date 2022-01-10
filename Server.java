import java.net.*;
import java.io.*;
import java.math.*;

public class Server{
    public static void main(String... args) throws Exception {
        System.out.println("Server Started");
        int port = 1064;
        ServerSocket server_socket = new ServerSocket(port);
        System.out.println("Server is wqaiting for the client");
        Socket socket = server_socket.accept();
        System.out.println("Client connected to the server");
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader b = new BufferedReader(isr);
        String str = b.readLine();
        System.out.println("Recieved Name"+str);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter pw = new PrintWriter(osw);
        pw.println(str);
        pw.flush();
    }
}