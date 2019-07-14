package teste.elo7.danielsantana.sondamarte.domain.probe;

import teste.elo7.danielsantana.sondamarte.domain.probe.command.RotateCommand;
import teste.elo7.danielsantana.sondamarte.utils.ApplicationConfigurations;

import java.util.Objects;

public class SpaceProbe {

    private final String name;
    private WindRose direction;

    public SpaceProbe(String name) {
        this(name, WindRose.N);
    }

    public SpaceProbe(String name, WindRose direction){
        this.name = name.toUpperCase(ApplicationConfigurations.LOCALE);
        this.direction = direction;
    }

    public WindRose getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public void rotate(RotateCommand rotateCommand) {
        this.direction = rotateCommand.rotate(this.direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceProbe spaceProbe = (SpaceProbe) o;
        return name.equals(spaceProbe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
