package command;

import brainfuck.BrainFuckExpression;

public class MoveLeft implements Command {

    private BrainFuckExpression brainFuckExpression;
    private int n;

    public MoveLeft(BrainFuckExpression brainFuckExpression, int n) {
            this.brainFuckExpression = brainFuckExpression;
        this.n = n;
    }

    @Override
    public void execute() {
        brainFuckExpression.moveLeft(n);
    }

}
