package rw.ac.rca.ualiceterm1.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import static org.junit.Assert.assertEquals;

public class MathControllerUnitTest extends AbstractTest{

    @Before
    public void setUp(){
        super.setUp();
    }

    @Autowired
    public ObjectMapper objectMapper;
    @Test
    public void doMath() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5.0, 3.0, "+"); // Adjust values as needed
        String uri = "/do-math";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(doMathRequest))).andReturn();
        int status  = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
