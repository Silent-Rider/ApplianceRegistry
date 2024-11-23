package com.example.appliance_registry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ApplianceRegistryApplicationTests {

	@Test
	void postApplianceTest() {
		RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/registry/appliances";
        String jsonBody = null;
        try{
            jsonBody = Files.readString(Path.of("appliance.json"));
        } catch(IOException e){}
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("Response: " + response.getBody());
	}

}
