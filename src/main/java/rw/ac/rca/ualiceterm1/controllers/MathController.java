package rw.ac.rca.ualiceterm1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.ualiceterm1.dtos.DoMathRequest;
import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;
import rw.ac.rca.ualiceterm1.payload.ApiResponse;
import rw.ac.rca.ualiceterm1.services.MathService;

@RestController
@RequestMapping()
public class MathController {
    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping
   public ResponseEntity<ApiResponse>  doMath(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        double calcResponse =  mathService.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation());
        return ResponseEntity.ok(ApiResponse.success(calcResponse));
    }
}
