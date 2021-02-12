package com.mcg.instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class InstructionParser {

    public static List<Instruction> parse(String instructionString) {
        Objects.requireNonNull(instructionString, "instructionString must not be null");

        List<Instruction> instructions = new ArrayList<>();
        for (String instruction : instructionString.split("")) {
            instructions.add(Instruction.valueOf(instruction));
        }

        return instructions;
    }
}
