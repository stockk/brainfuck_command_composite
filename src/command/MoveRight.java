package command;

import brainfuck.BrainFuckExpression;

public class MoveRight implements Command {

    private BrainFuckExpression brainFuckExpression;
    private int n;

    public MoveRight(BrainFuckExpression brainFuckExpression, int n) {
        this.brainFuckExpression = brainFuckExpression;
        this.n = n;
    }

    @Override
    public void execute() {
        brainFuckExpression.moveRight(n);
    }
}
