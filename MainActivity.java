package com.example.s10189894_mad_wk2_practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonMiddle;
    private TextView scoreChanger;
    private Integer count = 0;
    private String leftChecker;
    private String middleChecker;
    private String rightChecker;
    private static final String TAG = "TripleButton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeft = (Button) findViewById(R.id.Button1);
        buttonMiddle = (Button) findViewById(R.id.Button2);
        buttonRight = (Button) findViewById(R.id.Button3);
        scoreChanger = (TextView) findViewById(R.id.score);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 1 clicked");
                if (leftChecker == "*") {
                    count += 1;
                    scoreChanger.setText(""+count);
                }else
                    {
                        count -= 1;
                        scoreChanger.setText(""+count);
                    }
                onStart();
            }
        });

        buttonMiddle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 2 clicked");
                if (middleChecker == "*") {
                    count += 1;
                    scoreChanger.setText(""+ count);
                }else
                {
                    count -= 1;
                    scoreChanger.setText(""+count);
                }
                onStart();
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 3 clicked");
                if (rightChecker == "*") {
                    count += 1;
                    scoreChanger.setText(""+count);
                }else
                {
                    count -= 1;
                    scoreChanger.setText(""+count);
                }
                onStart();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
        leftChecker = buttonLeft.getText().toString();
        middleChecker = buttonMiddle.getText().toString();
        rightChecker = buttonRight.getText().toString();
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if(randomLocation == 0){
            buttonLeft.setText("*");
            buttonMiddle.setText("O");
            buttonRight.setText("O");
        }
        else if(randomLocation == 1){
            buttonLeft.setText("O");
            buttonMiddle.setText("*");
            buttonRight.setText("O");
        }
        else {
            buttonLeft.setText("O");
            buttonMiddle.setText("O");
            buttonRight.setText("*");
        }
    }
}
