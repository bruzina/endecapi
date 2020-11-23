package cz.bruzina.endecapi;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/crypt")
    public Crypt crypt(@RequestParam(value = "decrypt", defaultValue = "false") String decrypt,
            @RequestParam(value = "cipher", defaultValue = "caesar") String cipher,
            @RequestParam(value = "shift", defaultValue = "3") String shift,
            @RequestParam(value = "payload") String payload) throws Exception {
        if (cipher.equals("caesar")) {
            return new Caesar(counter.incrementAndGet(), decrypt.equals("true"), cipher, Integer.parseInt(shift),
                    payload);
        } else {
            throw new Exception(String.format("Unknown cipher %s", cipher));
        }
    }
}
