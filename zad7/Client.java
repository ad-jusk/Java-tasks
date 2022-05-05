import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String IP = "127.0.0.1";
    private Socket socket;
    private BufferedReader input;
    private PrintWriter out;

    public Client(Socket socket) throws IOException{
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        int time = 0;
        String message;

        while(socket.isConnected()){
            System.out.println("Enter message: ");
            message = scanner.nextLine();
            if(message.equals("q") || socket.isClosed()){
                if(out != null){
                    out.println(message);
                }
                System.out.println("No response!");
                break;
            }
            System.out.println("Enter time: ");
            try{
                time = getTime(scanner);
            }
            catch(WrongInputException e){
                continue;
            }
            out.println(message);
            out.println(time);
        }
        scanner.close();
        closeResources();
    }

    public void waitForAnswer(){
        new Thread(new Runnable() {
            @Override
            public void run(){
                String message = null;
                
                while(socket.isConnected()){
                    try{
                        message = input.readLine();
                        if(message == null){
                            break;
                        }
                        System.out.println("Received message: " + message);
                    }
                    catch(IOException e){
                        break;
                    }
                }
                closeResources();
            }
        }).start();
    }

    public int getTime(Scanner scanner) throws WrongInputException{
        int time = 0;
        try{
            time = Integer.parseInt(scanner.nextLine());
        }
        catch(Exception e){
            throw new WrongInputException();
        }
        if(time <= 0){
            throw new WrongInputException();
        }
        return time;
    }

    public void closeResources(){
        try{
            if(socket != null)
                socket.close();
            if(input != null)
                input.close();
            if(out != null)
                out.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        boolean scanning = true;
        int tries = 0;
        while(scanning){
            try{
                socket = new Socket(IP, Server.PORT);
                scanning = false;
            }
            catch(ConnectException e){
                if(tries == 5){
                    System.out.println("Cannot connect to server");
                    return;
                }
                tries++;
                System.out.println("Can't connect to server. Waiting...");
                Thread.sleep(2000);
            }
        }
        System.out.println("Connected to server!");

        Client client = null;
        try{
            client = new Client(socket);
        }
        catch(IOException e){
            client.closeResources();
            return;
        }
        client.waitForAnswer(); 
        client.sendMessage();   
    }
}