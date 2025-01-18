import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import android.util.Log;
import androidx.annotation.NonNull;

public class FirebaseDatabaseManager {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("path/to/data");

    public FirebaseDatabaseManager() {
        // Write some Data
        myRef.setValue("Some text data here!");

        // Read some existing data and react to changes
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = (String) snapshot.getValue();
                // Do something with the new data here
            }
        
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("App", "Failed to read value.", error.toException());
            }
        });
    }

    public static void main(String[] args) {
        new FirebaseDatabaseManager();
    }
}