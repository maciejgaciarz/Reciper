package com.example.mgaciarz.myrecipes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonParser;
import com.google.gson.*;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Recipe;

public class ResultActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String json = extras.getString("searchValues");

            final List<Recipe> recipes = new JSONObjectWrapper().getRecipes(json);

            ListView list;

            list = findViewById(R.id.list);

            ListAdapter adapter = new ListAdapter(this, recipes);

            if(adapter!=null){
                list.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Adapter found!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Adapter not found", Toast.LENGTH_SHORT).show();
            }

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(getApplicationContext(),
//                            "Click ListItem Number " + position, Toast.LENGTH_SHORT)
//                            .show();


                    //start new activity for seeing one dish and pass recipe to it
                    Intent i = new Intent(getApplicationContext(),SingleDishActivity.class);

                    i.putExtra("recipe", recipes.get(position));
                    i.putExtra("position", position);

                    getApplicationContext().startActivity(i);
                }
            });
        }
    }
}