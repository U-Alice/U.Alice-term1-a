package rw.ac.rca.ualiceterm1.services;

import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;

public interface MathOperator {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
