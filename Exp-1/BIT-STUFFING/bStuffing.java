import java.io.*;
import java.util.*;

class BitStuffing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the frame to be sent :");
        String frame = sc.nextLine();
        String stuffedFrame = " ";
        int count = 0;
        for (int i = 0; i < frame.length(); i++) {
            if (frame.charAt(i) == '1') {
                count = count + 1;
                stuffedFrame = stuffedFrame + frame.charAt(i);
            }

            else {
                count = 0;
                stuffedFrame = stuffedFrame + frame.charAt(i);
            }

            if (count == 5) {
                count = 0;
                stuffedFrame = stuffedFrame + '0';
            }
        }
        System.out.println("The stuffed frame is:" + stuffedFrame);
    }
}
