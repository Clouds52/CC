import java.net.*;
import java.io.*;

public class FactorialClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number: ");
        String num = br.readLine();
        byte[] data = num.getBytes();

        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8000);
        ds.send(dp);

        byte[] buf = new byte[100];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        ds.receive(reply);

        System.out.println("Server: Factorial = " + new String(reply.getData(), 0, reply.getLength()));
        ds.close();
    }
}
