import java.net.*;
import java.io.*;

public class PrimeServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        int num = Integer.parseInt(br.readLine());
        boolean prime = true;
        if (num <= 1) prime = false;
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0) prime = false;

        pw.println(prime ? + num + "  " +  "is Prime" : num + "   " +  "is not Prime");

        s.close();
        ss.close();
    }
}
