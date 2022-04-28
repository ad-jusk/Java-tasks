import java.util.Scanner;
import java.io.IOException;

public class Server {
    public static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        
        ListenerRunnable listenerRunnable = new ListenerRunnable();
        
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
        return;
    }
}