package com.mcg.mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mcg.instruction.Instruction;
import com.mcg.instruction.InstructionParser;
import com.mcg.instruction.MarsRoverController;
import com.mcg.position.Position;
import com.mcg.surface.Surface;
import com.mcg.vehicle.MarsRover;
import com.mcg.vehicle.Vehicle;

public class MarsRoverMission extends Mission {
    private List<Vehicle> marsRovers = new ArrayList<>();
    private MarsRoverController marsRoverController;

    public MarsRoverMission(Surface surface) {
        super(surface);
    }

    public void deployRover(Position position) {
        MarsRover rover = new MarsRover(position);
        this.marsRoverController = new MarsRoverController(rover);
    }

    public void sendRoverInstructions(String instructions) throws Exception {
        if (this.marsRoverController == null) {
            throw new Exception("A rover must be deployed first");
        }

        Objects.requireNonNull(instructions, "instructions must not be null");
        List<Instruction> roverInstructions = InstructionParser.parse(instructions);
        for (Instruction instruction : roverInstructions) {
            Position newPosition = this.marsRoverController.move(instruction);
            if (this.causesCollision(newPosition)
                    || !this.surface.isPointOnSurface(newPosition.getX(), newPosition.getY())) {
                continue;
            }

            this.marsRoverController.execute(newPosition);
        }

        this.marsRovers.add(this.marsRoverController.getMarsRover());
    }

    private boolean causesCollision(Position newPosition) {
        int x = newPosition.getX();
        int y = newPosition.getY();
        for (Vehicle marsRover : this.marsRovers) {
            if (marsRover.getPosition().getX() == x && marsRover.getPosition().getY() == y) {
                return true;
            }
        }

        return false;
    }

    public List<Vehicle> getMarsRovers() {
        return this.marsRovers;
    }
}
