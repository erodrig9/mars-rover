package com.mcg.instruction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.mcg.position.Heading;
import com.mcg.position.Position;
import com.mcg.vehicle.MarsRover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestMarsRoverController {
    private static MarsRoverController buildMarsRoverController(Position startingPosition) {
        MarsRover marsRover = new MarsRover(startingPosition);
        return new MarsRoverController(marsRover);
    }

    private static Stream<Arguments> testMoveLeftArguments() {
        return Stream.of(Arguments.of(new Position(1, 2, Heading.N), new Position(1, 2, Heading.W)),
                Arguments.of(new Position(1, 2, Heading.E), new Position(1, 2, Heading.N)),
                Arguments.of(new Position(1, 2, Heading.S), new Position(1, 2, Heading.E)),
                Arguments.of(new Position(1, 2, Heading.W), new Position(1, 2, Heading.S)));
    }

    @ParameterizedTest
    @MethodSource("testMoveLeftArguments")
    public void testMoveLeft(Position startingPosition, Position expectedPosition) {
        MarsRoverController marsRoverController = buildMarsRoverController(startingPosition);

        Position actualPosition = null;
        try {
            actualPosition = marsRoverController.move(Instruction.L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expectedPosition, actualPosition);
    }

    private static Stream<Arguments> testMoveRightArguments() {
        return Stream.of(Arguments.of(new Position(1, 2, Heading.N), new Position(1, 2, Heading.E)),
                Arguments.of(new Position(1, 2, Heading.E), new Position(1, 2, Heading.S)),
                Arguments.of(new Position(1, 2, Heading.S), new Position(1, 2, Heading.W)),
                Arguments.of(new Position(1, 2, Heading.W), new Position(1, 2, Heading.N)));
    }

    @ParameterizedTest
    @MethodSource("testMoveRightArguments")
    public void testMoveRight(Position startingPosition, Position expectedPosition) {
        MarsRoverController marsRoverController = buildMarsRoverController(startingPosition);

        Position actualPosition = null;
        try {
            actualPosition = marsRoverController.move(Instruction.R);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expectedPosition, actualPosition);
    }

    private static Stream<Arguments> testMoveForwardArguments() {
        return Stream.of(Arguments.of(new Position(1, 2, Heading.N), new Position(1, 3, Heading.N)),
                Arguments.of(new Position(1, 2, Heading.E), new Position(2, 2, Heading.E)),
                Arguments.of(new Position(1, 2, Heading.S), new Position(1, 1, Heading.S)),
                Arguments.of(new Position(1, 2, Heading.W), new Position(0, 2, Heading.W)));
    }

    @ParameterizedTest
    @MethodSource("testMoveForwardArguments")
    public void testMoveForward(final Position startingPosition, final Position expectedPosition) {
        MarsRoverController marsRoverController = buildMarsRoverController(startingPosition);

        Position actualPosition = null;
        try {
            actualPosition = marsRoverController.move(Instruction.M);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void testExecute() {
        Position startingPosition = new Position(1, 2, Heading.N);
        MarsRoverController marsRoverController = buildMarsRoverController(startingPosition);

        Position expectedPosition = new Position(2, 3, Heading.W);
        marsRoverController.execute(expectedPosition);

        assertEquals(expectedPosition, marsRoverController.getMarsRover().getPosition());
    }
}
