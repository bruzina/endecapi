package cz.bruzina.endecapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/crypt")
    public Crypt crypt(@RequestParam(value = "encrypt", defaultValue = "true") String encrypt,
            @RequestParam(value = "cipher", defaultValue = "caesar") String cipherName,
            @RequestParam(value = "params", defaultValue = "") String[] params,
            @RequestParam(value = "payload", defaultValue = "The quick brown fox jumps over the lazy dog :-)") String payload)
            throws Exception {
        Cipher cipher = CipherFactory.getCipher(cipherName);
        if (cipher == null) {
            throw new Exception(String.format("Unknown cipher %s", cipherName));
        }

        cipher.setParams(params);
        return new Crypt(counter.incrementAndGet(), cipher, payload, encrypt.equals("true"));
    }

}
