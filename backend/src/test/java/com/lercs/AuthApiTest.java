package com.lercs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc
class AuthApiTest {
 @Autowired MockMvc mvc;
 @Test void citizenCanRegisterAndReceiveJwt() throws Exception {
  String suffix=java.util.UUID.randomUUID().toString().substring(0,8);
  mvc.perform(post("/api/auth/register").contentType(MediaType.APPLICATION_JSON).content("{\"email\":\"citizen-"+suffix+"@example.org\",\"password\":\"safe-password-123\",\"fullName\":\"Test Citizen\",\"role\":\"ADMIN\"}"))
   .andExpect(status().isCreated()).andExpect(jsonPath("$.data.role").value("CITIZEN"));
  mvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON).content("{\"email\":\"citizen-"+suffix+"@example.org\",\"password\":\"safe-password-123\"}"))
   .andExpect(status().isOk()).andExpect(jsonPath("$.token").isNotEmpty()).andExpect(jsonPath("$.user.password").doesNotExist());
 }
 @Test void privateEndpointsRequireAuthentication()throws Exception{mvc.perform(get("/api/emergencies")).andExpect(status().isUnauthorized());}
}
