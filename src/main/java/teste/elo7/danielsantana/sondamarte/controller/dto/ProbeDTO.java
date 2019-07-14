package teste.elo7.danielsantana.sondamarte.controller.dto;

import teste.elo7.danielsantana.sondamarte.domain.mars.Position;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;

public class ProbeDTO {

    private String name;
    private Integer xPosition;
    private Integer yPosition;
    private String windDirection;

    public ProbeDTO(SpaceProbe spaceProbe, Position position) {
        this.name = spaceProbe.getName();
        this.xPosition = position.getxAxis();
        this.yPosition = position.getyAxis();
        this.windDirection = spaceProbe.getDirection().toString();
    }

    public String getName() {
        return name;
    }

    public Integer getxPosition() {
        return xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public String getWindDirection() {
        return windDirection;
    }

}
