package teste.elo7.danielsantana.sondamarte.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import teste.elo7.danielsantana.sondamarte.domain.probe.command.RotateCommand;
import teste.elo7.danielsantana.sondamarte.controller.dto.PlanetProbesDTO;
import teste.elo7.danielsantana.sondamarte.controller.dto.ProbeRegisterDTO;
import teste.elo7.danielsantana.sondamarte.domain.mars.Mars;
import teste.elo7.danielsantana.sondamarte.domain.mars.Position;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;
import teste.elo7.danielsantana.sondamarte.utils.ApplicationConfigurations;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;

@RestController
@RequestMapping("planet")
public class PlanetController {

    private final String MARS = "MARS";

    private Mars mars;

    @PostMapping("{planetName}")
    public ResponseEntity registerPlanet(UriComponentsBuilder uriBuilder,
                                         @PathVariable @NotNull String planetName,
                                         @RequestBody @NotNull Position position){
        if(isNotMars(planetName))
            return badRequestResponseWith("Currently only the planet Mars can be created");

        if(!isMarsNull()){
            return conflictResponseWith("Mars can only be created once.");
        }
        mars = new Mars(position);
        URI uri = uriBuilder.path("planet/{planetName}").buildAndExpand(planetName).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{planetName}/probe")
    public ResponseEntity getAllProbesOn(@PathVariable @NotNull String planetName) {
        if(isNotMars(planetName))
            return badRequestResponseWith("Only mars can be searched for.");
        if(isMarsNull())
            return conflictResponseWith("Register planet mars before searching for its probes");
        return ResponseEntity.ok(new PlanetProbesDTO(planetName, mars.getMapProbes()));
    }

    private boolean isMarsNull() {
        return mars == null;
    }

    @PutMapping("{planetName}/probe/{probeName}")
    public ResponseEntity addProbeToPlanet(UriComponentsBuilder uriBuilder,
                                           @PathVariable @NotNull String planetName,
                                           @PathVariable @NotNull @NotEmpty(message="Probe Name cannot be empty") String probeName,
                                           @RequestBody @Validated ProbeRegisterDTO registerDTO){
        if(isNotMars(planetName))
            return badRequestResponseWith("You can only register a probe at mars.");

        if(isMarsNull())
            return conflictResponseWith("Register planet mars before adding a probe.");
        SpaceProbe spaceProbe = new SpaceProbe(probeName, registerDTO.getWindDirection());
        mars.add(spaceProbe, registerDTO.getPosition());
        URI uri = uriBuilder.path("/planet/{planetName}/probe/{probeName}")
                .buildAndExpand(planetName, probeName)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("{planetName}/probe/{probeName}/move")
    public ResponseEntity moveProbe(@PathVariable @NotNull String planetName,
                                    @PathVariable @NotNull @NotEmpty(message="Probe Name cannot be empty") String probeName) {
        if(isNotMars(planetName))
            return badRequestResponseWith("Currently you can only move a probe at mars.");

        if(isMarsNull())
            return conflictResponseWith("Register planet mars before moving a probe");

        mars.move(probeName);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{planetName}/probe/{probeName}/rotate/{rotateCommand}")
    public ResponseEntity moveProbe(@PathVariable @NotNull String planetName,
                                    @PathVariable @NotNull @NotEmpty(message="Probe Name cannot be empty") String probeName,
                                    @PathVariable @NotNull @Size(min=1, max=1, message = "RotateCommand should be L or R (Left, Right)") String rotateCommand) {
        if(isNotMars(planetName))
            return badRequestResponseWith("Currently you can only rotate a probe at mars.");

        if(isMarsNull())
            return conflictResponseWith("Register planet mars before rotating a probe");

        mars.rotate(probeName, rotateCommand);

        return ResponseEntity.ok().build();
    }

    private ResponseEntity<String> conflictResponseWith(String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(message);
    }

    private ResponseEntity badRequestResponseWith(String message) {
        return ResponseEntity.badRequest().body(message);
    }

    private boolean isNotMars(String planetName) {
        return !MARS.equals(planetName.toUpperCase(ApplicationConfigurations.LOCALE));
    }

}
