package cz.bruzina.endecapi;

public class CipherFactory {

    public static Cipher getCipher(String cipherName) {
        if (cipherName == null) {
            return null;
        }
        if (cipherName.equalsIgnoreCase("CAESAR")) {
            return new Caesar();
        } // space for new ciphers

        return null;
    }

}
