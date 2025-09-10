import java.net.*;
import java.io.*;

public class PrimeClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader sr = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.print("Enter number: ");
        pw.println(br.readLine());

        System.out.println("Server: " + sr.readLine());

        s.close();
    }
}
