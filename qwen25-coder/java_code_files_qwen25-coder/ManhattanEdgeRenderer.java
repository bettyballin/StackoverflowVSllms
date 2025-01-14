import prefuse.data.Graph;
import prefuse.render.EdgeRenderer;
import prefuse.util.GraphicsLib;
import prefuse.visual.EdgeItem;
import java.awt.Shape;

public class ManhattanEdgeRenderer extends EdgeRenderer {

    protected Shape getRawShape(EdgeItem item) {
        Graph g = (Graph) item.getSourceTupleSet();
        float sx = (float) item.getX1();
        float sy = (float) item.getY1();
        float tx = (float) item.getX2();
        float ty = (float) item.getY2();

        // Simple Manhattan route by connecting source and target with vertical/horizontal lines
        int midX = (int) ((sx + tx) / 2);
        return GraphicsLib.getPolygon(
            new float[] { sx, sx, midX - 1, midX + 1, tx },
            new float[] { sy, ty, sy, ty, ty },
            5);
    }

    public static void main(String[] args) {
        // Example of how to use this renderer in a Prefuse visual application goes here
        // You would typically set this as an EdgeRenderer in your Prefuse Visualization frame setup.
    }
}