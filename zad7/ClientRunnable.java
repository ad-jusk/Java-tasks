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
                    clientMessage = in.readLine();
                    if(this.clientMessage.equals("q")){
                        System.out.println("Client " + this.clientIndex + " is out!");
                        ListenerRunnable.numberOfClients--;
                        break;
                    }
                    clientTime = Integer.parseInt(in.readLine());
                    wait(clientTime * 1000);
                    out.println(this.clientMessage);   
                }
            }
            catch(IOException e){
                return;
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
    public Socket getClient() {
        return client;
    }

    
}