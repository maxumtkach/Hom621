package com.example.hom6_2_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Lifecycle";
    int ActivityNumber = 0;
    private TextView messagePhoto;
    Random random ;

    int min = 0;
    int max = 100;
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random(System.currentTimeMillis());  //инициализация переменных
        ActivityNumber = min + random.nextInt(max - min + 1);
        String photoString = getResources().getString(R.string.photo);


        messagePhoto = findViewById(R.id.text_message_photo);
        messagePhoto.setText(getString(R.string.welcome_messages,photoString,ActivityNumber));

        Button clickStartButton = findViewById(R.id.button_start);
        clickStartButton.setOnClickListener(clickStartListener);

        Button clickEndButton = findViewById(R.id.button_end);
        clickEndButton.setOnClickListener(clickEndListener);
    }

    private final View.OnClickListener clickStartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private final View.OnClickListener clickEndListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart "+ActivityNumber );
        messagePhoto.append("\n" + "onStart"+ActivityNumber);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume "+ActivityNumber);
        messagePhoto.append("\n" + "onResume"+ActivityNumber);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause "+ActivityNumber);
        messagePhoto.append("\n" + "onPause"+ActivityNumber);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop " + ActivityNumber);
        messagePhoto.append("\n" + "onStop"+ActivityNumber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy " + ActivityNumber);
        messagePhoto.append("\n" + "onDestroy"+ActivityNumber);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart " + ActivityNumber);
        messagePhoto.append("\n" + "onRestart"+ActivityNumber);
    }

}
