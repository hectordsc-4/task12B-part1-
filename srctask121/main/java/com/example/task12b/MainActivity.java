package com.example.task12b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int number = 0;
    private TextView numberTextView;

    private static final String KEY_NUMBER = "key_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.text_number);

        // Restaurar número guardado si existe
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(KEY_NUMBER, 0);
        }
        updateNumberText();

        Button incrementButton = findViewById(R.id.button_increment);
        Button decrementButton = findViewById(R.id.button_decrement);
        Button toastButton = findViewById(R.id.button_toast);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                updateNumberText();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number--;
                updateNumberText();
            }
        });

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Number: " + number, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBER, number);
    }

    private void updateNumberText() {
        numberTextView.setText(String.valueOf(number));
    }
}