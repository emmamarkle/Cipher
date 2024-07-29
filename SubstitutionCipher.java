//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SubstitutionCipher extends Cipher {
    public char[] init = new char[256];
    public char[] orig = new char[256];
    public char[] rand = new char[256];
    private char cipherChar;
    private char clearChar;

    public SubstitutionCipher(long key) {
        super(key);
        Random randomKey = new Random(this.getKey());

        int i;
        for(i = 0; i < this.init.length; ++i) {
            this.init[i] = (char)i;
        }

        for(i = 0; i < this.orig.length; ++i) {
            this.orig[i] = (char)i;
            this.rand[i] = (char)i;
        }

        for(i = 0; i < this.rand.length; ++i) {
            int j = randomKey.nextInt(256 - i);
            this.rand[i] = this.init[j];
            char temp = this.init[j];
            this.init[j] = this.init[255 - i];
            this.init[255 - i] = temp;
        }

    }

    public char[] getOrig() {
        return this.orig;
    }

    public char[] getRand() {
        return this.orig;
    }

    public int getRandPosition(char c) {
        int a = 0;

        for(int i = 0; i < this.rand.length; ++i) {
            if (c == this.rand[i]) {
                return i;
            }
        }

        return a;
    }

    public List<Character> encrypt(List<Character> cleartext) {
        List<Character> ciphertext = new LinkedList();
        Iterator var3 = cleartext.iterator();

        while(var3.hasNext()) {
            char clearChar = (Character)var3.next();

            for(int i = 0; i < this.orig.length; ++i) {
                if (clearChar == this.orig[i]) {
                    this.cipherChar = this.rand[i];
                }
            }

            ciphertext.add(this.cipherChar);
        }

        return ciphertext;
    }

    public List<Character> decrypt(List<Character> ciphertext) {
        List<Character> cleartext = new LinkedList();
        Iterator var3 = ciphertext.iterator();

        while(var3.hasNext()) {
            char cipherChar = (Character)var3.next();

            for(int i = 0; i < this.rand.length; ++i) {
                if (cipherChar == this.rand[i]) {
                    this.clearChar = this.orig[i];
                }
            }

            cleartext.add(this.clearChar);
        }

        return cleartext;
    }
}
