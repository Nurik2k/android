package com.example.lesson_2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout LL1 = (LinearLayout) findViewById(R.id.ll1);
        for(int i = 0; i < 50; i++) {
            TextView TV = new TextView(this);
            TV.setText("Hello World" + i);
            TV.setTextSize(TypedValue.COMPLEX_UNIT_PT, 10);
            TV.setTextColor(Color.rgb(128, 64 + i * 2, 128));
            TV.setGravity(Gravity.CENTER_HORIZONTAL);
            LL1.addView(TV);
        }
    }



    //Variable 1
//    public void onCheckClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//
//        int android = R.id.checkbox_android;
//        int xml = R.id.checkbox_xml;
//        int java = R.id.checkbox_java;
//        textView = (TextView) findViewById(R.id.txt_out);
//
//        if (view.getId() == android) {
//            if (checked)
//                textView.append("\nAndroid\n");
//            else
//                removeWordFromTextView(textView, "Android");
//        } else if (view.getId() == xml) {
//            if (checked)
//                textView.append("\nXml\n");
//            else
//                removeWordFromTextView(textView, "Xml");
//        } else if (view.getId() == java) {
//            if (checked)
//                textView.append("\nJava\n");
//            else
//                removeWordFromTextView(textView, "Java");
//        }
//    }
//
//    private void removeWordFromTextView(TextView textView, String wordToRemove) {
//        String originalText = textView.getText().toString();
//        String newText = originalText.replaceAll(wordToRemove, " ");
//        textView.setText(newText.trim());
//    }

    //Variable 2
//    public void onCheckClicked(View view){
//        String res = "";
//        textView = (TextView) findViewById(R.id.txt_out);
//
//        boolean fir = ((CheckBox) findViewById(R.id.checkbox_android)).isChecked();
//        boolean sec = ((CheckBox) findViewById(R.id.checkbox_xml)).isChecked();
//        boolean thi = ((CheckBox) findViewById(R.id.checkbox_java)).isChecked();
//
//        if (fir) {
//            res += "Android\n";
//        }
//        if (sec) {
//            res += "Xml\n";
//        }
//        if (thi) {
//            res += "Java\n";
//        }
//
//        textView.setText(res);
//    }
}

