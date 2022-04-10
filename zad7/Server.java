import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        

        ServerSocket listener = new ServerSocket(PORT);
        ListenerRunnable listenerRunnable = new ListenerRunnable(listener);
        
        System.out.println("Press 'q' to shut down server");

        Thread listenerThread = new Thread(listenerRunnable);
        listenerThread.start();

        Scanner scanner = new Scanner(System.in);
        
        while(true){
            String x = scanner.nextLine();
            if(x.equals("q")){
                break;
            }
            else{
                System.out.println("Wrong command! Press 'q' to shut down server");
            }
        }
        System.out.println("Shutting down server...");
        listenerRunnable.stop();
        scanner.close();
        listener.close();
        return;
    }
}