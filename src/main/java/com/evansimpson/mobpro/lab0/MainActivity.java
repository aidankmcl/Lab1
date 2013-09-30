package com.evansimpson.mobpro.lab0;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> my2Do;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView) findViewById(R.id.listView);
        my2Do = new ArrayList<String>();

        final Adapter rockOn = new Adapter(this, my2Do);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(rockOn);


        Button add = (Button) findViewById(R.id.button_send);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTodo(view, rockOn);
            }
        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    }

    public void addTodo(View view, Adapter rockOn) {
        EditText newTask = (EditText) findViewById(R.id.editText);
        String work = newTask.getText().toString();
//        Toast.makeText(this, work, Toast.LENGTH_SHORT).show();

        if (work != " ") {
        rockOn.add(work);
        rockOn.notifyDataSetChanged();
        }
    }

    public void destroy(View view) {
//        Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();

    }
}
