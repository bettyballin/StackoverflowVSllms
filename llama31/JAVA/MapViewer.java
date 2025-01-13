import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.DefaultMapContext;
import org.geotools.map.MapContext;
import org.geotools.swing.JMapPane;
import org.geotools.swing.JMapStatusBar;

import javax.swing.*;
import java.awt.*;

public class MapViewer {
    public static void main(String[] args) throws Exception {
        // Load the shapefile
        FileDataStore store = FileDataStoreFinder.getDataStore("path/to/shapefile.shp");
        SimpleFeatureSource source = store.getFeatureSource();

        // Create a map context
        MapContext map = new DefaultMapContext();
        map.addLayer(source, "Shapefile Layer");

        // Create a JMapPane to display the map
        JMapPane mapPane = new JMapPane(map);

        // Add a status bar to display coordinates
        JMapStatusBar statusBar = new JMapStatusBar(mapPane);

        // Add the map pane and status bar to your Swing application
        JFrame frame = new JFrame("Map Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mapPane, BorderLayout.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
        frame.setSize(800, 600); // added this line to set the frame size
        frame.setVisible(true);
    }
}