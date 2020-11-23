package cz.bruzina.endecapi;

public class Crypt {

    private final long id;
    private final String payload;
    private final Cipher cipher;
    private final Boolean encrypt;
    private String result;

    public Crypt(long id, Cipher cipher, String payload, Boolean encrypt) {
        this.id = id;
        this.cipher = cipher;
        this.payload = payload;
        this.encrypt = encrypt;
        this.result = encrypt ? cipher.encrypt(payload) : cipher.decrypt(payload);
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

    public Boolean getEncrypt() {
        return encrypt;
    }

    public String getPayload() {
        return payload;
    }

    public String getResult() {
        return result;
    }

}
