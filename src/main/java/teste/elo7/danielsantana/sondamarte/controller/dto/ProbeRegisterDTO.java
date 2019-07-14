package teste.elo7.danielsantana.sondamarte.controller.dto;

import teste.elo7.danielsantana.sondamarte.domain.mars.Position;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import javax.validation.constraints.NotNull;

public class ProbeRegisterDTO {

    @NotNull
    private Position position;

    @NotNull
    private WindRose windDirection;

    public ProbeRegisterDTO(@NotNull Position position, @NotNull WindRose windDirection) {
        this.position = position;
        this.windDirection = windDirection;
    }

    public Position getPosition() {
        return position;
    }

    public WindRose getWindDirection() {
        return windDirection;
    }

}
