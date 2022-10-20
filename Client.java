import java.io.*;
import java.net.*;
import java.util.*;


public class Client {
    

    public static void main(String argv[]) throws Exception{
        Socket connectionSocket = new Socket("localhost", 6789);

        Scanner sc= new Scanner(System.in); 
        String str = sc.nextLine();

        PrintWriter pr = new PrintWriter(connectionSocket.getOutputStream());
        pr.println(str);
        pr.flush();

    }
}
