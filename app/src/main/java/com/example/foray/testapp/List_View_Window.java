package com.example.foray.testapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List_View_Window extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view__window);

        //Initialize the List View//

        String [] friends = {"Karthi","Arivu","Joe","Maris","Vignesh","Kamaraj","Anand","Rakesh","Yash","Lee","San","Siva","Raj","Prem","SivaRaju"};
        ListAdapter mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friends);
        ListView exlistv1 = (ListView) findViewById(R.id.exlistv1);
        exlistv1.setAdapter(mAdapter);

        exlistv1.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String friends = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(List_View_Window.this,friends,Toast.LENGTH_LONG).show();

                    }
                }
        );



    }
}
