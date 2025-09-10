import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Client: " + msg);
                }
            } catch (Exception e) { }
        }).start();

        
        String msg;
        while ((msg = console.readLine()) != null) {
            out.println(msg);
        }

        s.close(); ss.close();
    }
}
