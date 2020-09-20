package com.example.gpa_stojanovr1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText e1, e2, e3, e4, e5;
    TextView tView, tViewWarning;
    int count = 0;
    View view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.white);

        btn = (Button) findViewById(R.id.b);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        tView = (TextView) findViewById(R.id.t);
        tViewWarning = (TextView) findViewById(R.id.warning);
        tView.setBackgroundColor(Color.TRANSPARENT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float g1, g2, g3, g4, g5;
                if (count % 2 == 0) {
                    if (e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("") || e4.getText().toString().equals("") || e5.getText().toString().equals("")) {
                        tViewWarning.setText("Please Enter your Grades");
                        tViewWarning.setTextColor(Color.rgb(255,0,0));

                    } else {
                        g1 = Float.parseFloat(e1.getText().toString());
                        g2 = Float.parseFloat(e2.getText().toString());
                        g3 = Float.parseFloat(e3.getText().toString());
                        g4 = Float.parseFloat(e4.getText().toString());
                        g5 = Float.parseFloat(e5.getText().toString());
                        float average = g1 + g2 + g3 + g4 + g5;
                        average = average / 5;
                        if (average <= 60) {
                            tView.setText(Float.toString(average));
                            view.setBackgroundResource(R.color.red);
                        } else if (average > 60 && average < 80) {
                            tView.setText(Float.toString(average));
                            view.setBackgroundResource(R.color.yellow);
                        } else if (average >= 80 && average <= 100) {
                            tView.setText(Float.toString(average));
                            view.setBackgroundResource(R.color.green);
                        }
                        count++;
                        btn.setText("Clear Form");
                        tViewWarning.setText("");
                    }

                } else {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    tView.setText("");
                    view.setBackgroundResource(R.color.white);
                    btn.setText("Compute GPA");
                    count++;
                }

            }
        });

    }
}
