package command;

import brainfuck.BrainFuckExpression;

public class Print implements Command {

    private BrainFuckExpression brainFuckExpression;
    private int n;

    public Print(BrainFuckExpression brainFuckExpression, int n) {
        this.brainFuckExpression = brainFuckExpression;
        this.n = n;
    }

    @Override
    public void execute() {
        brainFuckExpression.print(n);
    }
}
