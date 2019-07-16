package teste.elo7.danielsantana.sondamarte.domain.probe.command;

import org.junit.Before;
import org.junit.Test;
import teste.elo7.danielsantana.sondamarte.domain.probe.WindRose;

import static org.junit.Assert.assertEquals;

public class LeftRotateCommandTest {

    private LeftRotateCommand leftRotateCommand;

    @Before
    public void setUp(){
        leftRotateCommand = new LeftRotateCommand();
    }

    @Test
    public void shouldRotate90DegreesCounterClockWiseIntoWindRose() {
        WindRose rotate = leftRotateCommand.rotate(WindRose.W);
        assertEquals(WindRose.S, rotate);
        rotate = leftRotateCommand.rotate(WindRose.N);
        assertEquals(WindRose.W, rotate);
        rotate = leftRotateCommand.rotate(WindRose.E);
        assertEquals(WindRose.N, rotate);
        rotate = leftRotateCommand.rotate(WindRose.S);
        assertEquals(WindRose.E, rotate);
    }
}
