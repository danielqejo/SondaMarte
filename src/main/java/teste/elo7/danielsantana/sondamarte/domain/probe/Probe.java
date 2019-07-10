package teste.elo7.danielsantana.sondamarte.domain.probe;

import java.util.Objects;

public class Probe {

    private String name;
    private Position position;
    private Direction direction;

    public Probe(String name, Position position, Direction direction){
        this.name = name;
        this.direction = direction;
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public int getYPosition(){
        return this.position.getyAxis();
    }

    public int getXPosition(){
        return this.position.getxAxis();
    }

    public void rotateLeft() {
        if(isPointingToEast())
            this.direction = Direction.N;
        else if(isPointingToWest())
            this.direction = Direction.S;
        else if(isPointingToNorth())
            this.direction = Direction.W;
        else if(isPointingToSouth())
            this.direction = Direction.E;
    }

    public void rotateRight() {
        if(isPointingToEast())
            this.direction = Direction.S;
        else if(isPointingToWest())
            this.direction = Direction.N;
        else if(isPointingToNorth())
            this.direction = Direction.E;
        else if(isPointingToSouth())
            this.direction = Direction.W;
    }

    public void move() {
        if(isPointingToEast())
            this.position.sumToXAxis(1);
        if(isPointingToWest())
            this.position.subtractFromXAxis(1);
        if(isPointingToNorth())
            this.position.sumToYAxis(1);
        if(isPointingToSouth())
            this.position.subtractFromYAxis(1);
    }

    private boolean isPointingToWest() {
        return isPointingTo(Direction.W);
    }

    private boolean isPointingToEast(){
        return isPointingTo(Direction.E);
    }

    private boolean isPointingToSouth() {
        return isPointingTo(Direction.S);
    }

    private boolean isPointingToNorth() {
        return isPointingTo(Direction.N);
    }

    private boolean isPointingTo(Direction direction) {
        return this.direction.equals(direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probe probe = (Probe) o;
        return name.equals(probe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
