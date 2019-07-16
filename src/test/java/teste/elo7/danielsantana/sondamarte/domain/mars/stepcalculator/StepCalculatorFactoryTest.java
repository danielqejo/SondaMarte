package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import static org.junit.Assert.*;

public class StepCalculatorFactoryTest {

    private StepCalculatorFactory stepCalculatorFactory;

    @Before
    public void setUp() {
        this.stepCalculatorFactory = new StepCalculatorFactory();
    }

    @Test
    public void shouldReturnNorthStepCalculator() {
        StepCalculator createdStepCalculator = stepCalculatorFactory.getStepFor(WindRose.N);
        assertTrue(createdStepCalculator instanceof NorthStepCalculator);
    }

    @Test
    public void shouldReturnSouthStepCalculator() {
        StepCalculator createdStepCalculator = stepCalculatorFactory.getStepFor(WindRose.S);
        assertTrue(createdStepCalculator instanceof SouthStepCalculator);
    }

    @Test
    public void shouldReturnWestStepCalculator() {
        StepCalculator createdStepCalculator = stepCalculatorFactory.getStepFor(WindRose.W);
        assertTrue(createdStepCalculator instanceof WestStepCalculator);
    }

    @Test
    public void shouldReturnEastStepCalculator() {
        StepCalculator createdStepCalculator = stepCalculatorFactory.getStepFor(WindRose.E);
        assertTrue(createdStepCalculator instanceof EastStepCalculator);
    }

    @Test
    public void shouldThrowIllegalArgumentWhenWindRoseIsNull() {
        try {
            stepCalculatorFactory.getStepFor(null);
            fail("Should've thrown exception");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }
}