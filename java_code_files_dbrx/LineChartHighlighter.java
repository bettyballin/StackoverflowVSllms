import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LineChartHighlighter {

    public static void main(String[] args) {
        OFGlinechart myLineChart = new OFGlinechart();
        myLineChart.setTitle(new OFLtitle("My Line Chart"));
        myLineChart.addX_label("Item 1");
        myLineChart.addX_label("Item 2");
        myLineChart.addX_label("Item 3"); // Items added to x-axis

        List<OFGgraphdata> lineData = new ArrayList<>();
        lineData.add(new OFGgraphdata("Series 1", 5, 7, 8)); // Data for each series
        myLineChart.setGraph_data(lineData);

        // Create and set graph properties to highlight the second item (Item 2) on x-axis:
        OFGdot myDot = new OFGdot();
        myDot.addGraph_anchor(new OFAgraph_anchor("Item 2")); // Set anchor at Item 2
        myDot.setShape(OFADynamic.create_shape(OFS_STYLE.circle, 0)); // Use a circle shape for the highlighting dot
        myDot.setColour(new OFAcolour("#ff0000")); // Highlight color (in this case red)
        myLineChart.addDataElements(Arrays.asList(myDot));

        // Set line properties
        myLineChart.getGraph_line().setWidth(1);  // Default line width with no highlighting
        for (OFGgraphdata g : myLineChart.getGraph_data()) {
            if (!g.getVals().get(1).getName().equals("Item 2")){ // All lines except the second one
                g.getGraph_line().setWidth(3); // Wider line to show more visible highlighting
                g.getGraph_line().setColour(new OFAcolour("#007acc")); // Highlight color for the highlighted line parts (in this case blue)
            } else { // Second item - use normal color and width
                g.getGraph_line().setWidth(1); // Normal width (as declared above when all lines are considered)
                g.getGraph_line().setColour(new OFAcolour("#ff0000")); // Color of the line parts at this point, use same color as dot
            }
        }
    }
}

// Define the necessary classes to make the code executable
class OFGlinechart {
    private OFLtitle title;
    private List<String> xLabels = new ArrayList<>();
    private List<OFGgraphdata> graphData;
    private OFGline graphLine = new OFGline();
    public void setTitle(OFLtitle title) { this.title = title; }
    public void addX_label(String label) { xLabels.add(label); }
    public void setGraph_data(List<OFGgraphdata> data) { this.graphData = data; }
    public void addDataElements(List<OFGdot> dots) { /* Implementation */ }
    public OFGline getGraph_line() { return graphLine; }
    public List<OFGgraphdata> getGraph_data() { return graphData; }
}

class OFLtitle {
    public OFLtitle(String title) { /* Implementation */ }
}

class OFGgraphdata {
    private String name;
    private List<OFGval> vals = new ArrayList<>();
    private OFGline graphLine = new OFGline();
    public OFGgraphdata(String name, int... values) {
        this.name = name;
        for (int val : values) {
            vals.add(new OFGval(val));
        }
    }
    public List<OFGval> getVals() { return vals; }
    public OFGline getGraph_line() { return graphLine; }
}

class OFGval {
    private int value;
    public OFGval(int value) { this.value = value; }
    public String getName() { return "Item " + value; }
}

class OFGline {
    public void setWidth(int width) { /* Implementation */ }
    public void setColour(OFAcolour colour) { /* Implementation */ }
}

class OFGdot {
    public void addGraph_anchor(OFAgraph_anchor anchor) { /* Implementation */ }
    public void setShape(Object shape) { /* Implementation */ }
    public void setColour(OFAcolour colour) { /* Implementation */ }
}

class OFAgraph_anchor {
    public OFAgraph_anchor(String anchor) { /* Implementation */ }
}

class OFADynamic {
    public static Object create_shape(OFS_STYLE style, int param) { return new Object(); }
}

enum OFS_STYLE {
    circle
}

class OFAcolour {
    public OFAcolour(String color) { /* Implementation */ }
}