import mpi.*;

public class Pi {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.getRank();
        int size = MPI.COMM_WORLD.getSize();

        // Perform calculations and communication here

        MPI.Finalize();
    }
}