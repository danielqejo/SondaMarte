package teste.elo7.danielsantana.sondamarte.domain.mars;

import teste.elo7.danielsantana.sondamarte.domain.mars.exception.BoundaryViolationException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.CollisionDetectedException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.SpaceProbeNotFoundException;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mars {

    private final Position boundaries;
    private Map<SpaceProbe, Position> mapProbes;

    public Mars(Position boundaries) {
        this.boundaries = boundaries;
        this.mapProbes = new HashMap<>();
    }

    public Map<SpaceProbe, Position> getMapProbes() {
        return Collections.unmodifiableMap(mapProbes);
    }

    public void add(SpaceProbe probe, Position position) {
        checkPossibilityFor(position);
        mapProbes.put(probe, position);
    }

    public void move(String spaceProbeName) throws SpaceProbeNotFoundException {
        SpaceProbe wantedProbe = new SpaceProbe(spaceProbeName);

        SpaceProbe probe = mapProbes.keySet()
                .stream()
                .filter(wantedProbe::equals)
                .findFirst()
                .orElseThrow(() -> new SpaceProbeNotFoundException("Add a SpaceProbe to Mars before moving it."));

        Position position = mapProbes.get(probe);
        Position newPosition = createNewPositionWith(position, probe.getDirection());

        checkPossibilityFor(newPosition);

        mapProbes.put(probe, newPosition);
    }

    private void checkPossibilityFor(Position newPosition) {
        checkBoundariesFor(newPosition);
        checkForOtherProbesAt(newPosition);
    }

    private void checkForOtherProbesAt(Position newPosition) {
        if(mapProbes.containsValue(newPosition)){
            throw new CollisionDetectedException("Another Space Probe is in the position " + newPosition);
        }
    }

    private void checkBoundariesFor(Position newPosition) {
        if(newPosition.getxAxis() > boundaries.getxAxis() || newPosition.getxAxis() < 0 ||
                newPosition.getyAxis() > boundaries.getyAxis() || newPosition.getyAxis() < 0){
            throw new BoundaryViolationException("Space Probe violated Mars Boundaries " + boundaries);
        }
    }

    private Position createNewPositionWith(Position position, WindRose direction) { //TODO this should probably be refactored
        if(WindRose.N.equals(direction)) {
            int y = position.getyAxis() + 1;
            return new Position(position.getxAxis(), y);
        }else if(WindRose.E.equals(direction)) {
            int x = position.getxAxis() + 1;
            return new Position(x, position.getyAxis());
        } else if(WindRose.S.equals(direction)) {
            int y = position.getxAxis() - 1;
            return new Position(position.getxAxis(), y);
        } else {
            int x = position.getxAxis() - 1;
            return new Position(x, position.getyAxis());
        }
    }

}
