import android.app.TabActivity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity_3 extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost = getTabHost();

        // Tab 1
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, FirstTab.class);
        spec = tabHost.newTabSpec("First").setIndicator("First Tab", getResources().getDrawable(R.drawable.icon)).setContent(intent);
        tabHost.addTab(spec);

        // Tab 2
        intent = new Intent().setClass(this, SecondTab.class);
        spec = tabHost.newTabSpec("Second").setIndicator("Second Tab", getResources().getDrawable(R.drawable.icon)).setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0); // Set the default selected tab when the activity is launched
    }

    public static class FirstTab extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.first_tab_layout);

            Button btn = (Button) findViewById(R.id.buttonInFirstTab);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for First Tab
                    Toast.makeText(getApplicationContext(), "Button in First Tab clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static class SecondTab extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second_tab_layout);

            Button btn = (Button) findViewById(R.id.buttonInSecondTab);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle button click for Second Tab
                    Toast.makeText(getApplicationContext(), "Button in Second Tab clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void main(String[] args) {
    }
}

// Dummy R class to resolve references
class R {
    public static class layout {
        public static int main;
        public static int first_tab_layout;
        public static int second_tab_layout;
    }

    public static class drawable {
        public static int icon;
    }

    public static class id {
        public static int buttonInFirstTab;
        public static int buttonInSecondTab;
    }
}