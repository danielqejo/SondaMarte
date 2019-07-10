package teste.elo7.danielsantana.sondamarte.domain.plateau;

import teste.elo7.danielsantana.sondamarte.domain.plateau.exception.PlateauBoundaryViolationException;

public abstract class Plateau {

    private int xAxisBoundary;
    private int yAxisBoundary;

    protected Plateau(int xAxisBoundary, int yAxisBoundary) {
        if(xAxisBoundary <= 0)
            throw new IllegalArgumentException("X-Axis must be positive integer");
        if(yAxisBoundary <= 0)
            throw new IllegalArgumentException("Y-Axis must be positive integer");
        this.xAxisBoundary = xAxisBoundary;
        this.yAxisBoundary = yAxisBoundary;
    }

    public void checkBoundaries(int xAxis, int yAxis) throws PlateauBoundaryViolationException {
        if(xAxisBoundary < xAxis ||  0 > xAxis)
            throw new PlateauBoundaryViolationException("X-Axis is being violated. Wanted: " + xAxis + " Bound (0," + xAxisBoundary + ")");
        if(yAxisBoundary < yAxis ||  0 > yAxis)
            throw new PlateauBoundaryViolationException("Y-Axis is being violated. Wanted: " + yAxis + " Bound (0," + yAxisBoundary + ")");
    }

}
