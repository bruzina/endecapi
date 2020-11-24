package cz.bruzina.endecapi;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CryptControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void crypt() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/crypt").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
