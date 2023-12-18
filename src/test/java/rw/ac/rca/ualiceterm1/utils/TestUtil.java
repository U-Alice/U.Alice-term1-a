package rw.ac.rca.ualiceterm1.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;

public class TestUtil {
    public static HttpEntity<DoMathRequest> createHttpEntity(DoMathRequest doMathRequest) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<DoMathRequest> requestEntity = new HttpEntity<>(doMathRequest, headers);

        return requestEntity;
    }

}
