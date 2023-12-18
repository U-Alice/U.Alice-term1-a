package rw.ac.rca.ualiceterm1.services.impl;

import org.springframework.stereotype.Service;
import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;
import rw.ac.rca.ualiceterm1.services.MathService;


@Service
public class MathServiceImpl implements MathService {
    @Override
    public double doMath(double operand1, double operand2, String
            operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }

}
