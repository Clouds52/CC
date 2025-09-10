import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            Hello stub = (Hello) Naming.lookup("rmi://localhost:5000/hello");
            System.out.println("Server says: " + stub.sayHello());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
