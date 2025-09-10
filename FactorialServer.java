import java.net.*;

public class FactorialServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(8000);
        byte[] buf = new byte[100];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);

        String numStr = new String(dp.getData(), 0, dp.getLength());
        int n = Integer.parseInt(numStr);

        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;

        byte[] sendData = String.valueOf(fact).getBytes();
        DatagramPacket reply = new DatagramPacket(sendData, sendData.length, dp.getAddress(), dp.getPort());
        ds.send(reply);

        ds.close();
    }
}
