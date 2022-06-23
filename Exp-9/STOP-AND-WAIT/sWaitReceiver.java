import java.io.*;
import java.util.*;
import java.net.*;

class Receiver {
    public static void main(String args[]) throws Exception {
        Receiver r = new Receiver();
        r.run();
    }

    public void run() throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());

        String temp = "Temp message";
        String str = "Exit";

        while (temp.compareTo(str) != 0) {
            temp = br.readLine();
            if (temp.compareTo(str) == 0) {
                break;
            }
            System.out.println("Frame" + " " + temp + " " + "received");
            ps.println("Received");
        }

        System.out.println("All frames received successfully");
    }
}
