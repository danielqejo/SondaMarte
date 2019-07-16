package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

import static org.junit.Assert.*;

public class WestStepCalculatorTest {

    private WestStepCalculator westStepCalculator;

    @Before
    public void setUp() {
        westStepCalculator = new WestStepCalculator();
    }

    @Test
    public void shouldReturnMinusOneAtXAxis() {
        Position resultPosition = westStepCalculator.calculateStep(new Position(1, 2));
        Position expectedPosition = new Position(0, 2);
        assertEquals(expectedPosition, resultPosition);
    }

}