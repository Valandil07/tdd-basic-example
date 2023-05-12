package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */

    @Test
    public void ensureSixPlusZeroEqualsSix() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        int expectedResult = 6;
        int firstOperand = 6;
        int secondOperand = 0;
        int result;

        result = new Calculator().sum(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureZeroPlusSixEqualsSix() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        int expectedResult = 6;
        int firstOperand = 0;
        int secondOperand = 6;
        int result;

        result = new Calculator().sum(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureZeroPlusZeroEqualsZero() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        int expectedResult = 0;
        int firstOperand = 0;
        int secondOperand = 0;
        int result;

        result = new Calculator().sum(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureIntegerMinimumPlusMinusOneThrowsException() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        Calculator calculator = new Calculator();

        int firstOperand = Integer.MIN_VALUE;
        int secondOperand = -1;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.sum(firstOperand, secondOperand));
    }

    @Test
    public void ensureIntegerMaximumPlusOneThrowsException() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        Calculator calculator = new Calculator();

        int firstOperand = Integer.MAX_VALUE;
        int secondOperand = 1;

        assertThrows(IllegalArgumentException.class,
                () -> calculator.sum(firstOperand, secondOperand));
    }

    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureSixPlusSevenEqualsThirteen() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int secondOperand = 7;
        int expectedResult = 13;
        int result = 0;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureThreeMinusFourEqualsMinusOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = 4;
        int expectedResult = -1;
        int result = 0;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinusSevenMinusMinusFourEqualsEleven() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 7;
        int secondOperand = -4;
        int expectedResult = 11;
        int result = 0;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }


    @Test
    public void ensureMultiplicationThreeMultipliedByZeroEqualsZero() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 3;
        int secondOperand = 0;
        int expectedResult = 0;
        int result;

        // Act
        result = new Calculator().multiply(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMultiplicationZeroMultipliedByThreeEqualsZero() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 0;
        int secondOperand = 3;
        int expectedResult = 0;
        int result;

        // Act
        result = new Calculator().multiply(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMultiplicationZeroMultipliedByZeroEqualsZero() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 0;
        int secondOperand = 0;
        int expectedResult = 0;
        int result;

        // Act
        result = new Calculator().multiply(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMultiplicationTwelveMultipliedByTwelveEqualsHundredFourtyFour() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 12;
        int secondOperand = 12;
        int expectedResult = 144;
        int result;

        // Act
        result = new Calculator().multiply(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSixDividedByMinusTwoEqualsMinusThree() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 6;
        int secondOperand = -2;
        int expectedResult = -3;
        int result;

        // Act
        result = new Calculator().divide(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSevenDividedByZeroThrowsException() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        Calculator calculator = new Calculator();

        int firstOperand = 7;
        int secondOperand = 0;

        assertThrows(ArithmeticException.class,
                () -> calculator.divide(firstOperand, secondOperand));
    }

    @Test
    public void ensureFactorialOfFiveEqualsOneHundredAndTwenty() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 5;
        int expectedResult = 120;
        int result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureFactorialOfZeroEqualsOne() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 0;
        int expectedResult = 1;
        int result;

        // Act
        result = new Calculator().factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureFactorialOfMinusTwoThrowsException() {
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        Calculator calculator = new Calculator();

        int firstOperand = -2;

        assertThrows(ArithmeticException.class,
                () -> calculator.factorial(firstOperand));
    }
}



