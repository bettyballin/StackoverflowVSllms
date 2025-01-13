import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity_2_2 extends AppCompatActivity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == WM_RECORD_START) {
                onRecordStart();
            }
        }
    };

    private static final int WM_RECORD_START = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set your layout here
        // setContentView(R.layout.your_layout);
        setButtonClickListener();
    }

    private void setButtonClickListener() {
        Button recordButton = findViewById(R.id.record_button);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(WM_RECORD_START);
            }
        });
    }

    private void onRecordStart() {
        // Perform actions when record starts
    }

    public static void main(String[] args) {
    }
}