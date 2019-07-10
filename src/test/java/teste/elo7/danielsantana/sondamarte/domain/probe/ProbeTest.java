package teste.elo7.danielsantana.sondamarte.domain.probe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbeTest {

    private static final String PROBE_NAME = "Test";

    @Test
    public void shouldProperlyPointWhenLeftRotationOccurs() {
        Probe probe = new Probe(PROBE_NAME, new Position(0, 0), Direction.E);
        probe.rotateLeft();
        assertEquals(Direction.N, probe.getDirection());
        probe.rotateLeft();
        assertEquals(Direction.W, probe.getDirection());
        probe.rotateLeft();
        assertEquals(Direction.S, probe.getDirection());
        probe.rotateLeft();
        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void shouldProperlyPointWhenRightRotationOccurs() {
        Probe probe = new Probe(PROBE_NAME, new Position(0, 0), Direction.E);
        probe.rotateRight();
        assertEquals(Direction.S, probe.getDirection());
        probe.rotateRight();
        assertEquals(Direction.W, probe.getDirection());
        probe.rotateRight();
        assertEquals(Direction.N, probe.getDirection());
        probe.rotateRight();
        assertEquals(Direction.E, probe.getDirection());
    }

}