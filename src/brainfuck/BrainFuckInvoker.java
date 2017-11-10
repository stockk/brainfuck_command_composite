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


        ArrayList<Character>  arrWithoutRepetition = new ArrayList<>();
        ArrayList<Integer>  countOfOperation = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            char operation = arr[i];
            int count= 1;
            if(operation!='[' && operation!=']')
                while (i != arr.length - 1 && operation == arr[i + 1]) {
                    count++;
                    i++;
                }
            arrWithoutRepetition.add(operation);
            countOfOperation.add(count);
        }
        
        
        for (int i = 0; i < arrWithoutRepetition.size(); i++) {
            char operation = arrWithoutRepetition.get(i);
            switch (operation) {
                case '>':
                    if (stackArrays.isEmpty())
                        commands.add(new MoveRight(brainFuckExpression, countOfOperation.get(i)));
                    else
                        stackArrays.peek().addCommand(new MoveRight(brainFuckExpression, countOfOperation.get(i)));
                    break;
                case '<':
                    if (stackArrays.isEmpty())
                        commands.add(new MoveLeft(brainFuckExpression, countOfOperation.get(i)));
                    else
                        stackArrays.peek().addCommand(new MoveLeft(brainFuckExpression, countOfOperation.get(i)));
                    break;
                case '+':
                    if (stackArrays.isEmpty())
                        commands.add(new Increment(brainFuckExpression, countOfOperation.get(i)));
                    else
                        stackArrays.peek().addCommand(new Increment(brainFuckExpression, countOfOperation.get(i)));
                    break;
                case '-':
                    if (stackArrays.isEmpty())
                        commands.add(new Dicrement(brainFuckExpression, countOfOperation.get(i)));
                    else
                        stackArrays.peek().addCommand(new Dicrement(brainFuckExpression, countOfOperation.get(i)));
                    break;
                case '.':
                    if (stackArrays.isEmpty())
                        commands.add(new Print(brainFuckExpression, countOfOperation.get(i)));
                    else
                        stackArrays.peek().addCommand(new Print(brainFuckExpression, countOfOperation.get(i)));
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
