import java.lang.String;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.grid.EditorGridPanel;
import com.gwtext.client.util.AutoWidthColumnModel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.google.gwt.user.client.Window;
import com.gwtext.client.widgets.Button;

public class GridExample {

    public void setupUI() {
        Viewport viewport = new Viewport();

        BorderLayout borderLayout = new BorderLayout();
        Panel topPanel = new Panel();
        topPanel.setLayout(borderLayout);
        viewport.add(topPanel, new BorderLayoutData(BorderLayout.Region.CENTER));

        FitLayout fitLayout = new FitLayout();
        Panel centerPanel = new Panel();
        centerPanel.setLayout(fitLayout);

        // Assuming you have a Store and ColumnModel for your grid
        Store store = createGridStore();
        AutoWidthColumnModel columnModel = createGridColumnModel();

        EditorGridPanel grid = new EditorGridPanel(store, columnModel);
        grid.setEnableColumnHide(false);
        grid.setAutoExpandColumn("name");  // Specify the column to auto-expand
        grid.setLoadMask(true);
        grid.getView().setForceFit(true);  // Ensure view fills available space

        centerPanel.add(grid);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FitLayout());
        // Add your buttons here
        // buttonPanel.addButton(new Button("Click Me"));

        borderLayout.getWestData().setSplit(true);
        topPanel.add(centerPanel, borderLayout.getCenter());
        topPanel.add(buttonPanel, borderLayout.getSouth());

        viewport.setSize(Window.getClientWidth(), Window.getClientHeight());
        viewport.doLayout();
    }

    private Store createGridStore() {
        // Implement logic to create and return a Store
        return new Store();
    }

    private AutoWidthColumnModel createGridColumnModel() {
        // Implement logic to create and return a ColumnModel
        return new AutoWidthColumnModel(new ColumnConfig[]{});
    }

    public static void main(String[] args) {
        // Instantiate and set up the UI
        GridExample example = new GridExample();
        example.setupUI();
    }
}