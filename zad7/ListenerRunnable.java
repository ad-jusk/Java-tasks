import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenerRunnable implements Runnable{
    private ServerSocket listener;
    private boolean exit;
    public static int numberOfClients;

    public ListenerRunnable(ServerSocket serverSocket){
        this.listener = serverSocket;
        this.exit = false;
        numberOfClients = 1;
    }

    @Override
    public void run(){
        Socket client;
        ClientRunnable clientRunnable;
        while(true){
            System.out.println("Waiting for client " + numberOfClients + "...");
            try {
                client = listener.accept();
            } catch (IOException e) {
                if(this.exit){
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
            
            Thread clientThread = new Thread(clientRunnable);
            clientThread.start();
        }
    }
    public void stop(){
        this.exit = true;
    }
    
}