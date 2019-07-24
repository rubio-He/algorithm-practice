import java.util.*;

public class SnakeGame {
    int w;
    int h;
    int[] head = new int[2];
    int[][] food;
    LinkedList<int[]> s = new LinkedList<>();
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        this.food = food;
        head[0]=0;
        head[1]=0;
        s.add(new int[]{0,0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(direction == "U") head[0]--;
        if(direction == "D") head[0]++;
        if(direction == "L") head[1]--;
        if(direction == "R") head[1]++;
        return check();
    }

    public int check(){
        if(head[0] < 0 || head[0] >= h || head[1] < 0 || head[1] >= w) return -1;
        else{
            for(int[] f : food){
                if(head[0] == f[0] && head[1] == f[1]){
                    s.addFirst(new int[]{f[0],f[1]});
                    f[0] = -1;
                    f[1] = -1;
                    return s.size()-1;
                }
            }
            for(int[] f: s){
                if(head[0] == f[0] && head[1] == f[1]){
                    return -1;
                }
            }
            s.removeLast();
            return 0;


        }
    }

    public static void main(String[] args){
        SnakeGame game = new SnakeGame(3,2,new int[][]{{1,2},{0,1}});
        System.out.print(game.move("R"));

    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */