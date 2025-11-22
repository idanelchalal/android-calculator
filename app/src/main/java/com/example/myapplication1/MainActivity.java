package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView displayTextView;
    char selectedOperator;
    int firstOperand;
    int secondOperand;

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

        displayTextView = findViewById(R.id.textViewResult);
        displayTextView.setText("");

    }

    public void onNumberButtonClick(View view) {
        Button button = (Button) view;
        String str = button.getText().toString();
        displayTextView.append(str);
    }

    public void onOperatorButtonClick(View view) {
        Button button = (Button) view;
        selectedOperator = button.getText().toString().charAt(0);
        firstOperand = (int) Double.parseDouble(displayTextView.getText().toString());
        displayTextView.setText("");
    }

    public void onEqualsButtonClick(View view) {
        double res = 0;
        Button button = (Button) view;
        secondOperand = (int) Double.parseDouble(displayTextView.getText().toString());

        switch (selectedOperator) {
            case '+':
                res = firstOperand + secondOperand;
                break;
            case '-':
                res = firstOperand - secondOperand;
                break;
            case 'X':
                res = firstOperand * secondOperand;
                break;
            case '/':
                res = firstOperand / secondOperand;
                break;
        }
        displayTextView.setText(res + "");
    }
    }


