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
        Random r = new Random();
        int rNum = r.nextInt(10) + 1;

        String temp = "Temp message";
        String str = "Exit";

        for (int i = 0; i < rNum; i++) {
            if (i == rNum) {
                ps.println("null");
                break;
            }
            temp = br.readLine();
            System.out.println("Frame" + " " + temp + " " + "received");
            ps.println("Received");
        }
    }
}
