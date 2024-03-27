import java.util.*;

public class travellingSalesman {

    static int tsp(int[][] distanceMatrix) {

        int numCities = distanceMatrix.length;
        int allVisited = (1 << numCities) - 1;

        int[][] memo = new int[numCities][1 << numCities];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return calculateMinimumCost(distanceMatrix, 0, 1, allVisited, memo);
    }

    static int calculateMinimumCost(int[][] distanceMatrix, int currentCity, int visitedMask, int allVisited, int[][] memo) {

        if (visitedMask == allVisited)
            return distanceMatrix[currentCity][0];

        if (memo[currentCity][visitedMask] != -1)
            return memo[currentCity][visitedMask];

        int minCost = Integer.MAX_VALUE;

        for (int nextCity = 0; nextCity < distanceMatrix.length; nextCity++) {

            if ((visitedMask & (1 << nextCity)) == 0) {

                int newVisitedMask = visitedMask | (1 << nextCity);
                int cost = distanceMatrix[currentCity][nextCity] + calculateMinimumCost(distanceMatrix, nextCity, newVisitedMask, allVisited, memo);
                minCost = Math.min(minCost, cost);

            }
        }

        memo[currentCity][visitedMask] = minCost;

        return minCost;
    }

    public static void main(String[] args) {
        
        int[][] distanceMatrix = {{0, 10, 15, 20},
                                  {10, 0, 35, 25},
                                  {15, 35, 0, 30},
                                  {20, 25, 30, 0}};

        int minCost = tsp(distanceMatrix);

        System.out.println("Minimum  Cost: " + minCost);
    }
}
