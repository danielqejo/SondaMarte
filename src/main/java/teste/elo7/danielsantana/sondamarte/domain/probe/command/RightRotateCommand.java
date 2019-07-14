package teste.elo7.danielsantana.sondamarte.domain.probe.command;

import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

public class RightRotateCommand implements RotateCommand{

    @Override
    public WindRose rotate(WindRose windRose) {
        return windRose.getNinetyDegreesClockWiseSibling();
    }

}
