package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

import static org.junit.Assert.*;

public class SouthStepCalculatorTest {

    private SouthStepCalculator southStepCalculator;

    @Before
    public void setUp() {
        southStepCalculator = new SouthStepCalculator();
    }

    @Test
    public void shouldReturnMinusOneAtYAxis() {
        Position resultPosition = southStepCalculator.calculateStep(new Position(1, 2));
        Position expectedPosition = new Position(1, 1);
        assertEquals(expectedPosition, resultPosition);
    }

}