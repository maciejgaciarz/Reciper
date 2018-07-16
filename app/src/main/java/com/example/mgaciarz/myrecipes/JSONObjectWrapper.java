package com.example.mgaciarz.myrecipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import models.Recipe;

public class JSONObjectWrapper {

    public List<Recipe> getRecipes(String JSON){

        ArrayList<Recipe> recipes = new ArrayList<>();

        try {

            JsonParser jsonParser = new JsonParser();

            Object object = jsonParser.parse(JSON);

            JsonObject jsonObject = (JsonObject) object;

            JsonArray hits = (JsonArray) jsonObject.get("hits");

            //loop through json to get name of dish, Recipe URL and image URL
            for (int i = 0; i < hits.size(); i++) {

                JsonObject currentRecipeObject = (JsonObject) hits.get(i);

                JsonObject currentRecipe = (JsonObject) currentRecipeObject.get("recipe");

                String label = currentRecipe.get("label").toString();
                String recipeUri = currentRecipe.get("uri").toString();
                String imageUri = currentRecipe.get("image").toString();

                Recipe recipe = new Recipe(label, imageUri, recipeUri, i);

                recipes.add(recipe);
            }


        } catch (JsonParseException e){
            e.printStackTrace();
        }

        return recipes;

    }

}
