package junit;

import org.example.junit.FactorialOfNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FactorialOfNumberTest {
    private List<Integer> in = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    private List<Integer> out = new ArrayList<>(Arrays.asList(1, 1, 2, 6, 24, 120, 720));

    FactorialOfNumber f = new FactorialOfNumber();

    @TestFactory
    Stream<DynamicTest> factorial() {
        return in.stream()
                .map(num ->
                        DynamicTest.dynamicTest("Test Factorial of " + num, () -> {
                            int expectedIndex = in.indexOf(num);
                            Assertions.assertEquals(out.get(expectedIndex), f.fact(num));
                        }));
    }
}
