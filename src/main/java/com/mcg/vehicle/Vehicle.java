package com.mcg.vehicle;

import java.util.Objects;
import com.mcg.position.Position;

public abstract class Vehicle {
    protected Position position;

    Vehicle(Position position) {
        this.position = Objects.requireNonNull(position, "position must not be null");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
