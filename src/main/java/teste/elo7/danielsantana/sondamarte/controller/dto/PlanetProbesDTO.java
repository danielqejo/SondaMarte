package teste.elo7.danielsantana.sondamarte.controller.dto;

import teste.elo7.danielsantana.sondamarte.domain.mars.Position;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlanetProbesDTO {

    private String planet;
    private List<ProbeDTO> probes;

    public PlanetProbesDTO(String planetName, Map<SpaceProbe, Position> probePositionMap) {
        this.probes = new ArrayList<>();
        probePositionMap.forEach(
                (probe, position) -> this.probes.add(new ProbeDTO(probe, position))
        );
        this.planet = planetName;
    }

    public String getPlanet() {
        return planet;
    }

    public List<ProbeDTO> getProbes() {
        return probes;
    }

}
