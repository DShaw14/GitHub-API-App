package com.example.githubapiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    //Declare RecyclerView, corresponding adapter and layout manager
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager rLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.commit_recycler_view);

        //Retrieve dataSet from GitHub call
        String[] dataSet = apiCall("https://api.github.com/repositories");

        recyclerView.setHasFixedSize(true);

        rLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rLayoutManager);

        rAdapter = new ViewAdapter(dataSet);
        recyclerView.setAdapter(rAdapter);

    }

    private String[] apiCall(String url){
        final String[] callResponse = new String[25];
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    public void onResponse(JSONArray response) {
                        //retrieve data for repositories up to 25 entries, assign to dataSet
                        try {
                            int counter = 0;
                            while (counter < 25)
                            {
                                callResponse[counter] = response.getString(counter);
                                counter++;
                            }
                        } catch (JSONException error) {
                            callResponse[0] = error.toString();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callResponse[0] = error.toString();
            }
        });

        queue.add(jsonArrayRequest);
        return callResponse;
    }
}
