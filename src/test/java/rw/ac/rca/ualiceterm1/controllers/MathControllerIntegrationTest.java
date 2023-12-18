package rw.ac.rca.ualiceterm1.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import rw.ac.rca.ualiceterm1.payload.ApiResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(MathController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTest {
    private static RestTemplate restTemplate;

    @Test
    void testSaveItem() {
        DoMathRequest dto = new DoMathRequest(1,2, "+");

        ResponseEntity<ApiResponse> response = restTemplate.exchange("/do-math", HttpMethod.POST, dto, ApiResponse.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
