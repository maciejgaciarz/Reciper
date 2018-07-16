package com.example.mgaciarz.myrecipes;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import models.Recipe;

public class ListAdapter extends BaseAdapter {

    private Activity activity;
    private static LayoutInflater inflater=null;
    private List<Recipe> recipes;

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {

            return recipes.get(position).getId();
        }

    public ListAdapter(Activity activity, List<Recipe> recipes) {
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.recipes = recipes;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, parent,false);
            //vi = inflater.inflate(R.layout.list_row, null);

        TextView dishName = (TextView)vi.findViewById(R.id.dishName);
        TextView dishDesc = (TextView)vi.findViewById(R.id.dishDescription);
        ImageView dishImage =(ImageView) vi.findViewById(R.id.dishImage);

        Recipe recipe = recipes.get(position);


        dishName.setText(recipe.getLabel());
        dishDesc.setText(recipe.getInstructionURL());

        //download image directly into ImageView
        Picasso.get().load(recipe.getImageURL()).into(dishImage);


        return vi;
    }


}
