import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class Client {

    private static final String IP = "127.0.0.1";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        boolean scanning = true;

        while(scanning){
            try{
                socket = new Socket(IP, Server.PORT);
                scanning = false;
            }
            catch(ConnectException e){
                System.out.println("Can't connect to server. Waiting...");
                Thread.sleep(2000);
            }
        }
        System.out.println("Connected to server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader inputKeyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = "";
        int time = 0;

        while(true){
            System.out.println("Enter message (q to quit):");
            message = inputKeyboard.readLine();
            if(message.equals("q")){
                out.println(message);
                break;
            }
            System.out.println("Enter time:");
            try{
                time = getTime(inputKeyboard);
            }
            catch(WrongInputException e){
                continue;
            }
            out.println(message);
            out.println(time);

            String response = input.readLine();
            if(response == null){
                System.out.println("No response, maybe server is down?");
                break;
            }
            System.out.println(response);
        }
        socket.close();
        input.close();
        inputKeyboard.close();
        out.close();
    }

    public static int getTime(BufferedReader reader) throws WrongInputException{
        int time = 0;
        try{
            time = Integer.parseInt(reader.readLine());
        }
        catch(Exception e){
            throw new WrongInputException();
        }
        if(time <= 0){
            throw new WrongInputException();
        }
        return time;
    }


}