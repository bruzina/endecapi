package cz.bruzina.endecapi;

public class Caesar implements Crypt {

    private final long id;
    private final Boolean decrypt;
    private final String cipher;
    private final Integer shift;
    private final String payload;
    private String result;

    public Caesar(long id, Boolean decrypt, String cipher, Integer shift, String payload) {
        this.id = id;
        this.decrypt = decrypt;
        this.cipher = cipher;
        this.shift = shift;
        this.payload = payload;

        int normShift = decrypt ? 26 - shift : shift;
        normShift = normShift % 26;
        normShift = normShift < 0 ? 26 - normShift : normShift;

        int len = payload.length();
        this.result = "";
        for (int i = 0; i < len; i++) {
            char c = (char) (payload.charAt(i) + normShift);
            if (c > 'z')
                this.result += (char) (payload.charAt(i) - (26 - normShift));
            else
                this.result += (char) (payload.charAt(i) + normShift);
        }
    }

    public long getId() {
        return id;
    }

    public Boolean getDecrypt() {
        return decrypt;
    }

    public String getCipher() {
        return cipher;
    }

    public Integer getShift() {
        return shift;
    }

    public String getPayload() {
        return payload;
    }

    public String getResult() {
        return result;
    }
}
