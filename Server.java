import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String argv[]) throws Exception{
        String clientSentence;
        boolean stop = true;

        do{
            System.out.println("Welcome to the Server designed by Group 12.");

            Scanner sc= new Scanner(System.in); 
            String str = sc.nextLine();
            String strParts[] = str.split(" ");

            switch(strParts[0]){
                case "/Server":
                case "/server":
                
                    break;

                case "Q":
                case "q":

                    stop = false;
                    break;

                default:

                    System.out.println("Please enter a valid Command");

                    break;
            }

        }while(stop);

        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();

        System.out.println("Client Connected");

        InputStreamReader in = new InputStreamReader(connectionSocket.getInputStream());
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        
        clientSentence = inFromClient.readLine();
        System.out.println("Client: " + clientSentence);
    }
}
    
