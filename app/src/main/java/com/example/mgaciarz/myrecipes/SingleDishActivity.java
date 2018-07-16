package com.example.mgaciarz.myrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import models.Recipe;

public class SingleDishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_dish);

        ImageView dishImage = findViewById(R.id.singleDishImage);
        TextView dishDesc = findViewById(R.id.singleDishDescription);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            Recipe recipe = extras.getParcelable("recipe");
            int position = extras.getInt("position");

            setTitle(recipe.getLabel());

            Picasso.get().load(recipe.getImageURL()).into(dishImage);
            dishDesc.setText(recipe.getInstructionURL());

        }


    }



}
