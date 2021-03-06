package com.example.mgaciarz.myrecipes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Result;

/**
 * Created by mgaciarz on 2018-04-26.
 */

public class JSONDownloader extends AsyncTask<String, Void, String> {


    private Context context;
    private String api_key;
    private String app_id;

    private final String searchRequestURL = "https://api.edamam.com/search?q=";


    JSONDownloader(Context context) {
        this.context = context;
        this.api_key = context.getResources().getString(R.string.api_key);
        this.app_id = context.getResources().getString(R.string.app_id);
    }


    protected String doInBackground(String... params) {


        String liveUpdateUrl = searchRequestURL + params[0] + "&app_id=" + app_id + "&app_key=" + api_key;
        HttpsURLConnection con;
        InputStream in = null;
        String result = "";
        try {
            JSONObject jObj = null;

            URL url = new URL(liveUpdateUrl);

            con = (HttpsURLConnection) url.openConnection();

            in = new BufferedInputStream(con.getInputStream());

            BufferedReader bReader = new BufferedReader(new InputStreamReader(in, "utf-8"), 8);
            StringBuilder sBuilder = new StringBuilder();

            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
            in.close();


            result = sBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new String("error");
        } catch (IOException e) {
            e.printStackTrace();
            return new String("error");
        }
        return result;

    }

    protected void onPostExecute(String result) {

        Intent i = new Intent(context, ResultActivity.class);
        i.putExtra("searchValues", result);
        context.startActivity(i);
    }


}