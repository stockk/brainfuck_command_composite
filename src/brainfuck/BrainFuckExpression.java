package brainfuck;

/**
 * Created by Yurii on 11/6/2017.
 */
public class BrainFuckExpression {

    private int pointer = 0;
    private char [] array = new char [20];

    public int getCurrentValue() {
        return this.array[this.pointer];
    }

    public void moveRight(int n){
        this.pointer += n;
    }

    public void moveLeft(int n){
        this.pointer -=n;
    }

    public void increase(int n){
        this.array[this.pointer]+=n;
    }

    public void decries(int n){
        this.array[this.pointer]-=n;
    }

    public void print(int n){
        for (int j = 0; j < n; j++) {
            System.out.print(array[pointer]);
        }
    }



}
