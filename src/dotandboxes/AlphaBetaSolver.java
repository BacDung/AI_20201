package dotandboxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlphaBetaSolver extends GameSolver {
    final static int MIN=-1000000000, MAX=1000000000 ;
    private int maxLevel ;
    private long startTime;
    private long moveTime = 1900000000;

    public Edge getNextMove(Chessboard board, int color) {
        startTime = System.nanoTime();
        referenceColor = color ;
        maxLevel = 1;
        Edge best = null;
        while(maxLevel <= board.getAvailableMoves().size()) {
            Pair pair = dfs(board, color, MIN, MAX, 0) ;
            if((System.nanoTime() - startTime) < moveTime)
                best = pair.getEdge();
            else
                break;
            //System.out.println(best) ;
            maxLevel++;
        }
        return best;
    }

    Pair dfs(Chessboard board, int color, int a, int b, int level) {
        if(level < maxLevel && (System.nanoTime() - startTime) < moveTime) {
            ArrayList<Edge> moves = board.getAvailableMoves();
            int size = moves.size();

            if (size == 0)
                return new Pair(null, heuristic(board, color));

            Collections.shuffle(moves);
            Pair[] neighbours = new Pair[size] ;
            for(int i=0 ; i<size ; i++) {
                Chessboard newBoard = board.getNewBoard(moves.get(i), color);
                neighbours[i] = new Pair(moves.get(i),heuristic(newBoard, (newBoard.getScore(color) > board.getScore(color) ? color : Chessboard.toggleColor(color))));
            }
            Arrays.sort(neighbours);
            moves = new ArrayList<Edge>();
            if(referenceColor != color)
                for(int i=0; i<size; i++)
                    moves.add(neighbours[i].getEdge());
            else
                for(int i=size-1; i>=0; i--)
                    moves.add(neighbours[i].getEdge());

            if (color == referenceColor) {
                Pair newPair = new Pair(null, MIN);

                for (int i = 0; i < size; i++) {
                    Chessboard child = board.getNewBoard(moves.get(i), color);
                    Pair pair;
                    int childScore = child.getScore(color), currentScore = board.getScore(color);
                    boolean flag = false;
                    if (childScore == currentScore) {
                        pair = dfs(child, Chessboard.toggleColor(color), a, b, level + 1);
                        flag = true;
                    } else
                        pair = dfs(child, color, a, b, level + 1);

                    int childUtility = pair.getUtility();
                    if (newPair.getUtility() < childUtility) {
                        newPair.setUtility(childUtility);
                        newPair.setEdge(moves.get(i));
                    }
                    if (flag)
                        if (childUtility >= b)
                            return newPair;

                    a = Math.max(a, newPair.getUtility());
                }
                return newPair;
            }
            else {
                Pair newPair = new Pair(null, MAX);

                for (int i = 0; i < size; i++) {
                    Chessboard child = board.getNewBoard(moves.get(i), color);
                    Pair pair;
                    int childScore = child.getScore(color), currentScore = board.getScore(color);
                    boolean flag = false;
                    if (childScore == currentScore) {
                        pair = dfs(child, Chessboard.toggleColor(color), a, b, level+1);
                        flag = true;
                    } else
                        pair = dfs(child, color, a, b, level+1);

                    int childUtility = pair.getUtility();
                    if (newPair.getUtility() > childUtility) {
                        newPair.setUtility(childUtility);
                        newPair.setEdge(moves.get(i));
                    }
                    if (flag)
                        if (childUtility <= a)
                            return newPair;

                    b = Math.min(b, newPair.getUtility());
                }
                return newPair;
            }
        }
        else {
            return new Pair(null, heuristic(board, color));
        }
    }
}

