package com.github.snowparrot.pacalc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class calcActivity extends Activity {

    TextView numberView;
    String numberViewContent = "";
    operations usedOperation;


    Long firstNumber = 0L;
    Boolean IsUsertypingSecondNumber = false; // zeigt, ob erste oder zweite Number eingegeben wird


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        Button Button0 = findViewById(R.id.Button0);
        Button Button1 = findViewById(R.id.Button1);
        Button Button2 = findViewById(R.id.Button2);
        Button Button3 = findViewById(R.id.Button3);
        Button Button4 = findViewById(R.id.Button4);
        Button Button5 = findViewById(R.id.Button5);
        Button Button6 = findViewById(R.id.Button6);
        Button Button7 = findViewById(R.id.Button7);
        Button Button8 = findViewById(R.id.Button8);
        Button Button9 = findViewById(R.id.Button9);

        ImageButton multButton = findViewById(R.id.multiplyButton);
        ImageButton divideButton = findViewById(R.id.divideButton);
        ImageButton subButton = findViewById(R.id.subtractButton);
        ImageButton addButton = findViewById(R.id.addButton);

        ImageButton equalButton = findViewById(R.id.equalButton);

        Button clearButton = findViewById(R.id.clearButton);



        numberView = findViewById(R.id.numberView);
        numberView.setText(numberViewContent);


        Button0.setOnClickListener(getOCLfromNumber(0));
        Button1.setOnClickListener(getOCLfromNumber(1));
        Button2.setOnClickListener(getOCLfromNumber(2));
        Button3.setOnClickListener(getOCLfromNumber(3));
        Button4.setOnClickListener(getOCLfromNumber(4));
        Button5.setOnClickListener(getOCLfromNumber(5));
        Button6.setOnClickListener(getOCLfromNumber(6));
        Button7.setOnClickListener(getOCLfromNumber(7));
        Button8.setOnClickListener(getOCLfromNumber(8));
        Button9.setOnClickListener(getOCLfromNumber(9));

        multButton.setOnClickListener(getOCLfromOperation(operations.MULTIPLY));
        addButton.setOnClickListener(getOCLfromOperation(operations.ADD));
        subButton.setOnClickListener(getOCLfromOperation(operations.SUBTRACT));
        divideButton.setOnClickListener(getOCLfromOperation(operations.DIVIDE));

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberViewContent = "";
                numberView.setText("");
                IsUsertypingSecondNumber = false;
            }

        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (IsUsertypingSecondNumber) {
                   long usedSecondNumber = Long.valueOf(numberViewContent);
                    numberView.setText(calculate(firstNumber, usedOperation, usedSecondNumber));
                    numberViewContent = "";
                    IsUsertypingSecondNumber = false;
            }
            }
        });



    }


    private Button.OnClickListener getOCLfromNumber(final long Number)
    {

        return new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberViewContent += Long.toString(Number);
                numberView.setText(numberViewContent);
            }
        };
    }


    private Button.OnClickListener getOCLfromOperation(final operations op)
    {
        return new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (IsUsertypingSecondNumber){
                    Context context = getApplicationContext();
                    CharSequence text = "Nur eine Operation möglich";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    firstNumber = Long.valueOf(numberViewContent);
                    numberViewContent = "";
                    IsUsertypingSecondNumber = true;
                    numberView.setText(numberViewContent);
                    usedOperation = op;
                }
            }
        };

    }


    private String calculate(long firstNumber, operations op, long secondNumber)
    {
        switch (op) {
            case ADD:
                return Long.toString(firstNumber + secondNumber);
            case MULTIPLY:
                return Long.toString(firstNumber * secondNumber);
            case SUBTRACT:
                return Long.toString(firstNumber - secondNumber);
            case DIVIDE:
                float firstNumberfl = firstNumber;
                float secondNumberfl = secondNumber;
                return Float.toString(firstNumberfl / secondNumberfl);
        }
        return "ERROR";
    }
}
