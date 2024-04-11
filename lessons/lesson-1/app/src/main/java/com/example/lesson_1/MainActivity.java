package com.example.lesson_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    private EditText text_from_user;
//    private TextView text_for_user;

//    private ImageView imageView;

    private ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });

//        text_from_user = (EditText) findViewById(R.id.txt_in);
//        text_for_user = (TextView) findViewById(R.id.txt_out);

//        Toast.makeText(this, "Start up Alert", Toast.LENGTH_SHORT).show();

//        imageView = (ImageView) findViewById(R.id.image);
//        imageView.setImageResource(R.drawable.pig);

        btn = (ImageButton) findViewById(R.id.imageBtn);
        btn.setBackgroundResource(R.drawable.pig);

    }

//    public void func(View view){
//        String text = text_from_user.getText().toString();
//        text_for_user.setText(text);
//    }
//
//    public void showImage(View view) {
//        if(imageView.getVisibility() == View.INVISIBLE){
//            imageView.setVisibility(View.VISIBLE);
//        }
//        else{
//            imageView.setVisibility(View.INVISIBLE);
//        }
//    }


}