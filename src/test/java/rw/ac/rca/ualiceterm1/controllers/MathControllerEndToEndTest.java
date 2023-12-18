package rw.ac.rca.ualiceterm1.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;
import rw.ac.rca.ualiceterm1.payload.ApiResponse;
import rw.ac.rca.ualiceterm1.services.MathService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MathController.class)
public class MathControllerEndToEndTest{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private MathService mathService;

    @Test
    public void doMathTest() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(1,2, "+");
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/do-math")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mathRequest));
        this.mockMvc.perform(request)
                .andExpect(status().isOk());
    }

}
