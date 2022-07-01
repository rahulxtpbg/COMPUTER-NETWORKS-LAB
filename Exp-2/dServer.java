import java.io.*;
import java.util.*;
import java.net.*;

class Server {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the hostname:");
        String host = br.readLine();
        try {
            InetAddress i = InetAddress.getByName(host);
            System.out.println("Hosname is:" + " " + i.getHostName());
            System.out.println("IP address of the given hostname is:" + " " + i.getHostAddress());
        } catch (Exception e) {
            System.out.println("The hostname could not be resolved");
        }
    }
}
