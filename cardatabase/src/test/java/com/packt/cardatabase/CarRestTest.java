package com.packt.cardatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Auth Test")
    public void testAuthentication() throws Exception {
        // 올바른 자격 증명으로 인증 테스트
        this.mockMvc
            .perform(post("/login")
                .content("{\"username\":\"admin\",\"password\":\"admin\"}")
                .header(HttpHeaders.CONTENT_TYPE, "application/json"))
            .andDo(print())
            .andExpect(status().isOk()); // 응답 상태 OK 확인
    }

}
