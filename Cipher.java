//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;

public class Cipher {
    private long _key;

    public Cipher(long key) {
        this._key = key;
    }

    public long getKey() {
        return this._key;
    }

    public List<Character> encrypt(List<Character> cleartext) {
        return null;
    }

    public List<Character> decrypt(List<Character> ciphertext) {
        return null;
    }

    public static Cipher create(String cipherName, long key) {
        Cipher cipher = null;
        if (cipherName.equals("Caesar")) {
            cipher = new CaesarCipher(key);
        } else {
            if (!cipherName.equals("Substitution")) {
                throw new RuntimeException("Cipher.create(): Unknown cipher " + cipherName);
            }

            cipher = new SubstitutionCipher(key);
        }

        return (Cipher)cipher;
    }
}
