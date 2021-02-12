package com.mcg.mission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.mcg.position.Heading;
import com.mcg.position.Position;
import com.mcg.surface.Plateau;
import com.mcg.surface.Surface;
import com.mcg.vehicle.Vehicle;

import org.junit.jupiter.api.Test;

public class TestMarsRoverMission {
    @Test
    public void testCollisionMission() {
        Surface surface = new Plateau(3, 3);
        MarsRoverMission marsRoverMission = new MarsRoverMission(surface);

        Position startingPosition = new Position(0, 0, Heading.S);
        marsRoverMission.deployRover(startingPosition);
        try {
            marsRoverMission.sendRoverInstructions("LMMLM");
        } catch (Exception e) {
            e.printStackTrace();
        }

        startingPosition = new Position(1, 2, Heading.W);
        marsRoverMission.deployRover(startingPosition);
        try {
            marsRoverMission.sendRoverInstructions("LMLMRM");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Vehicle> marsRovers = marsRoverMission.getMarsRovers();
        assertEquals(2, marsRovers.size());

        Position expectedPosition = new Position(2, 1, Heading.N);
        assertEquals(expectedPosition, marsRovers.get(0).getPosition());

        expectedPosition = new Position(1, 0, Heading.S);
        assertEquals(expectedPosition, marsRovers.get(1).getPosition());
    }

    @Test
    public void testSucessfullMission() {
        Surface surface = new Plateau(5, 5);
        MarsRoverMission marsRoverMission = new MarsRoverMission(surface);

        Position startingPosition = new Position(1, 2, Heading.N);
        marsRoverMission.deployRover(startingPosition);
        try {
            marsRoverMission.sendRoverInstructions("LMLMLMLMM");
        } catch (Exception e) {
            e.printStackTrace();
        }

        startingPosition = new Position(3, 3, Heading.E);
        marsRoverMission.deployRover(startingPosition);
        try {
            marsRoverMission.sendRoverInstructions("MMRMMRMRRM");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Vehicle> marsRovers = marsRoverMission.getMarsRovers();
        assertEquals(2, marsRovers.size());

        Position expectedPosition = new Position(1, 3, Heading.N);
        assertEquals(expectedPosition, marsRovers.get(0).getPosition());

        expectedPosition = new Position(5, 1, Heading.E);
        assertEquals(expectedPosition, marsRovers.get(1).getPosition());
    }

    @Test
    public void testOffSurfaceMission() {
        Surface surface = new Plateau(5, 5);
        MarsRoverMission marsRoverMission = new MarsRoverMission(surface);

        Position startingPosition = new Position(1, 1, Heading.S);
        marsRoverMission.deployRover(startingPosition);
        try {
            marsRoverMission.sendRoverInstructions("RMM");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Vehicle> marsRovers = marsRoverMission.getMarsRovers();
        assertEquals(1, marsRovers.size());

        Position expectedPosition = new Position(0, 1, Heading.W);
        assertEquals(expectedPosition, marsRovers.get(0).getPosition());
    }
}
