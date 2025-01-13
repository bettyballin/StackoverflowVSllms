import java.lang.String;

public class MinVertexCoverMain {
    public static void main(String[] args) {
        MinVertexCoverMain main = new MinVertexCoverMain();
        main.run();
    }

    public void run() {
        int[][] neighbours = {new int[]{1, 2}, new int[]{0, 3}, new int[]{0, 4}, new int[]{1}, new int[]{2}};
        MinVertexCover mvc = new MinVertexCover(neighbours);
        int minVertexCover = mvc.getMinVertexCover(0);
        System.out.println("Minimum vertex cover: " + minVertexCover);
    }
}

class MinVertexCover {
    private int[][] neighbours;

    public MinVertexCover(int[][] neighbours) {
        this.neighbours = neighbours;
    }

    public int getMinVertexCover(int start) {
        // implementation of getMinVertexCover method is missing in the original code
        // please add the actual implementation here
        return 0; // placeholder return value
    }
}