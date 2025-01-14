#include <mpi.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    MPI_Init(&argc, &argv); // Initialize the communicator

    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (rank != 0) {
        sleep(1); // Allow first rank's send to complete before beginning receive operation in other ranks
    }

    double time = MPI_Wtime();
    int message;
    MPI_Status status;
    int tag = 0;

    if (rank == 0) {
        message = 123; // Example message
        for (int i = 1; i < size; i++) {
            MPI_Send(&message, 1, MPI_INT, i, tag, MPI_COMM_WORLD); // Send messages to other ranks
        }
    } else {
        MPI_Recv(&message, 1, MPI_INT, 0, tag, MPI_COMM_WORLD, &status); // Receive messages from rank 0
        printf("Rank[%d] received %i from rank %d after %f seconds.\n", rank, message, status.MPI_SOURCE, MPI_Wtime() - time);
    }

    MPI_Finalize();
    return 0;
}