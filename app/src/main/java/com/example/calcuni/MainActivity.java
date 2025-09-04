package com.example.calcuni;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupComponents();
        setupButtonListeners();
    }

    private void setupComponents() {
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        resultTextView = findViewById(R.id.resultTextView);
        addButton = findViewById(R.id.add_button);
        subtractButton = findViewById(R.id.subtract_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divideButton = findViewById(R.id.divide_button);
    }

    private void setupButtonListeners() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operation) {
        double num1 = parseDouble(number1EditText.getText().toString());
        double num2 = parseDouble(number2EditText.getText().toString());
        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultTextView.setText("Error: Cannot divide by zero!");
                    return;
                } else {
                    result = num1 / num2;
                }
                break;
        }


        if (result == (long) result) {
            resultTextView.setText("Result: " + (long) result);
        } else {
            resultTextView.setText("Result: " + result);
        }
    }

    private double parseDouble(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
