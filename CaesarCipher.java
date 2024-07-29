//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CaesarCipher extends Cipher {
    public CaesarCipher(long key) {
        super(key);
    }

    public List<Character> encrypt(List<Character> cleartext) {
        List<Character> ciphertext = new LinkedList();
        Iterator var3 = cleartext.iterator();

        while(var3.hasNext()) {
            char clearchar = (Character)var3.next();
            char cipherchar = (char)((int)(((long)clearchar + this.getKey()) % 256L));
            ciphertext.add(cipherchar);
        }

        return ciphertext;
    }

    public List<Character> decrypt(List<Character> ciphertext) {
        List<Character> cleartext = new LinkedList();
        Iterator var3 = ciphertext.iterator();

        while(var3.hasNext()) {
            char cipherchar = (Character)var3.next();
            char clearchar = (char)((int)(((long)cipherchar - this.getKey()) % 256L));
            cleartext.add(clearchar);
        }

        return cleartext;
    }
}
