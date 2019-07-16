package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

import static org.junit.Assert.assertEquals;

public class EastStepCalculatorTest {

    private EastStepCalculator eastStepCalculator;

    @Before
    public void setUp() {
        eastStepCalculator = new EastStepCalculator();
    }

    @Test
    public void shouldReturnPlusOneAtXAxis() {
        Position resultPosition = eastStepCalculator.calculateStep(new Position(1, 2));
        Position expectedPosition = new Position(2, 2);
        assertEquals(expectedPosition, resultPosition);
    }

}