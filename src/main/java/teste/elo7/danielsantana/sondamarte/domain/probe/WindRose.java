package teste.elo7.danielsantana.sondamarte.domain.probe;

public enum WindRose {

    N, E, W, S;

    private WindRose ninetyDegreesCounterClockWiseSibling;
    private WindRose ninetyDegreesClockWiseSibling;

    static {
        N.ninetyDegreesCounterClockWiseSibling = W;
        N.ninetyDegreesClockWiseSibling = E;
        E.ninetyDegreesCounterClockWiseSibling = N;
        E.ninetyDegreesClockWiseSibling = S;
        W.ninetyDegreesCounterClockWiseSibling = S;
        W.ninetyDegreesClockWiseSibling = N;
        S.ninetyDegreesCounterClockWiseSibling = E;
        S.ninetyDegreesClockWiseSibling = W;
    }

    public WindRose getNinetyDegreesCounterClockWiseSibling() {
        return this.ninetyDegreesCounterClockWiseSibling;
    }

    public WindRose getNinetyDegreesClockWiseSibling() {
        return this.ninetyDegreesClockWiseSibling;
    }

}
