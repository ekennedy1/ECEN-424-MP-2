import java.io.*;
import java.net.*;
import java.util.*;


public class ClientB {
    

    public static void main(String argv[]) throws Exception{
        String serverSentence;

        boolean stop = true;
        boolean stop2 = true;
        int txN = 0;

        do{
            System.out.println("Welcome to the Client designed by Group 12.");
            System.out.println("Enter a vaild command in the form of /Client <server ip> <server port> to connect to a active server or Q to quit.");

            Scanner sc= new Scanner(System.in); 
            String str = sc.nextLine();
            String strParts[] = str.split(" ");

            switch(strParts[0]){
                case "/Client":
                case "/client":
                    if(strParts.length < 3){
                        System.out.println("Please enter a valid Command");
                        break; 
                    }
                    int portNumber;
                    try{ 
                        portNumber = Integer.parseInt(strParts[2]);
                    }
                    catch(NumberFormatException er){
                        System.out.println("Please enter a valid Command");
                        break; 
                    }

                    if(strParts[2] == "localhost"){
                        System.out.println("Please enter a valid Command");
                        break;
                    }

                    Socket connectionSocket = new Socket("localhost", portNumber);

                    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    serverSentence = inFromServer.readLine();
                    System.out.println("Server: " + serverSentence);

                    //start here (fix loop logic)
                    do{
                        Scanner sc2= new Scanner(System.in); 
                        String str2 = sc2.nextLine();
                        String strParts2[] = str2.split(" ");

                        try{ 
                            txN = Integer.parseInt(strParts2[1]);
                            
                            PrintWriter pr = new PrintWriter(connectionSocket.getOutputStream());
                            pr.println(str2);
                            pr.flush();

                            stop2 = false;
                        }
                        catch(NumberFormatException er){
                            System.out.println("Please enter a valid Command");
                        }


                    }while(stop2);

                    String bufferTX = "";

                    for(int i = 0; i < txN; i++){
                        BufferedReader inFromServer2 = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                        serverSentence = inFromServer2.readLine();
                        bufferTX = bufferTX + serverSentence;

                    }

                    System.out.print(bufferTX);
         

                    connectionSocket.close();

                    stop = false;
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

    }
}
