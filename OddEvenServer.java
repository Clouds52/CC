import java.net.*;

public class OddEvenServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(7000);
        byte[] buf = new byte[100];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);

        String numStr = new String(dp.getData(), 0, dp.getLength());
        int num = Integer.parseInt(numStr);

        String result = (num % 2 == 0) ? "Even" : "Odd";
        byte[] sendData = result.getBytes();

        DatagramPacket reply = new DatagramPacket(sendData, sendData.length, dp.getAddress(), dp.getPort());
        ds.send(reply);

        ds.close();
    }
}
