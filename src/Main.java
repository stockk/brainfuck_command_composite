import brainfuck.BrainFuckInvoker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BrainFuckInvoker brainFuckInvoker = new BrainFuckInvoker();
        brainFuckInvoker.createCommands(sc.nextLine());

        brainFuckInvoker.executeCommands();
    }
}
