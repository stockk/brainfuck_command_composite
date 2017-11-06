package command;

import brainfuck.BrainFuckExpression;

public class Dicrement implements Command {

    private BrainFuckExpression brainFuckExpression;
    private int n;

    public Dicrement(BrainFuckExpression brainFuckExpression, int n) {
        this.brainFuckExpression = brainFuckExpression;
        this.n = n;
    }

    @Override
    public void execute() {
        brainFuckExpression.decries(n);
    }
}
