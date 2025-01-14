#include <mpi.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

#define N 10      // size of the global data domain (N*N)

int main() {
    int np, rank;
    MPI_Comm comm = MPI_COMM_WORLD;

    // Initialize the MPI environment:
    MPI_Init(NULL, NULL);

    // Obtain my process ID and make sure we are 2D-torus connected
    MPI_Comm_size(comm, &np);
    MPI_Comm_rank(comm, &rank);

    int dims[2] = {0, 0};   // Dimensions of the global cartesian grid
    int periods[2] = {1, 1};// Connecting neighbor processes (torus)
    if ((np != N*N && rank==0)) {
        fprintf(stderr,"Number of available nodes is %d not compatible with expected size: (%dx%d). Abort!\n", np,N,N); 
        exit(-1); 
    }

    dims[0] = (int) sqrt((double)np); // square number
    MPI_Cart_create(comm, 2, dims, periods, 1, &comm);

    int coord[2];         // Coordinates of this processes in the cartesian arrangement
    double start[N],      // send+receive buffers for data-exchange along different directions
           west[N], east[N], // among neighbouring nodes using MPI functions.
           south[N], north[N],
           local;         // Local variable to hold a portion of the whole domain 2D array
    int source, dest;          /* rank of sending and receiving processes */
    // Determine coordinates of this processes (out of numroc processes) in Cartesian arrangement
    MPI_Cart_coords(comm, rank, 2, coord);

    MPI_Finalize();
    return 0;
}