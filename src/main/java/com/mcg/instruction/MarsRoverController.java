package com.mcg.instruction;

import java.util.Objects;

import com.mcg.position.Heading;
import com.mcg.position.Position;
import com.mcg.vehicle.MarsRover;

public class MarsRoverController {
    private MarsRover marsRover;

    public MarsRoverController(MarsRover marsRover) {
        this.marsRover = Objects.requireNonNull(marsRover, "marsRover must not be null");
    }

    public MarsRover getMarsRover() {
        return marsRover;
    }

    public void execute(Position position) {
        this.marsRover.setPosition(position);
    }

    public Position move(Instruction instruction) throws Exception {
        switch (instruction) {
            case L:
                return this.moveLeft();
            case R:
                return this.moveRight();
            case M:
                return this.moveForward();
            default:
                throw new IllegalArgumentException("Invalid instruction provided");
        }
    }

    private Position moveLeft() {
        Heading heading = this.marsRover.getPosition().getHeading();
        Position newPosition = new Position(this.marsRover.getPosition().getX(), this.marsRover.getPosition().getY(),
                heading);
        switch (heading) {
            case N:
                newPosition.setHeading(Heading.W);
                break;
            case E:
                newPosition.setHeading(Heading.N);
                break;
            case S:
                newPosition.setHeading(Heading.E);
                break;
            case W:
                newPosition.setHeading(Heading.S);
                break;
        }

        return newPosition;
    }

    private Position moveRight() {
        Heading heading = this.marsRover.getPosition().getHeading();
        Position newPosition = new Position(this.marsRover.getPosition().getX(), this.marsRover.getPosition().getY(),
                heading);
        switch (heading) {
            case N:
                newPosition.setHeading(Heading.E);
                break;
            case E:
                newPosition.setHeading(Heading.S);
                break;
            case S:
                newPosition.setHeading(Heading.W);
                break;
            case W:
                newPosition.setHeading(Heading.N);
                break;
        }

        return newPosition;
    }

    private Position moveForward() throws Exception {
        int x = this.marsRover.getPosition().getX();
        int y = this.marsRover.getPosition().getY();
        Heading heading = this.marsRover.getPosition().getHeading();
        Position newPosition = new Position(x, y, heading);
        switch (heading) {
            case N:
                newPosition.setY(y + 1);
                break;
            case E:
                newPosition.setX(x + 1);
                break;
            case S:
                newPosition.setY(y - 1);
                break;
            case W:
                newPosition.setX(x - 1);
                break;
        }

        return newPosition;
    }
}
