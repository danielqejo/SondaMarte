package teste.elo7.danielsantana.sondamarte.domain.mars;

import java.util.Objects;

public class Position {

    private final int xAxis;
    private final int yAxis;

    public Position(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xAxis == position.xAxis &&
                yAxis == position.yAxis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis);
    }

    @Override
    public String toString() {
        return "(" + xAxis+ "," + yAxis + ")";
    }
}
