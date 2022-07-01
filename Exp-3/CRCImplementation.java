import java.io.*;
import java.util.*;

class CRCImplementation {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the message to be transmited:");
        String message = br.readLine();
        System.out.println("Enter the generator polynomial:");
        String generator = br.readLine();
        String mSent = message;
        mSent = message + div(message, generator);
        System.out.println("The transmitted message is:" + " " + mSent);
    }

    static String div(String num1, String num2) {
        int pointer = num2.length();
        String dividend = num1.substring(0, pointer);
        String remainder = "";

        for (int i = 0; i < num2.length(); i++) {
            if (dividend.charAt(i) == num2.charAt(i)) {
                remainder = remainder + "0";
            } else {
                remainder = remainder + "1";
            }
        }

        while (pointer < num1.length()) {
            if (remainder.charAt(0) == '0') {
                remainder = remainder.substring(1, remainder.length());
                remainder = remainder + String.valueOf(num1.charAt(pointer));
                pointer++;
            }

            dividend = remainder;
            remainder = "";

            for (int i = 0; i < num2.length(); i++) {
                if (dividend.charAt(i) == num2.charAt(i)) {
                    remainder = remainder + "0";
                } else {
                    remainder = remainder + "1";
                }
            }
        }
        return remainder.substring(1, remainder.length());
    }
}
