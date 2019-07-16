package teste.elo7.danielsantana.sondamarte.domain.probe.command;

public class RotateCommandFactory {

    public RotateCommand getRotateCommand(RotateCommandType rotateCommandType) {
        if(RotateCommandType.L.equals(rotateCommandType)) {
            return new LeftRotateCommand();
        }
        if(RotateCommandType.R.equals(rotateCommandType)){
            return new RightRotateCommand();
        }
        throw new IllegalArgumentException("Invalid RotateCommandType or not implemented yet: " + rotateCommandType);
    }

}
