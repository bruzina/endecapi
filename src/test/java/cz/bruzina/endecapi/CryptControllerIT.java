package cz.bruzina.endecapi;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CryptControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getDefault() throws Exception {
        this.base = new URL("http://localhost:" + port + "/crypt");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody()).isEqualTo(
                "{\"id\":1,\"payload\":\"The quick brown fox jumps over the lazy dog :-)\",\"cipher\":\"caesar\",\"decrypt\":false,\"result\":\"Wkh txlfn eurzq ira mxpsv ryhu wkh odcb grj :-)\",\"params\":[\"3\"]}");
    }
}
