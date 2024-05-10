package com.example.testfirebase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //private FirebaseAuth mAuth;
    private FirebaseStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView stv = findViewById(R.id.songTV);
        TextView vtv = findViewById(R.id.videoTV);
        TextView itv = findViewById(R.id.imageTV);

        storage = FirebaseStorage.getInstance("gs://testfirebase-90117.appspot.com");

        StorageReference myImageRef = storage.getReference().child("pig.jpg");
        final long ONE_MEGABYTE = 1024 * 1024;
        myImageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                itv.setText("Image downloaded");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                itv.setText("Failed to download image");
            }
        });

        StorageReference mySongRef = storage.getReference().child("Recording.m4a");
        final long SONG_SIZE = 241953;
        mySongRef.getBytes(SONG_SIZE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                stv.setText("Song downloaded");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                stv.setText("Failed to download song");
            }
        });

        StorageReference myVideoRef = storage.getReference().child("testFirebase - Storage - Files - Firebase console - Google Chrome 2024-05-03 20-50-09.mp4");
        final long VIDEO_SIZE = 7925308;
        myVideoRef.getBytes(VIDEO_SIZE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                vtv.setText("Video downloaded");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                vtv.setText("Failed to download video");
            }
        });

    }

//    public void signUp(View view){
//        mAuth = FirebaseAuth.getInstance();
//        String email = ((EditText) findViewById(R.id.email)).getText().toString();
//        String password = ((EditText) findViewById(R.id.password)).getText().toString();
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    Toast.makeText(MainActivity.this, user.getEmail(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

//    public void signIn(View view){
//        mAuth = FirebaseAuth.getInstance();
//        String email = ((EditText) findViewById(R.id.email)).getText().toString();
//        String password = ((EditText) findViewById(R.id.password)).getText().toString();
//        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    Toast.makeText(MainActivity.this, "Signed in as " + user.getEmail(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Sign in failed.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}