package com.github.snowparrot.pacalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class calcActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        Button Button0 = (Button)findViewById(R.id.Button0);
        Button Button1 = (Button)findViewById(R.id.Button1);
        Button Button2 = (Button)findViewById(R.id.Button2);
        Button Button3 = (Button)findViewById(R.id.Button3);
        Button Button4 = (Button)findViewById(R.id.Button4);
        Button Button5 = (Button)findViewById(R.id.Button5);
        Button Button6 = (Button)findViewById(R.id.Button6);
        Button Button7 = (Button)findViewById(R.id.Button7);
        Button Button8 = (Button)findViewById(R.id.Button8);
        Button Button9 = (Button)findViewById(R.id.Button9);

        ImageButton multButton = (ImageButton)findViewById(R.id.multiplyButton);
        ImageButton divideButton = (ImageButton)findViewById(R.id.divideButton);
        ImageButton subButton = (ImageButton)findViewById(R.id.subtractButton);
        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);

        Button clearButton = (Button)findViewById(R.id.clearButton);

        TextView numberView = (TextView)findViewById(R.id.numberView);



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

    }


    private Button.OnClickListener getOCLfromNumber(int Number)
    {
        return null;
    }
}
