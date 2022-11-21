package entities.hazards;

import java.util.ArrayList;
import java.util.List;

/**
 * An enemy which chases the player
 */
public class ChasingEnemy extends MovingEnemy {
    /**
     * Create a new chasing enemy with the given starting position.
     */
    public ChasingEnemy(int startX, int startY) {
        super(startX, startY);
    }

    @Override
    public void update(IEnemyRequestModel request) {
        List<int[]> candidates = getPossibleMoves(request);

        // This should *at least* include the tile
        // the enemy is currently on, since there
        // shouldn't be an obstacle there.
        assert candidates.size() > 0;

        // the initial value of bestCandidates shouldn't matter,
        // since it should be overwritten by the 1st candidate.
        int[] bestCandidate = candidates.get(0);
        double bestScore = Double.NEGATIVE_INFINITY;

        // find the tile with the highest move score.
        for (int[] candidate: candidates) {
            double score = moveScore(request, candidate[0], candidate[1]);
            if (score > bestScore) {
                bestCandidate = candidate;
                bestScore = score;
            }
        }

        // move to that tile
        setX(bestCandidate[0]);
        setY(bestCandidate[1]);
    }

    /**
     * How much does the enemy want to move to the tile (x, y)?
     * Tiles closer to the player will have higher scores.
     */
    private double moveScore(IEnemyRequestModel request, int x, int y) {
        // Use the *negative* distance to the player as the score.
        // This way, tiles closer to the player will have higher scores.
        double dx = x - request.getPlayerX();
        double dy = y - request.getPlayerY();
        return -Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Get the possible tiles the enemy can move to
     * (i.e. the tiles which aren't blocked by obstacles).
     *
     * @return A list of 2-element arrays containing x and y positions.
     */
    private List<int[]> getPossibleMoves(IEnemyRequestModel request) {
        int x = getX();
        int y = getY();
        ArrayList<int[]> neighbours = new ArrayList<>();
        if (x > 0 && !request.isTileBlockedForEnemies(x - 1, y))
            neighbours.add(new int[] {x - 1, y});
        if (y > 0 && !request.isTileBlockedForEnemies(x, y - 1))
            neighbours.add(new int[] {x, y - 1});
        if (x < request.mazeWidth() - 1 && !request.isTileBlockedForEnemies(x + 1, y))
            neighbours.add(new int[] {x + 1, y});
        if (y < request.mazeHeight() - 1 && !request.isTileBlockedForEnemies(x, y + 1))
            neighbours.add(new int[] {x, y + 1});

        return neighbours;
    }
}
