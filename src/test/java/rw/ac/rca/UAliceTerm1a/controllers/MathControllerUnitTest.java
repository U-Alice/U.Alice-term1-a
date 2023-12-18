package rw.ac.rca.UAliceTerm1a.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;

public class MathControllerUnitTest extends AbstractTest{

    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void doMath() throws Exception {
        String uri = "";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
    }
}
