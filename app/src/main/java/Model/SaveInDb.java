package Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveInDb {


    public void saveData(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("https://wochenenddb-default-rtdb.europe-west1.firebasedatabase.app");

        myRef.setValue("Hello, World!");
    }
}
