package rw.ac.rca.ualiceterm1.services;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rw.ac.rca.ualiceterm1.exceptions.InvalidOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class MathOperatorTest {

    private final MathOperator mathOperator;

    public MathOperatorTest(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @DataProvider
    private static final Object[][] getData(){
        return new Object[][]{{1,2,"+", 3.0}};
    }

    @Test(dataProvider = "getData")
    public void shouldPerformOperation(double operand1, double operand2, String operation, double computedResult) throws InvalidOperationException {
        double result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(result, computedResult);
    }


}
