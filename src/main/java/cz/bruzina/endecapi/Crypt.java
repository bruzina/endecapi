package cz.bruzina.endecapi;

public class Crypt {

    private final long id;
    private final String payload;
    private final Cipher cipher;
    private final Boolean decrypt;
    private String result;

    public Crypt(long id, Cipher cipher, String payload, Boolean decrypt) {
        this.id = id;
        this.cipher = cipher;
        this.payload = payload;
        this.decrypt = decrypt;
        this.result = decrypt ? cipher.decrypt(payload) : cipher.encrypt(payload);
    }

    public long getId() {
        return id;
    }

    public String getCipher() {
        return cipher.getName();
    }

    public String[] getParams() {
        return cipher.getParams();
    }

    public Boolean getDecrypt() {
        return decrypt;
    }

    public String getPayload() {
        return payload;
    }

    public String getResult() {
        return result;
    }

}
