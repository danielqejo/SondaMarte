package teste.elo7.danielsantana.sondamarte.domain.probe;

import java.util.Objects;

public class Position {

    private int xAxis;
    private int yAxis;

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

    public void sumToXAxis(int quantity) {
        xAxis += quantity;
    }

    public void sumToYAxis(int quantity) {
        yAxis += quantity;
    }

    public void subtractFromXAxis(int quantity) {
        xAxis -= quantity;
    }

    public void subtractFromYAxis(int quantity) {
        yAxis -= quantity;
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

}
