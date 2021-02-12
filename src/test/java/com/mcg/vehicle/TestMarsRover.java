package com.mcg.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mcg.position.Heading;
import com.mcg.position.Position;

import org.junit.jupiter.api.Test;

public class TestMarsRover {
    @Test
    public void testMarsRover() {
        Position startingPosition = new Position(1, 2, Heading.E);
        MarsRover rover = new MarsRover(startingPosition);
        assertEquals(startingPosition, rover.getPosition());
    }
}
