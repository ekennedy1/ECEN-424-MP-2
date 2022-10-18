import java.io.*;
import java.net.*;


public class Client {
    

    public static void main(String argv[]) throws Exception{
        Socket connectionSocket = new Socket("localhost", 6789);

        PrintWriter pr = new PrintWriter(connectionSocket.getOutputStream());
        pr.println("hello");
        pr.flush();

    }
}
