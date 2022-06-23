import java.io.*;
import java.util.*;
import java.net.*;

class Sender {
    public static void main(String args[]) throws Exception {
        Sender s = new Sender();
        s.run();
    }

    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no: of frames to be sent:");
        int n = sc.nextInt();
        Socket s = new Socket("localhost", 9999);
        PrintStream ps = new PrintStream(s.getOutputStream());
        for (int i = 0; i < n; i++) {
            if (i == n) {
                ps.println("Exit");
                break;
            }
            System.out.println("Frame" + " " + i + " " + "has been sent");
            ps.println(i);

            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ack=br.readLine();
            if (ack!=null){
                System.out.println("Acknowledgement received");
                Thread.sleep(3000);
            }
            else{
                ps.println(i);
            }
        }
    }
}
