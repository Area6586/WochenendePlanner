package com.example.wochenendeplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;

import java.util.ArrayList;

import Controller.Event;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    listview = findViewById(R.id.Listview);

    ArrayList<Event> arrayList = new ArrayList<Event>();
    arrayList.add(new Event(5, "test",20-05-2022,"test","Weingarten"));
    arrayList.add(new Event();
    arrayList.add(new Event( 51, "test3", 3-05-2022, "test3", "We"));
    arrayList.add(new Event( 54, "test4", 2-05-2022, "test4", "Wein"));


