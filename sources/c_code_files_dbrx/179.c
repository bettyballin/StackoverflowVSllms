#include <stdio.h>
#include <limits.h>

#define MAX_NODES 100

int main() {
    int totalNodes, visited = 0;
    int distances[MAX_NODES][MAX_NODES];
    int shortestPath[MAX_NODES];
    int graph[MAX_NODES];

    // Initialize distances and graph arrays
    for (int i = 0; i < MAX_NODES; i++) {
        for (int j = 0; j < MAX_NODES; j++) {
            distances[i][j] = INT_MAX;
        }
        graph[i] = 1; // Mark all nodes as unvisited
    }

    // Your code to populate distances array goes here...

    int pathIndex = 0;
    while (totalNodes != visited) {
        int minDistance = INT_MAX;
        int node_j = -1;

        // Find the unvisited node with the minimum distance
        for (int i = 0; i < totalNodes; i++) {
            if (graph[i] == 1 && distances[shortestPath[pathIndex - 1]][i] < minDistance) {
                minDistance = distances[shortestPath[pathIndex - 1]][i];
                node_j = i;
            }
        }

        // Add node_j to shortestPath array and mark it as visited
        shortestPath[pathIndex] = node_j;
        graph[node_j] = 0;
        visited++;
        pathIndex++;
    }

    // Print the shortest path
    printf("Shortest Path: ");
    for (int i = 0; i < totalNodes; i++) {
        printf("%d ", shortestPath[i]);
    }
    printf("\n");

    return 0;
}