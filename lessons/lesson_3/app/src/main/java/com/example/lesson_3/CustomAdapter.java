package com.example.lesson_3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomAdapter extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();
    BoxAdapter boxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        for(int i = 0; i < 20; i++) {
            products.add(new Product("product " + i, false));
        }

        boxAdapter = new BoxAdapter(this, products);
        ListView lvMain = findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    public void showResult(View view) {
        String result = "";
        for (Product product : boxAdapter.getBox()) {
           if (product.isChecked) {
               result += product.name + "\n";
           }
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }


}