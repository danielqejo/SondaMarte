package teste.elo7.danielsantana.sondamarte.domain.probe.command;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import static org.junit.Assert.assertEquals;

public class RightRotateCommandTest {

    private RightRotateCommand rightRotateCommand;

    @Before
    public void setUp(){
        rightRotateCommand = new RightRotateCommand();
    }

    @Test
    public void shouldRotate90DegreesClockWiseIntoWindRose() {
        WindRose rotate = rightRotateCommand.rotate(WindRose.W);
        assertEquals(WindRose.N, rotate);
        rotate = rightRotateCommand.rotate(WindRose.N);
        assertEquals(WindRose.E, rotate);
        rotate = rightRotateCommand.rotate(WindRose.E);
        assertEquals(WindRose.S, rotate);
        rotate = rightRotateCommand.rotate(WindRose.S);
        assertEquals(WindRose.W, rotate);
    }
}
