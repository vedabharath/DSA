package com.bharath.skills.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findCheapestPrice{

    public static void main(String[] args) {

        int n = 9;

        int[][] flights = new int[][]{{0,1,1},{1,2,1},{2,3,1},{3,7,1},
                {0,4,3},{4,5,3},{5,7,3},{0,6,5},{6,7,100},{7,8,1}};

        System.out.println(new findCheapestPriceSolution().findCheapestPrice(n,flights,0,8,3));

    }
}

class findCheapestPriceSolution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV || stops < currentStops[nei])  {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                        currentStops[nei] = stops;
                    }
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }
}
