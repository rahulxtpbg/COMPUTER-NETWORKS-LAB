import java.io.*;
import java.util.*;

public class CRCImplementation {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the message to be transmitted:");

        String message = br.readLine();
        System.out.println("\nThe message to be transmitted is:");
        System.out.println(message);

        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\nEnter your choice:\n1.Implement CRC-12\n2.Implement CRC-16\n3.Implement CRC-CCIP");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                String generator = "1100000001111";
                System.out.println("The generator polynomial is:");
                System.out.println(generator);
                String code = message;
                code = message + div(code, generator);
                System.out.println("The transmitted message is:" + code);
                break;

            case 2:
                String generatorr = "11000000000000101";
                System.out.println("The generator polynomial is:");
                System.out.println(generatorr);
                String codee = message;
                codee = message + div(codee, generatorr);
                System.out.println("The transmitted message is:" + codee);
                break;

            case 3:
                String generatorrr = "10001000000100001";
                System.out.println("The generator polynomial is:");
                System.out.println(generatorrr);
                String codeee = message;
                codeee = message + div(codeee, generatorrr);
                System.out.println("The transmitted message is:" + codeee);
                break;
        }
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
