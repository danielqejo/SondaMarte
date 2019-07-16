package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

public class NorthStepCalculator implements StepCalculator {

    @Override
    public Position calculateStep(Position position) {
        return new Position(position.getxAxis(), position.getyAxis() + 1);
    }

}
