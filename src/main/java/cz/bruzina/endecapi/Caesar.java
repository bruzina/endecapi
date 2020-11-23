package cz.bruzina.endecapi;

public class Caesar implements Cipher {

    private Integer shift;

    public Caesar() {
    }

    public String getName() {
        return "caesar";
    }

    public void setParams(String[] params) {
        if (params.length == 0) {
            shift = 3;
        } else {
            int origShift = Integer.parseInt(params[0]);
            shift = normalizeShift(origShift);
        }
    }

    public String[] getParams() {
        String[] params = { Integer.toString(shift) };
        return params;
    }

    public String encrypt(String payload) {
        return shiftLetters(payload, shift);
    }

    public String decrypt(String payload) {
        return shiftLetters(payload, 26 - shift);
    }

    /**
     * Normalize shift to interval <0, 26)
     * 
     * @param origShift Original shift
     * @return Normalized shift
     */
    private Integer normalizeShift(Integer origShift) {
        Integer normShift = origShift % 26;
        return normShift < 0 ? 26 - normShift : normShift;
    }

    private String shiftLetters(String payload, int realShift) {
        int len = payload.length();
        String result = "";

        for (int i = 0; i < len; i++) {
            char oldChar = (char) (payload.charAt(i));
            char newChar = (char) (oldChar + realShift);
            if (oldChar >= 'a' && oldChar <= 'z') { // begin intentionally WET
                if (newChar > 'z') {
                    result += (char) (newChar - 26);
                } else {
                    result += newChar;
                }
            } else if (oldChar >= 'A' && oldChar <= 'Z') {
                if (newChar > 'Z') {
                    result += (char) (newChar - 26);
                } else {
                    result += newChar;
                } // end intentionally WET
            } else {
                result += oldChar;
            }
        }

        return result;
    }

}
