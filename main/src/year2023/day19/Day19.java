package year2023.day19;

import year2023.day19.instructions.Instruction;
import year2023.day19.instructions.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day19 {
    public static void main(String[] args) {
        String[] input = Input.INPUT;
        String[] instructionStrings = input[0].split("\n");
        String[] partStrings = input[1].split("\n");
        List<Part> parts = new ArrayList<>();
        Map<String, Instruction> workflows = new HashMap<>();
        for (String r : instructionStrings) {
            Instruction instruction = Instruction.of(r);
            workflows.put(instruction.name(), instruction);
        }
        for (String part : partStrings) {
            parts.add(Part.of(part));
        }
        List<Part> accepted = new ArrayList<>();

        Instruction firstInstruction = workflows.get("in");
        for (Part part : parts) {
            Instruction instruction = firstInstruction;
            Result result = new Result(Result.Type.MOVED, instruction.name());
            while (result.type() == Result.Type.MOVED) {
                result = instruction.apply(part);
                instruction = workflows.get(result.workflow());
                if (result.type() == Result.Type.MOVED && instruction == null)
                    throw new IllegalStateException("Result referred to instruction \"" + result.workflow() + "\", but it doesn't exist");
            }
            if (result.type() == Result.Type.ACCEPTED) accepted.add(part);
        }

        long solution = 0;
        for (Part p : accepted) {
            solution += p.rating();
        }
        System.out.println(solution);
    }
}
