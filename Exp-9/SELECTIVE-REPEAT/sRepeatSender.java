import java.io.*;
import java.util.*;
import java.net.*;

class Sender {
    public static void main(String args[]) throws Exception {
        Sender s = new Sender();
        s.run();
    }

    public void run() throws Exception {
        Socket s = new Socket("localhost", 9999);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Enter the no: of frames to be sent:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        dos.write(n);

        for (int i = 0; i < n; i++) {
            System.out.println("Input frame data:");
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            dos.write(a[i]);
        }

        int k = dis.read();
        System.out.println("Re-transmitting frame" + " " + (k + 1));
        dos.write(a[k]);

    }
}
