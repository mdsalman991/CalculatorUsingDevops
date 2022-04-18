import calculator.calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    calculator calculator = new calculator();

    @Test
    public void factorialTruePositive(){
        assertEquals("factorial of a number for True Positive", 5040, calculator.factorial(7), DELTA);
        assertEquals("factorial of a number for True Positive", 120, calculator.factorial(5), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("factorial of a number for False Positive", 120, calculator.factorial(8), DELTA);
        assertNotEquals("factorial of a number for False Positive", 24, calculator.factorial(2), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("power for True Positive", 27, calculator.power(3, 3), DELTA);
        assertEquals("power for True Positive", 8, calculator.power(2, 3), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("power for False Positive", 6, calculator.power(4, 2), DELTA);
        assertNotEquals("power for False Positive", -7.3, calculator.power(2, 3), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("natural log for True Positive", 0, calculator.log(1), DELTA);
        assertEquals("natural log for True Positive", 2.302585092994046, calculator.log(10), DELTA);
    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("natural log for False Positive", 6, calculator.log(2.4), DELTA);
        assertNotEquals("natural log for False Positive", 7.3, calculator.log(2.1), DELTA);
    }

    @Test
    public void sqrootTruePositive(){
        assertEquals("square root for True Positive", 2, calculator.sqt(4), DELTA);
        assertEquals("square root for True Positive", 1, calculator.sqt(1), DELTA);
    }

    @Test
    public void sqrootFalsePositive(){
        assertNotEquals("square root for False Positive", 1, calculator.sqt(3), DELTA);
        assertNotEquals("square root for False Positive", 0, calculator.sqt(4), DELTA);

    }


}