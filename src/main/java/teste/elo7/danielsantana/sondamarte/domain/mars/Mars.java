package teste.elo7.danielsantana.sondamarte.domain.mars;

import teste.elo7.danielsantana.sondamarte.domain.mars.exception.BoundaryViolationException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.CollisionDetectedException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.SpaceProbeAlreadyRegisteredException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.SpaceProbeNotFoundException;
import teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator.StepCalculator;
import teste.elo7.danielsantana.sondamarte.domain.mars.stepcalculator.StepCalculatorFactory;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;
import teste.elo7.danielsantana.sondamarte.domain.probe.command.RotateCommandFactory;
import teste.elo7.danielsantana.sondamarte.domain.probe.command.RotateCommandType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Mars {

    private final Position boundaries;
    private Map<SpaceProbe, Position> mapProbes;
    private final StepCalculatorFactory stepFactory;
    private final RotateCommandFactory rotateFactory;

    public Mars(Position boundaries) {
        this.boundaries = boundaries;
        this.mapProbes = new HashMap<>();
        this.stepFactory = new StepCalculatorFactory();
        this.rotateFactory = new RotateCommandFactory();
    }

    public Map<SpaceProbe, Position> getMapProbes() {
        return Collections.unmodifiableMap(mapProbes);
    }

    public void add(SpaceProbe probe, Position position)
            throws SpaceProbeAlreadyRegisteredException, BoundaryViolationException, CollisionDetectedException {
        checkExistenceOf(probe);
        checkPossibilityFor(position);
        mapProbes.put(probe, position);
    }

    private void checkExistenceOf(SpaceProbe probe) {
        if(find(probe).isPresent())
            throw new SpaceProbeAlreadyRegisteredException("Probe with name " + probe.getName() + " already registered");
    }

    public void rotate(String probe, RotateCommandType rotateCommandType) {
        SpaceProbe wantedSpaceProbe = new SpaceProbe(probe);
        SpaceProbe spaceProbe = find(wantedSpaceProbe, "Probe not yet registered to Mars");
        spaceProbe.rotate(rotateFactory.getRotateCommand(rotateCommandType));
    }

    public void move(String spaceProbeName)
            throws SpaceProbeNotFoundException, BoundaryViolationException, CollisionDetectedException {
        SpaceProbe wantedProbe = new SpaceProbe(spaceProbeName);

        SpaceProbe probe = find(wantedProbe,"Add a SpaceProbe to Mars before moving it.");

        Position position = mapProbes.get(probe);
        Position newPosition = createNewPositionWith(position, probe.getDirection());

        checkPossibilityFor(newPosition);

        mapProbes.put(probe, newPosition);
    }

    private Optional<SpaceProbe> find(SpaceProbe spaceProbe) {
        return mapProbes.keySet()
                .stream()
                .filter(spaceProbe::equals)
                .findFirst();
    }

    private SpaceProbe find(SpaceProbe spaceProbe, String notFoundMessage) {
        return find(spaceProbe).orElseThrow(() -> new SpaceProbeNotFoundException(notFoundMessage));
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

    private Position createNewPositionWith(Position position, WindRose direction) {
        StepCalculator stepCalculator = stepFactory.getStepFor(direction);
        return stepCalculator.calculateStep(position);
    }

}
