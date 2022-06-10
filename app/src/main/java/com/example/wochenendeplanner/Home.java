package com.example.wochenendeplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Home extends AppCompatActivity {

    private final String TAG = Home.class.getSimpleName();
    ListView simpleList;
    ListView simpleList1;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand", "USA", "Harding"};
    String countryList1[] = {"Das", "Das","Das","Das","Das","Das","Das"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        simpleList = (ListView)findViewById(R.id.listView);
        //simpleList1 = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_row, R.id.txtName, countryList);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.list_row, R.id.txtDes, countryList1);

        simpleList.setAdapter(arrayAdapter1);
        //simpleList1.setAdapter(arrayAdapter1);

        Log.i("listview", "onCreate: " +
                "");
    }
}