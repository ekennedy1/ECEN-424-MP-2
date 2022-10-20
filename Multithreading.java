import java.io.*;
import java.net.*;
import java.util.*;  

public class Multithreading extends Thread {

    private int threadNumber;
    private int portNumber;
    private Socket connectionSocket;

    public Multithreading(int threadNumber, Socket connectionSocket, int portNumber){
        this.threadNumber = threadNumber;
        this.connectionSocket = connectionSocket;
        this.portNumber = portNumber;
    }

    public void run() {
        String clientSentence;

        try{ 
            System.out.println("Client Connected to port " + portNumber + " from thread number " + threadNumber);

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            clientSentence = inFromClient.readLine();
            System.out.println("Client: " + clientSentence);
        }
        catch(IOException ie){
           
        }

    }
}
