package brainfuck;

import command.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class BrainFuckInvoker {

    ArrayList<Command> commands = new ArrayList<>();

    public void createCommands(String expression) {

        char arr[] = expression.toCharArray();
        BrainFuckExpression brainFuckExpression = new BrainFuckExpression();
        LinkedList<Array> stackArrays = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            char operation = arr[i];
            int count = 1;
            switch (operation) {
                case '>':
                    while (i != arr.length - 1 && operation == arr[i + 1]) {
                        count++;
                        i++;
                    }
                    if (stackArrays.isEmpty())
                        commands.add(new MoveRight(brainFuckExpression, count));
                    else
                        stackArrays.peek().addCommand(new MoveRight(brainFuckExpression, count));
                    break;
                case '<':
                    while (i != arr.length - 1 && operation == arr[i + 1]) {
                        count++;
                        i++;
                    }
                    if (stackArrays.isEmpty())
                        commands.add(new MoveLeft(brainFuckExpression, count));
                    else
                        stackArrays.peek().addCommand(new MoveLeft(brainFuckExpression, count));
                    break;
                case '+':
                    while (i != arr.length - 1 && operation == arr[i + 1]) {
                        count++;
                        i++;
                    }
                    if (stackArrays.isEmpty())
                        commands.add(new Increment(brainFuckExpression, count));
                    else
                        stackArrays.peek().addCommand(new Increment(brainFuckExpression, count));
                    break;
                case '-':
                    while (i != arr.length - 1 && operation == arr[i + 1]) {
                        count++;
                        i++;
                    }
                    if (stackArrays.isEmpty())
                        commands.add(new Dicrement(brainFuckExpression, count));
                    else
                        stackArrays.peek().addCommand(new Dicrement(brainFuckExpression, count));
                    break;
                case '.':
                    while (i != arr.length - 1 && operation == arr[i + 1]) {
                        count++;
                        i++;
                    }
                    if (stackArrays.isEmpty())
                        commands.add(new Print(brainFuckExpression, count));
                    else
                        stackArrays.peek().addCommand(new Print(brainFuckExpression, count));
                    break;
                case '[':
                    stackArrays.push(new Array(brainFuckExpression));
                    break;
                case ']':
                    commands.add(stackArrays.pop());
                    break;
            }
        }

    }


    public void executeCommands() {
        commands.forEach(Command::execute);
    }

}
