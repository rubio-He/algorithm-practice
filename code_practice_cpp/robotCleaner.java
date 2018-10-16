import java.util.*;

public class robotCleaner { 
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    //right, down, left, up
    Set<String> memo = new HashSet<>();

    public static void main(String[] args) {
    	
    }

    public void dfsClean(int x, int y, int d, Set<String> memo){
        String code = x + ":" + y;
        this.Clean();
        memo.add(hcode);

        for (int i = 0; i < 4; i++) {
        	this.TurnRight(i > 0 ? 1 : 0);
        	//i = 0, d = 0, 
        	int nd = (d + i) % 4;
        	int nx = x + dirs[nd][0];
        	int ny = y + dirs[nd][1];
        	int newCode = nx + ":" + ny;

        	if (!memo.contains(newCode)) {
        		if (this.Move()) {
        			dfsClean(nx, ny, nd, memo);
        			
        			//backtracking, move back, reset direction
        			this.Move();
        			this.TurnRight(2);
           		} else {
        			memo.add(newCode);
        		}
        	}
        }
        this.TurnRight(3);
    }
}

public class Room {
	Robot robot;
	//..

	public int getArea(int x, int y, int dir, Map<Integer, Set<Integer>> room) {
		if (room.containsKey(x) && room.get(x).contains(y)) {
			robot.move(moveBack(dir));
			return 0;
		}

		if (!room.containsKey(x)) {
			room.put(x, new HashSet<>());
		}
		room.get(x).add(y);
		int area = 1;

		//if robot was not moved to current place from below, move robot down
		if (dir != 0 && robot.move(moveBack(0))) {
			area += getArea(x, y - 1, 0, room);
		}


		if (dir != 1 && robot.move(moveBack(1))) {
			area += getArea(x + 1, y, 1, room);
		}

		if (dir != 2 && robot.move(moveBack(2))) {
			area += getArea(x, y + 1, 2, room);
		}

		if (dir != 3 && robot.move(moveBack(3))) {
			area += getArea(x - 1, y, 3, room);
		}
	}

	//0 -> below, 1 -> right, 2 -> above ,3->left
	private int moveBack(int from) {

        if(from == 0) return 2;
        if(from == 1) return 3;
        if(from == 2) return 0;
        return 1;

    }
}