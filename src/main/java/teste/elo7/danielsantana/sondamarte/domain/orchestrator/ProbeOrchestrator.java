package teste.elo7.danielsantana.sondamarte.domain.orchestrator;

import teste.elo7.danielsantana.sondamarte.domain.orchestrator.exception.ProbeAlreadyExistsException;
import teste.elo7.danielsantana.sondamarte.domain.orchestrator.exception.ProbeNotFoundException;
import teste.elo7.danielsantana.sondamarte.domain.plateau.Plateau;
import teste.elo7.danielsantana.sondamarte.domain.probe.Direction;
import teste.elo7.danielsantana.sondamarte.domain.probe.Position;
import teste.elo7.danielsantana.sondamarte.domain.probe.Probe;
import teste.elo7.danielsantana.sondamarte.utils.ApplicationConfigurations;

import java.util.ArrayList;
import java.util.List;

public class ProbeOrchestrator {

    private Plateau plateau;
    private List<Probe> probes;

    public ProbeOrchestrator(Plateau plateau) {
        this.plateau = plateau;
        this.probes = new ArrayList<>();
    }

    public void createProbeOnPlateau(String probeName, int xPosition, int yPosition, Direction direction) {
        String upperCaseProbeName = toUpperCase(probeName);
        try{
            Probe probe = findProbe(upperCaseProbeName);
            throw new ProbeAlreadyExistsException("Probe named " + probe.getName() + "already exists on this Plateau");
        } catch (ProbeNotFoundException e) {
            Position position = new Position(xPosition, yPosition);
            Probe probe = new Probe(upperCaseProbeName, position, direction);
            probes.add(probe);
        }
    }

    public void moveProbe(String probeName){
        Probe foundProbe = findProbe(toUpperCase(probeName));
        foundProbe.move();
    }

    public void rotateProbeLeft(String probeName) {
        Probe foundProbe = findProbe(toUpperCase(probeName));
        foundProbe.rotateLeft();
    }

    public void rotateProbeRight(String probeName) {
        Probe foundProbe = findProbe(toUpperCase(probeName));
        foundProbe.rotateRight();
    }

    private String toUpperCase(String probeName) {
        return probeName.toUpperCase(ApplicationConfigurations.LOCALE);
    }

    private Probe findProbe(String probeName) throws ProbeNotFoundException {
        return probes.stream()
                .filter(probe -> probe.getName().equals(probeName))
                .findFirst()
                .orElseThrow(() -> new ProbeNotFoundException("Probe named " + probeName + " does not exist on Plateau"));
    }

}
