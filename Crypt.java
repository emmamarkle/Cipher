//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Crypt {
    public Crypt() {
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            showUsageAndExit();
        }

        String cipherName = args[0];
        String operation = args[1];
        long key = -1L;

        try {
            key = Long.parseLong(args[2]);
        } catch (NumberFormatException var8) {
            showUsageAndExit();
        }

        Cipher cipher = Cipher.create(cipherName, key);
        List<Character> source = read();
        List<Character> result = null;
        if (operation.equals("encrypt")) {
            result = cipher.encrypt(source);
        } else if (operation.equals("decrypt")) {
            result = cipher.decrypt(source);
        } else {
            showUsageAndExit();
        }

        write(result);
    }

    private static void showUsageAndExit() {
        System.err.printf("USAGE: java Crypt <cipher [Caesar|Substitution]>\n                  <operation [encrypt|decrypt]\n                  <key>\n");
        System.exit(1);
    }

    private static List<Character> read() {
        InputStream in = System.in;
        List<Character> l = new LinkedList();

        while(true) {
            int readValue = 0;

            try {
                readValue = in.read();
            } catch (IOException var4) {
                System.err.println("ERROR: Failed reading");
                System.exit(1);
            }

            if (readValue == -1) {
                return l;
            }

            l.add((char)readValue);
        }
    }

    private static void write(List<Character> l) {
        OutputStream out = System.out;
        Iterator var2 = l.iterator();

        while(var2.hasNext()) {
            char c = (Character)var2.next();

            try {
                out.write(c);
            } catch (IOException var6) {
                System.err.println("ERROR: Failed writing");
                System.exit(1);
            }
        }

        try {
            out.close();
        } catch (IOException var5) {
            System.err.println("WARNING: Failed to close output. Data may have been lost.");
        }

    }
}
