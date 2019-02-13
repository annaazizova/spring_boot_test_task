package com.aazizova.springboottesttask.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by Anna on 12.02.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private Controller controller;

    @Autowired
    private MockMvc mockMVC;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllProductsTest() throws Exception {
        User user = new User("username", "password", new ArrayList<SimpleGrantedAuthority>(){{add(new SimpleGrantedAuthority("USER_ROLE"));}});
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(user, null, "ROLE_ADMIN");
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        this.mockMVC.perform(get("/api/products"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNoToken_whenGetSecureRequest_thenUnauthorized() throws Exception {
        mockMVC.perform(get("/api/products"))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(status().isFound());
    }
}