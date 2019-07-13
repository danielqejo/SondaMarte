package teste.elo7.danielsantana.sondamarte.domain.mars;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.BoundaryViolationException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.CollisionDetectedException;
import teste.elo7.danielsantana.sondamarte.domain.mars.exception.SpaceProbeNotFoundException;
import teste.elo7.danielsantana.sondamarte.domain.probe.SpaceProbe;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import java.util.Map;

import static org.junit.Assert.*;

public class MarsTest {

    private final String TEST_1_PROBE_NAME = "Test 1";
    private final String TEST_2_PROBE_NAME = "Test 2";

    private final String COLLISION_DID_NOT_HAPPENED = "Collision didn't happened.";
    private final String BOUNDARY_VIOLATION_MESSAGE = "Should've thrown BoundaryViolationException";

    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(new Position(5, 5));
    }

    @Test
    public void shouldAddProbe() {
        SpaceProbe expectedProbe = createTest1Probe();
        Position expectedPosition = new Position(3, 2);
        mars.add(expectedProbe, expectedPosition);
        Map<SpaceProbe, Position> mapProbes = mars.getMapProbes();
        Position actualPosition = mapProbes.get(expectedProbe);
        assertNotNull(actualPosition);
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void shouldMoveProbe() {
        SpaceProbe expectedProbe = createTest1Probe();
        Position position = new Position(3, 2);
        mars.add(expectedProbe, position);

        mars.move(expectedProbe.getName());

        Position expectedPosition = new Position(3, 3);
        Position actualPosition = mars.getMapProbes().get(expectedProbe);
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void shouldThrowCollisionDetectedExceptionWhenTryingToMoveIntoAnotherProbesPosition() {
        SpaceProbe test1Probe = createTest1Probe();
        SpaceProbe test2Probe = new SpaceProbe(TEST_2_PROBE_NAME, WindRose.N);
        Position positionProbe1 = new Position(3, 3);
        Position positionProbe2 = new Position(3, 2);
        mars.add(test1Probe, positionProbe1);
        mars.add(test2Probe, positionProbe2);

        try{
            mars.move(test2Probe.getName());
            fail(COLLISION_DID_NOT_HAPPENED);
        } catch (CollisionDetectedException e) {
            Map<SpaceProbe, Position> mapProbes = mars.getMapProbes();
            assertEquals(positionProbe1,mapProbes.get(test1Probe));
            assertEquals(positionProbe2,mapProbes.get(test2Probe));
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void shouldThrowCollisionDetectedExceptionWhenTryingToAddIntoAnotherProbesPosition() {
        SpaceProbe test1Probe = createTest1Probe();
        SpaceProbe test2Probe = new SpaceProbe(TEST_2_PROBE_NAME, WindRose.N);
        Position position = new Position(3, 2);
        mars.add(test1Probe, position);

        try {
            mars.add(test2Probe, position);
            fail(COLLISION_DID_NOT_HAPPENED);
        }catch (CollisionDetectedException e) {
            Map<SpaceProbe, Position> mapProbes = mars.getMapProbes();
            assertNull(mapProbes.get(test2Probe));
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void shouldThrowBoundaryViolationWhenTryingToMoveOutOfBounds() {
        SpaceProbe test1Probe = createTest1Probe();
        Position positionProbe1 = new Position(5, 5);
        mars.add(test1Probe, positionProbe1);

        try{
            mars.move(test1Probe.getName());
            fail(BOUNDARY_VIOLATION_MESSAGE);
        } catch (BoundaryViolationException e) {
            Map<SpaceProbe, Position> mapProbes = mars.getMapProbes();
            assertEquals(positionProbe1, mapProbes.get(test1Probe));
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void shouldThrowBoundaryViolationWhenTryingToAddOutOfBounds() {
        SpaceProbe test1Probe = createTest1Probe();
        Position positionProbe1 = new Position(7, 7);

        try{
            mars.add(test1Probe, positionProbe1);
            fail(BOUNDARY_VIOLATION_MESSAGE);
        } catch (BoundaryViolationException e) {
            Map<SpaceProbe, Position> mapProbes = mars.getMapProbes();
            assertNull(mapProbes.get(test1Probe));
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void shouldThrowProbeNotFoundExceptionWhenWantedProbeNotYetAdded(){
        try{
            mars.move(TEST_1_PROBE_NAME);
            fail("Should've thrown SpaceProbeNotFoundException");
        } catch (SpaceProbeNotFoundException e) {
            assertNotNull(e.getMessage());
        }
    }

    private SpaceProbe createTest1Probe(){
        return new SpaceProbe(TEST_1_PROBE_NAME, WindRose.N);
    }

}