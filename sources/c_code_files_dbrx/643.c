#include <mpi.h>

int main() {
    int coord[2], dims[2];
    int source, dest;
    double start;
    int N;
    MPI_Comm comm;

    // Initialize MPI
    MPI_Init(NULL, NULL);

    // Assume dims and coord are initialized somewhere

    if(coord[1] == 0) {             /* I am a north boundary process: send top row down south */
        dest = coord[1]*dims[0];         /* rank of sending procees. */
    } else if(coord[1] != dims[1]-1) {          /* Not a southernmost process? */
        source = (coord[1] + 1) * dims[0];  //rank of neighbor above
        dest   = coord[1]*dims[0];      // rank of sending procees.
    }

    MPI_Recv(&start, N, MPI_DOUBLE_PRECISION, source, 2*dims[0]+3, comm, MPI_STATUS_IGNORE); // get data sent from above */

    // Clean up
    MPI_Finalize();
    return 0;
}