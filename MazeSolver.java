import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeSolver {

    static int[][] dir = new int[4][];
    static {
        dir[0] = new int[] { 0, 1 };
        dir[1] = new int[] { 1, 0 };
        dir[2] = new int[] { 0, -1 };
        dir[3] = new int[] { -1, 0 };
    }

    public static void main(String[] args) {
        String[] maze = new String[] {
                "###### #",
                "#      #",
                "#      #",
                "# ######",
        };
        Point start = new Point(1, 3);
        Point end = new Point(6, 0);
        solve(maze, '#', start, end);
    }

    public static void solve(String[] maze, char wall, Point start, Point end) {
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        List<Point> path = new ArrayList<>();
        walk(maze, wall, start, end, seen, path);
    }

    public static boolean walk(String[] maze, char wall, Point curr, Point end, boolean[][] seen, List<Point> path) {
        System.out.println("---");
        // Base case
        // - off the map
        if (curr.x < 0 || curr.x >= maze.length -1 || curr.y < 0 || curr.y >= maze[0].length() - 1) {
            System.out.println("off the map");
            return false;
        }
        // - on a wall
        if (maze[curr.y].charAt(curr.x) == wall) {
            System.out.println("on wall");
            return false;
        }
        // - it's the end
        if (curr.x == end.x && curr.y == end.y) {
            System.out.println("at the end");
            path.add(new Point(curr.x, curr.y));
            return true;
        }
        // - seen before
        if (seen[curr.x][curr.y]) {
            System.out.println("seen before");
            return false;
        }

        // Recurse
        // - pre
        seen[curr.x][curr.y] = true;
        path.add(new Point(curr.x, curr.y));
        // - recurse
        for (int i = 0; i < dir.length; i++) {
            Point next = new Point(curr.x + dir[i][0], curr.y + dir[i][1]);
            if (walk(maze, wall, next, end, seen, path)) {
                return true;
            }
        }
        // - post
        path.remove(path.size() - 1);

        return false;
    }
}
