import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable{

    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private String clientMessage;
    private int clientTime;

    public ClientThread(Socket socket) throws IOException{
        this.client = socket;
        this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        this.out = new PrintWriter(this.client.getOutputStream(), true);
    }

    @Override
    public void run(){
        synchronized(this){
            try{
                while(true){
                    this.clientMessage = in.readLine();
                    this.clientTime = Integer.parseInt(in.readLine());
                    wait(clientTime * 1000);
                    out.println(clientMessage);   
                }
            }
            catch(IOException e){
                System.err.println("IOexception in ClientThhread!");
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally{
                out.close();
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    
}