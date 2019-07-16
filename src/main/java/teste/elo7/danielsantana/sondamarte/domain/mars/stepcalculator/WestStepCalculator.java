package teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator;

import teste.elo7.danielsantana.sondamarte.domain.mars.Position;

public class WestStepCalculator implements StepCalculator {

    @Override
    public Position calculateStep(Position position) {
        return new Position(position.getxAxis() -1, position.getyAxis());
    }

}
