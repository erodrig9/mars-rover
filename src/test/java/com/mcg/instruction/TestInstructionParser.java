package com.mcg.instruction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestInstructionParser {
    @Test
    public void testParse() {
        final List<Instruction> expectedInstructions = new ArrayList<Instruction>() {
            private static final long serialVersionUID = 1L;
            {
                add(Instruction.L);
                add(Instruction.R);
                add(Instruction.M);
            }
        };

        String input = "LRM";
        List<Instruction> actualInstructions = InstructionParser.parse(input);

        assertEquals(expectedInstructions, actualInstructions);
    }
}
