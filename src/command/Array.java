package command;

import brainfuck.BrainFuckExpression;

import java.util.ArrayList;
import java.util.List;

public class Array implements Command {

    private List<Command> commands;
    private BrainFuckExpression brainFuckExpression;


    public Array(BrainFuckExpression brainFuckExpression) {
        this.commands = new ArrayList<>();
        this.brainFuckExpression = brainFuckExpression;
    }

    public void addCommand(Command c) {
        commands.add(c);
    }

    @Override
    public void execute() {
        while (brainFuckExpression.getCurrentValue() != 0) {
            commands.forEach(Command::execute);
        }
    }
}
