package cz.bruzina.endecapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CaesarTest {

    @Test
    public void setShiftInRange() {
        Caesar caesar = new Caesar();
        String[] params = { "10" };
        caesar.setParams(params);

        int expected = 10;
        int result = Integer.parseInt(caesar.getParams()[0]);

        assertEquals(expected, result);
    }

    @Test
    public void setShiftOutOfRange() {
        Caesar caesar = new Caesar();
        String[] params = { "36" };
        caesar.setParams(params);

        int expected = 10;
        int result = Integer.parseInt(caesar.getParams()[0]);

        assertEquals(expected, result);
    }

    @Test
    public void setNegativeShift() {
        Caesar caesar = new Caesar();
        String[] params = { "-10" };
        caesar.setParams(params);

        int expected = 16;
        int result = Integer.parseInt(caesar.getParams()[0]);

        assertEquals(expected, result);
    }

    @Test
    public void encryptTextWithDefaultShift() {
        Caesar caesar = new Caesar();

        String expected = "defabcDEFABC,123";
        String payload = "abcxyzABCXYZ,123";
        String result = caesar.encrypt(payload);

        assertEquals(expected, result);
    }

    @Test
    public void decryptTextWithDefaultShift() {
        Caesar caesar = new Caesar();

        String expected = "abcxyzABCXYZ,123";
        String payload = "defabcDEFABC,123";
        String result = caesar.decrypt(payload);

        assertEquals(expected, result);
    }

    @Test
    public void encryptTextWithShiftTen() {
        Caesar caesar = new Caesar();
        String[] params = { "10" };
        caesar.setParams(params);

        String expected = "klmhijKLMHIJ,123";
        String payload = "abcxyzABCXYZ,123";
        String result = caesar.encrypt(payload);

        assertEquals(expected, result);
    }

    @Test
    public void decryptTextWithShiftTen() {
        Caesar caesar = new Caesar();
        String[] params = { "10" };
        caesar.setParams(params);

        String expected = "abcxyzABCXYZ,123";
        String payload = "klmhijKLMHIJ,123";
        String result = caesar.decrypt(payload);

        assertEquals(expected, result);
    }

    @Test
    public void rot13() {
        Caesar caesar = new Caesar();
        String[] params = { "13" };
        caesar.setParams(params);

        String expected = "abcxyzABCXYZ,123";
        String payload = "nopklmNOPKLM,123";
        String result = caesar.decrypt(payload);

        assertEquals(expected, result);
    }

}
