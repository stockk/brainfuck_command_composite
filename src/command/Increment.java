package command;

import brainfuck.BrainFuckExpression;

public class Increment implements Command {

    private BrainFuckExpression brainFuckExpression;
    private int n;

    public Increment(BrainFuckExpression brainFuckExpression, int n) {
        this.brainFuckExpression = brainFuckExpression;
        this.n = n;
    }

    @Override
    public void execute() {
        brainFuckExpression.increase(n);
    }


}
