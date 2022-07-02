import java.io.*;
import java.util.*;
import java.net.*;

class Resolution {
    public static void main(String args[]) throws Exception {
        InetAddress i;
        try {
            i = InetAddress.getLocalHost();
            System.out.println("The current IP address is:" + " " + i.getHostAddress());
            NetworkInterface n = NetworkInterface.getByInetAddress(i);
            byte[] mac = n.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < mac.length; j++) {
                sb.append(String.format("%02X%s", mac[j], (j < mac.length - 1) ? "-" : ""));
            }
            System.out.println("The MAC address is:" + " " + sb.toString());
        } catch (UnknownHostException e) {
            System.out.println("The host could not be resolved");
        } catch (SocketException e) {
            System.out.println(e);
        }

    }
}
