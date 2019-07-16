package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

import static org.junit.Assert.assertEquals;

public class NorthStepCalculatorTest {

    private NorthStepCalculator northStepCalculator;

    @Before
    public void setUp() {
        northStepCalculator = new NorthStepCalculator();
    }

    @Test
    public void shouldReturnPlusOneAtYAxis() {
        Position resultPosition = northStepCalculator.calculateStep(new Position(1, 2));
        Position expectedPosition = new Position(1, 3);
        assertEquals(expectedPosition, resultPosition);
    }

}