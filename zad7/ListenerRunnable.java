import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ListenerRunnable implements Runnable{
    private ServerSocket listener;
    public static boolean exit;
    public static int numberOfClients;
    private ArrayList<ClientRunnable> clients;

    public ListenerRunnable() throws IOException{
        listener = new ServerSocket(Server.PORT);
        exit = false;
        numberOfClients = 1; //Also is a client index
        clients = new ArrayList<>();
    }

    @Override
    public void run(){
        Socket client;
        ClientRunnable clientRunnable;
        while(true){
            try {
                client = listener.accept();
            } 
            catch (IOException e) {
                if(exit){
                    return;
                }
                System.out.println("Failed to accept client!");
                continue;
            }
            try {
                clientRunnable = new ClientRunnable(client, numberOfClients);
            } 
            catch (IOException e) {
                System.out.println("Failed to create thread for client!");
                continue;
            }
            System.out.println("Client " + numberOfClients + " is in!");
            numberOfClients++;
            clients.add(clientRunnable);
            
            Thread clientThread = new Thread(clientRunnable);
            clientThread.start();
        }
    }
    public void stop() throws IOException{
        exit = true;
        for(ClientRunnable c : clients){
            c.getClient().close();
        }
        listener.close();
    }
    
}