import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRunnable implements Runnable{

    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private String clientMessage;
    private int clientTime;
    private int clientIndex;

    public ClientRunnable(Socket socket, int index) throws IOException{
        client = socket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        clientIndex = index;
    }

    @Override
    public void run(){
        try{
            while(true){
                clientMessage = in.readLine();
                if(clientMessage.equals("q")){
                    System.out.println("Client " + clientIndex + " is out!");
                    ListenerRunnable.numberOfClients--;
                    break;
                }
                clientTime = Integer.parseInt(in.readLine());

                System.out.println("Server has client's " + clientIndex  + " message and is waiting " + clientTime + " seconds");

                Thread thread = new Thread(new MessageHandler(out, clientMessage, clientTime));
                thread.start();
            }
        }
        catch(IOException e){
            if(ListenerRunnable.exit){
                return;
            }
            e.printStackTrace();
        } 
        finally{
            out.close();
            try {
                in.close();
                client.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getClient() {
        return client;
    }

    
}