package teste.elo7.danielsantana.sondamarte.domain.probe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceProbeTest {

    private static final String PROBE_NAME = "Test";

    @Test
    public void shouldProperlyPointWhenLeftRotationOccurs() {
        SpaceProbe spaceProbe = new SpaceProbe(PROBE_NAME,  WindRose.E);
        spaceProbe.rotateLeft();
        assertEquals(WindRose.N, spaceProbe.getDirection());
        spaceProbe.rotateLeft();
        assertEquals(WindRose.W, spaceProbe.getDirection());
        spaceProbe.rotateLeft();
        assertEquals(WindRose.S, spaceProbe.getDirection());
        spaceProbe.rotateLeft();
        assertEquals(WindRose.E, spaceProbe.getDirection());
    }

    @Test
    public void shouldProperlyPointWhenRightRotationOccurs() {
        SpaceProbe spaceProbe = new SpaceProbe(PROBE_NAME, WindRose.E);
        spaceProbe.rotateRight();
        assertEquals(WindRose.S, spaceProbe.getDirection());
        spaceProbe.rotateRight();
        assertEquals(WindRose.W, spaceProbe.getDirection());
        spaceProbe.rotateRight();
        assertEquals(WindRose.N, spaceProbe.getDirection());
        spaceProbe.rotateRight();
        assertEquals(WindRose.E, spaceProbe.getDirection());
    }

}