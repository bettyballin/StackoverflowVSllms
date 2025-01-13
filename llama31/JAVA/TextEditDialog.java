import android.app.Activity;
import android.app.DialogFragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

// Create a custom DialogFragment
public class TextEditDialog extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_edit_dialog, container, false);
        EditText editText = (EditText) view.findViewById(R.id.edit_text);

        // Fog out the background
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.dimAmount = 0.5f;
        getDialog().getWindow().setAttributes(layoutParams);

        // Rotate the screen to landscape
        getDialog().getWindow().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        return view;
    }

    public static void main(String[] args) {
        // This will not show the dialog, as it needs to be run on an Android device
        // To show the dialog, you would need to use an Activity's FragmentManager
    }
}