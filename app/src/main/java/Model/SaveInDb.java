package Model;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveInDb {


    public void saveData(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Log.d("Database","I'm from SaveInDb!");
        myRef.setValue("Hello, World Android");

    }
}
