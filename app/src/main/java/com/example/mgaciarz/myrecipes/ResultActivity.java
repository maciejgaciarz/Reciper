package com.example.mgaciarz.myrecipes;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonParser;
import com.google.gson.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ResultActivity extends AppCompatActivity {



    TextView jsonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //findViewById(R.id.JsonDebug);
        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            //json with recipes
            String json = extras.getString("searchValues");

            JsonParser jsonParser = new JsonParser();

            Object object;

            object = jsonParser.parse(json);

            try {
                //name of dish
                //hits : recipe : label

                JsonObject jsonObject = (JsonObject) object;

                //compose - hits
                JsonArray hits = (JsonArray) jsonObject.get("hits");

                ArrayList<String> labels = new ArrayList<>(hits.size());

                for ( int i = 0 ;i<hits.size() ; i++){

                    JsonObject recipe = (JsonObject) hits.get(i);

                    JsonObject rec = (JsonObject) recipe.get("recipe");

                    String label = rec.get("label").toString();

                    labels.add(label);

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, labels);

                ListView listView = (ListView) findViewById(R.id.listView);

                TextView header = new TextView(this);

                header.setTextSize(25);

                header.setTextColor(Color.parseColor("#975A5A"));

                header.setText("Meals found : ");

                header.setTypeface(header.getTypeface(), Typeface.BOLD);

                listView.addHeaderView(header);

                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object listItem = parent.getItemAtPosition(position);

                        Toast.makeText(getBaseContext(), id + 1 + ". " + listItem.toString(), Toast.LENGTH_SHORT);
                    }
                });






            } catch (JsonIOException e) {
                e.printStackTrace();
            }

        }
    }
}
