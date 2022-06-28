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
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        int count = dis.read();
        System.out.println("Receiving" + " " + count + " " + "frames");
        int a[] = new int[count];

        for (int i = 0; i < count; i++) {
            a[i] = dis.read();
        }

        Random r = new Random();
        int rNum = r.nextInt(10) + 1;
        a[rNum] = -1;

        for (int i = 0; i < count; i++) {
            System.out.println(a[i]);
        }

        for (int i = 0; i < count; i++) {
            if (a[i] == -1) {
                System.out.println("Frame" + " " + (i + 1) + " " + "received incorrectly");
                System.out.println("Request re-transmission of frame" + " " + (i + 1));
                dos.write(i);
            }
        }

        a[rNum] = dis.read();
        System.out.println("Frame received is:" + " " + a[rNum]);
    }
}
