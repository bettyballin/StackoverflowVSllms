import java.awt.*;
import java.io.File;
import javax.swing.*;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;

// Import JMapPane
import org.geotools.swing.JMapPane;

public class MapFrame extends JFrame {
    public static void main(String[] args) throws Exception {
        // Path to your shapefile
        String shpPath = "path/to/your/shapefile.shp";
    
        // Open the data store
        FileDataStore fileDataStore = FileDataStoreFinder.getDataStore(new File(shpPath));
        SimpleFeatureSource featureSource = fileDataStore.getFeatureSource();
    
        // Create a style for the layer
        Style style = SLD.createSimpleStyle(featureSource.getSchema());
    
        // Create a map content and add the feature layer to it
        MapContent map = new MapContent();
        map.addLayer(new FeatureLayer(featureSource, style));
    
        // Set up the frame with the panel
        JFrame frame = new MapFrame(map);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public MapFrame(MapContent map) {
        this.setSize(800, 600);
        this.setTitle("GeoTools Example");
    
        JMapPane mapPane = new JMapPane();
        mapPane.setMapContent(map);
        mapPane.setPreferredSize(new Dimension(800, 600));

        this.add(new JScrollPane(mapPane), BorderLayout.CENTER);

        // Optionally add custom drawing on top of the map
        // You can add custom rendering code here if needed
    }
}