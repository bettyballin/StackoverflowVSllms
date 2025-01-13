import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;

public class TabActivityController extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();

        // Inflate the layout for the first tab
        View firstTabView = LayoutInflater.from(this).inflate(R.layout.first_tab_layout, null);
        tabHost.addTab(tabHost.newTabSpec("first").setIndicator("First Tab").setContent(new TabContentFactory() {
            public View createTabContent(String tag) {
                return firstTabView;
            }
        }));

        // Find the button in the first tab layout and set the OnClickListener
        Button firstTabButton = (Button) firstTabView.findViewById(R.id.firstTabButton);
        firstTabButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Handle button click
            }
        });
    }

    public static void main(String[] args) {
    }
}