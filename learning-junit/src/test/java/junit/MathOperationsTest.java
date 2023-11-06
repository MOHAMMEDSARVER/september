package junit;

import org.example.junit.MathOperations;
import org.junit.jupiter.api.*;

public class MathOperationsTest {
    MathOperations obj;

    @BeforeEach
    void init() {
        System.out.println("Before Each Method");
        obj = new MathOperations();
    }

    @AfterEach
    void destroy() {
        System.out.println("After Each Method");
    }

    @BeforeAll
    static void initall() {
        System.out.println("Before all method..");
    }

    @AfterAll
    static void teardown() {
        System.out.println("after all method..");
    }

    @Test
    void gcdOfTwoEqualNumbers() {
        int actual = obj.gcd(10, 10);
        int expected = 10;
        Assertions.assertEquals(expected, actual);
        System.out.println("gcd of two equal method---------------------------------------");
    }

    @Test
    void gcdOfTwoDifferentNumbers() {
        int actual = obj.gcd(10, 20);
        int expected = 10;
        Assertions.assertEquals(expected, actual);
        System.out.println("gcd of two different numbers------------------------");
    }

    @Test
    void gcdWithPrimeNumbers() {
        int actual = obj.gcd(13, 17);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
        System.out.println("gcd of Prime numbers-------------------------------");
    }

    @Test
    void gcdWithZero() {
        int actual = obj.gcd(0, 13);
        int expected = 13;
        Assertions.assertEquals(expected, actual);
        System.out.println("gcd with zero--------------------------------------");
    }

    @Test
    void generatePrimeInRangeTest() {
        int[] actual = obj.generatePrime(10, 20);
        int[] expexted = {11, 13, 17, 19};
        Assertions.assertArrayEquals(expexted, actual);
        System.out.println("generate prime in range test-----------------------------");
    }

    @Test
    void generatePrimeWithLowerBoundMaxAndUpperBoundMin(){
        int[] actual= obj.generatePrime(20,10);
        int[] expected={};
        Assertions.assertArrayEquals(expected,actual);
        System.out.println("generate Prime with lower bound max na upper bound min----------");
    }

    @Test
    void generatePrimeWith0T1(){
        int[] actual= obj.generatePrime(0,1);
        int[] expected={};
        Assertions.assertArrayEquals(expected,actual);
        System.out.println("generate Prime With 0 to 1---------------------------------------");
    }

    @DisplayName("Generate prime numbers with negative numbers")
    @Test
    @Disabled
    void generatePrimeWithNegativeNumbers(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> obj.generatePrime(-10,-1));
        System.out.println("generate prime with negative numbers-------------------------------");
    }

    @Test
    public void divTest(){
        Assertions.assertThrows(ArithmeticException.class,()-> obj.div(10,0));
        //Assertions.assertEquals(1,()->obj.div(10,10));
        System.out.println("division by zero------------------------");
    }

}
