import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 9090;
    
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(IP, PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader inputKeyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = "";
        int time = 0;

        while(true){
            System.out.println("Enter message:");
            message = inputKeyboard.readLine();
            if(message.equals("q")){
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
        return time;
    }


}