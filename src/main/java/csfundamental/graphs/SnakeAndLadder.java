package csfundamental.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    Integer SOL = Integer.MAX_VALUE;

    public static void main(String[] ar) {
        SnakeAndLadder obj = new SnakeAndLadder();
//        int[][] board = {
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1}
//        };
        int[][] board = {
                {-1, -1},
                {-1, 3}
        };
        System.out.println(obj.snakesAndLadders(board));
    }

    /**
     * 1. define a player with vertex and distance
     * 2. Add player in queue
     * 3. Lopp until queue is empty
     * 4. Poll from queue and for this Player [vertex, distance] find out nextValidMove
     * 5. If found add a player with new vertex and distance in queue.
     * 6. when queue is finished. The distance in last element of queue is the minumum
     *
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;

        int N = rowSize * colSize;

        Player player = new Player();
        player.vertex = 0;
        player.distance = 0;

        Queue<Player> queue = new LinkedList<>();
        queue.add(player);

        int[] visited = new int[rowSize * colSize];
        int distance = 0;
        while (!queue.isEmpty()) {
            Player plyr = queue.peek();
            int vertex = plyr.vertex;
            distance = plyr.distance;

            if (plyr.vertex == N) {
                return distance;
            }

            if (vertex < N && distance < SOL) {
                for (int i = board.length; i > 0; i--) {
                    int v = vertex + i;
                    if (v > N) {
                        continue;
                    }
                    if (v == N) {
                        return distance + 1;
                    }
                    int nextVertex = getNextVertex(board, v);
                    if (nextVertex != -1 && visited[nextVertex - 1] == 0 && nextVertex <= N && (distance + 1) < N) {
                        visited[nextVertex - 1] = 1;
                        //move player
                        Player pl = new Player();
                        pl.vertex = nextVertex;
                        pl.distance = distance + 1;
                        queue.add(pl);
                        break;
                    }
                }
            }
            queue.remove();
        }
        return distance;
    }

    public int getNextVertex(int[][] board, int v) {
        int cap = board.length;
        if (v <= cap) {
            return board[board.length - 1][v - 1];
        } else {
            int rows = board.length - 1;
            int newRow = (v / cap) == cap ? 0 : rows - (v / cap);
            int newCol = (v % cap) == 0 ? 0 : (v % cap) - 1;
            return board[newRow][newCol];
        }
    }

}

class Player {
    int vertex;
    int distance;
}