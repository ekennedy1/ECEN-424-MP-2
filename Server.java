import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String argv[]) throws Exception{
        String clientSentence;
        boolean stop = true;

        do{
            System.out.println("Welcome to the Server designed by Group 12.");
            System.out.println("Enter a vaild server command in the form of /Server <Port number> <Max clients> to open a port or Q to quit.");

            Scanner sc= new Scanner(System.in); 
            String str = sc.nextLine();
            String strParts[] = str.split(" ");

            switch(strParts[0]){
                case "/Server":
                case "/server":
                    if(strParts.length < 3){
                        System.out.println("Please enter a valid Command");
                        break; 
                    }
                    int portNumber;
                    int clientNumber;
                    try{ 
                        portNumber = Integer.parseInt(strParts[1]);
                        clientNumber = Integer.parseInt(strParts[2]); 
                    }
                    catch(NumberFormatException er){
                        System.out.println("Please enter a valid Command");
                        break; 
                    }

                    ServerSocket welcomeSocket = new ServerSocket(portNumber);

                    for(int i = 1; i <= clientNumber; i++){
                        Socket connectionSocket = welcomeSocket.accept();
                        Multithreading Thread = new Multithreading(i, connectionSocket, portNumber);
                        Thread.start();
                    }


                    /* 
                    ServerSocket welcomeSocket = new ServerSocket(portNumber);
                    Socket connectionSocket = welcomeSocket.accept();

                    System.out.println("Client Connected to port " + portNumber);

                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                    clientSentence = inFromClient.readLine();
                    System.out.println("Client: " + clientSentence);
                    */

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

        /*
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();

        System.out.println("Client Connected");

        InputStreamReader in = new InputStreamReader(connectionSocket.getInputStream());
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        
        clientSentence = inFromClient.readLine();
        System.out.println("Client: " + clientSentence);

        */
    }
}
    
