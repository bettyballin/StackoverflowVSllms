import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordViewModel extends ViewModel {
    private MutableLiveData<Boolean> isRecording = new MutableLiveData<>();

    public LiveData<Boolean> getIsRecording() {
        return isRecording;
    }

    public void startRecording() {
        isRecording.setValue(true);
    }
}

public class MyActivity extends AppCompatActivity {
    private RecordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // You need to set the content view, I assume you have a layout named activity_main
        setContentView(R.layout.activity_main);
        
        viewModel = ViewModelProviders.of(this).get(RecordViewModel.class);
        viewModel.getIsRecording().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isRecording) {
                if (isRecording) {
                    onRecordStart();
                }
            }
        });
        
        setButtonClickListener();
    }

    private void setButtonClickListener() {
        Button recordButton = findViewById(R.id.record_button);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.startRecording();
            }
        });
    }

    private void onRecordStart() {
        // Perform actions when record starts
    }
}