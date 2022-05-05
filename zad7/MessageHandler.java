import java.io.IOException;
import java.io.PrintWriter;

public class MessageHandler implements Runnable {

    private PrintWriter printWriter;
    private String message;
    private int time;
    public MessageHandler(PrintWriter printWriter, String message, int time) throws IOException{
        this.printWriter = printWriter;
        this.message = message;
        this.time = time;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(time * 1000);
            printWriter.println(message);
        }
        catch(InterruptedException e){
            printWriter.println("Responding for message \" " + message + "\" was interrupted");
            return;
        }
    }
    
}
