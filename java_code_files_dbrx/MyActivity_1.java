import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MyActivity_1 extends TabActivity {
    Button btn1, btn2;  // Declare global variables for Buttons
    TabSpec fiRST_TAB, secOND_TAB; // Declare TabSpec variables

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost = getTabHost();

        // Inflate first layout into tabs
        LayoutInflater.from(this).inflate(R.layout.fiRST_TAB, tabHost.getTabContentView(), true);
        fiRST_TAB = tabHost.newTabSpec("First Tab")
                .setIndicator("FIRST TAB", getResources().getDrawable(R.drawable.ic_tab))
                .setContent(R.id.fiRST_TAB);

        btn1 = findViewById(R.id.btn1_first_tab); // Initialize button to avoid NullPointerException
        btn1.setOnClickListener(new OnClickListener() {  // Attach click listener for the first button
            @Override
            public void onClick(View v) {
                // Button logic for first tab goes here...
            }
        });

        // Inflate second layout into tabs
        LayoutInflater.from(this).inflate(R.layout.secND_TAB, tabHost.getTabContentView(), true);
        secOND_TAB = tabHost.newTabSpec("Second Tab")
                .setIndicator("SECOND TAB", getResources().getDrawable(R.drawable.ic_tab))
                .setContent(R.id.secOND_TAB);

        btn2 = findViewById(R.id.btn2_second_tab); // Initialize button to avoid NullPointerException
        btn2.setOnClickListener(new OnClickListener() {  // Attach click listener for the second button
            @Override
            public void onClick(View v) {
                // Button logic for second tab goes here...
            }
        });

        // Add all tabs into TabHost
        tabHost.addTab(fiRST_TAB);
        tabHost.addTab(secOND_TAB);
    }

    public static void main(String[] args) {
        // Main method if needed
    }
}