import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ListenerRunnable implements Runnable{
    private ServerSocket listener;
    private boolean exit;
    public static int numberOfClients;
    private ArrayList<ClientRunnable> clients;

    public ListenerRunnable(int port) throws IOException{
        listener = new ServerSocket(port);
        exit = false;
        numberOfClients = 1;
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
        for(ClientRunnable c : clients){
            c.getClient().close();
        }
        exit = true;
        listener.close();
    }
    
}