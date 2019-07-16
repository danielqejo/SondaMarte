package teste.elo7.danielsantana.sondamarte.domain.probe.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateCommandFactoryTest {

    private RotateCommandFactory rotateCommandFactory;

    @Before
    public void setUp() {
        rotateCommandFactory = new RotateCommandFactory();
    }

    @Test
    public void shouldCreateLeftRotateCommand() {
        RotateCommand producedRotateCommand = rotateCommandFactory.getRotateCommand(RotateCommandType.L);
        assertTrue(producedRotateCommand instanceof LeftRotateCommand);
    }

    @Test
    public void shouldCreateRightRotateCommand() {
        RotateCommand producedRotateCommand = rotateCommandFactory.getRotateCommand(RotateCommandType.R);
        assertTrue(producedRotateCommand instanceof RightRotateCommand);
    }

    @Test
    public void shouldThrowIllegalArgumentWhenIsNull() {
        try {
            rotateCommandFactory.getRotateCommand(null);
            fail("Should've thrown exception");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
        }
    }
}
