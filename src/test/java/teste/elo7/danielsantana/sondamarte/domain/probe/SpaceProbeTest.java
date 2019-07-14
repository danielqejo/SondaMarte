package teste.elo7.danielsantana.sondamarte.domain.probe;

import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.probe.command.LeftRotateCommand;
import teste.elo7.danielsantana.sondamarte.domain.probe.command.RightRotateCommand;

import static org.junit.Assert.assertEquals;

public class SpaceProbeTest {

    private static final String PROBE_NAME = "Test";

    @Test
    public void shouldProperlyPointWhenLeftRotationOccurs() {
        SpaceProbe spaceProbe = new SpaceProbe(PROBE_NAME,  WindRose.E);
        LeftRotateCommand leftRotateCommand = new LeftRotateCommand();
        spaceProbe.rotate(leftRotateCommand);
        assertEquals(WindRose.N, spaceProbe.getDirection());
        spaceProbe.rotate(leftRotateCommand);
        assertEquals(WindRose.W, spaceProbe.getDirection());
        spaceProbe.rotate(leftRotateCommand);
        assertEquals(WindRose.S, spaceProbe.getDirection());
        spaceProbe.rotate(leftRotateCommand);
        assertEquals(WindRose.E, spaceProbe.getDirection());
    }

    @Test
    public void shouldProperlyPointWhenRightRotationOccurs() {
        SpaceProbe spaceProbe = new SpaceProbe(PROBE_NAME, WindRose.E);
        RightRotateCommand rightRotateCommand = new RightRotateCommand();
        spaceProbe.rotate(rightRotateCommand);
        assertEquals(WindRose.S, spaceProbe.getDirection());
        spaceProbe.rotate(rightRotateCommand);
        assertEquals(WindRose.W, spaceProbe.getDirection());
        spaceProbe.rotate(rightRotateCommand);
        assertEquals(WindRose.N, spaceProbe.getDirection());
        spaceProbe.rotate(rightRotateCommand);
        assertEquals(WindRose.E, spaceProbe.getDirection());
    }

}