package junit;

import org.example.junit.EmiCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmiCalculatorTest {
        @Test
        void testCalculator(){
            EmiCalculator emiCalculator=new EmiCalculator();
            double emi=emiCalculator.calculateEmi(850000,15,27);
            double expected=37287;
            Assertions.assertEquals(expected,emi);
        }
}
