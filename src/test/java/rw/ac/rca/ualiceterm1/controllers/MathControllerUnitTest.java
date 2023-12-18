package rw.ac.rca.ualiceterm1.controllers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import rw.ac.rca.ualiceterm1.payload.ApiResponse;
import static org.junit.Assert.assertEquals;

public class MathControllerUnitTest extends AbstractTest{

    @Before
    public void setUp(){
        super.setUp();
    }


    @Test
    public void doMath() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5.0, 3.0, "+"); // Adjust values as needed

        String uri = "/do-math";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(String.valueOf(doMathRequest))).andReturn();
        int status  = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        ApiResponse content = ApiResponse.success(mvcResult.getResponse().getContentAsString());
        ApiResponse apiResponse = ApiResponse.success(10);
        assertEquals(content.getCalcResponse(), apiResponse.getCalcResponse());
    }
}
