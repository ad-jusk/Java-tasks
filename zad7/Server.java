import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 9090;
    private static ExecutorService numberOfThreads = Executors.newFixedThreadPool(5);
    private static ArrayList<ClientThread> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        
        ServerSocket listener = new ServerSocket(PORT);
        
        while(true){
            System.out.println("Waiting for client...");
            Socket client = listener.accept();
            System.out.println("Client is in!");
            ClientThread clientThread = new ClientThread(client);
            clients.add(clientThread);
            numberOfThreads.execute(clientThread);
        }
    }
}
