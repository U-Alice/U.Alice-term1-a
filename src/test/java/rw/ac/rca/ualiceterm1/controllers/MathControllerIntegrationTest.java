package rw.ac.rca.ualiceterm1.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import rw.ac.rca.ualiceterm1.payload.ApiResponse;
import rw.ac.rca.ualiceterm1.utils.TestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
   public void testDoMath() {
        DoMathRequest dto = new DoMathRequest(1,2, "+");
        ResponseEntity<ApiResponse> response = restTemplate.postForEntity("/do-math",  TestUtil.createHttpEntity(dto), ApiResponse.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
