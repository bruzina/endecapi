package cz.bruzina.endecapi;

public class Caesar implements Cipher {

    private String[] params;
    private Integer shift;

    public Caesar() {
    }

    public String getName() {
        return "caesar";
    }

    public void setParams(String[] params) {
        this.params = params;
        shift = normalizeShift(Integer.parseInt(params[0])); // TODO: pottential coding standards violation
    }

    public String[] getParams() {
        return this.params;
    }

    public String encrypt(String payload) {
        return shiftLetters(payload, shift);
    }

    public String decrypt(String payload) {
        return shiftLetters(payload, 26 - shift);
    }

    private Integer normalizeShift(Integer shift) {
        Integer normShift = shift % 26;
        return normShift < 0 ? 26 - normShift : normShift;
    }

    private String shiftLetters(String payload, int realShift) {
        int len = payload.length();
        String result = "";

        for (int i = 0; i < len; i++) {
            char c = (char) (payload.charAt(i) + realShift);
            if (c > 'z') {
                result += (char) (payload.charAt(i) - (26 - realShift));
            } else {
                result += (char) (payload.charAt(i) + realShift);
            }
        }

        return result;
    }
}
