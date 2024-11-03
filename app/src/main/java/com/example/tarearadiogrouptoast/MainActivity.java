package com.example.tarearadiogrouptoast;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        RadioGroup radioGroupColores = findViewById(R.id.radioGroupColores);

        radioGroupColores.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = group.findViewById(checkedId);
                String colorName = selectedRadioButton.getText().toString();
                int colorCode = Color.BLACK;

                if (checkedId == R.id.radioRojo) {
                    colorCode = Color.RED;
                } else if (checkedId == R.id.radioAzul) {
                    colorCode = Color.BLUE;
                } else if (checkedId == R.id.radioAmarillo) {
                    colorCode = Color.YELLOW;
                }

                Toast toast = Toast.makeText(MainActivity.this, colorName, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                //toast.getView().findViewById(android.R.id.message).setBackgroundColor(colorCode);
                toast.show();
            }
        });
    }
}