package com.example.lesson_4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //    ImageView imageView;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.name);
        textView = findViewById(R.id.result);

//        imageView = findViewById(R.id.img);
    }


    public void getData(View view) {
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        } else {
            RequestQueue volleyQueue = Volley.newRequestQueue(MainActivity.this);
            String url = "https://api.nationalize.io/?name=" + name;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET, url, null,
                    (Response.Listener<JSONObject>) response -> {
                        try {
                            JSONArray array = response.getJSONArray("country");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject country = array.getJSONObject(i);

                                double probability = country.getDouble("probability");
                                String country_id = country.getString("country_id");
                                textView.append(country_id + "-" + probability + "\n");
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    },
                    (Response.ErrorListener) error -> {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
            );
            volleyQueue.add(jsonObjectRequest);
        }
    }

//    public void getImg(View view) {
//        RequestQueue volleyQueue = Volley.newRequestQueue(MainActivity.this);
//        String url = "https://dog.ceo/api/breeds/image/random";
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                Request.Method.GET, url, null,
//                (Response.Listener<JSONObject>) response -> {
//                    String dogImageUrl;
//                    try {
//                        dogImageUrl = response.getString("message");
//                        Glide.with(MainActivity.this).load(dogImageUrl).into(imageView);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                (Response.ErrorListener) error -> {
//                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
//                }
//        );
//        volleyQueue.add(jsonObjectRequest);
//    }
}