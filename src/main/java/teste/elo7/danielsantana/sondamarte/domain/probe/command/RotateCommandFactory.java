package teste.elo7.danielsantana.sondamarte.domain.probe.command;

import teste.elo7.danielsantana.sondamarte.utils.ApplicationConfigurations;

public class RotateCommandFactory {

    private static final String L = "L";
    private static final String R = "R";

    public static RotateCommand getRotateCommand(String initials) {
        String upperCaseInitial = initials.toUpperCase(ApplicationConfigurations.LOCALE);
        if(L.equals(upperCaseInitial))
            return new LeftRotateCommand();
        if(R.equals(upperCaseInitial))
            return new RightRotateCommand();
        throw new IllegalArgumentException(initials + " command does not exist");
    }
}
