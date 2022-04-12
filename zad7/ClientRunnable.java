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
    //private boolean exit;

    public ClientRunnable(Socket socket, int index) throws IOException{
        this.client = socket;
        this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        this.out = new PrintWriter(this.client.getOutputStream(), true);
        this.clientIndex = index;
    }

    @Override
    public void run(){
        synchronized(this){
            try{
                while(true){
                    this.clientMessage = in.readLine();
                    if(this.clientMessage.equals("q")){
                        System.out.println("Client " + this.clientIndex + " is out!");
                        ListenerRunnable.numberOfClients--;
                        System.out.println("Waiting for client " + ListenerRunnable.numberOfClients + "...");
                        break;
                    }
                    this.clientTime = Integer.parseInt(in.readLine());
                    wait(this.clientTime * 1000);
                    out.println(this.clientMessage);   
                }
            }
            catch(IOException e){
                System.err.println("IOexception in Client " + this.clientIndex + " Thread!");
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally{
                this.out.close();
                try {
                    this.in.close();
                    this.client.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
}