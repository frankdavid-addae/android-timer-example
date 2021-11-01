package com.example.androidtimerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnStartTimer, btnPauseTimer, btnStopTimer;
    TextView tvTimerResult;
    Timer timer;

    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartTimer = findViewById(R.id.btnStartTimer);
        btnPauseTimer = findViewById(R.id.btnPauseTimer);
        btnStopTimer = findViewById(R.id.btnStopTimer);
        tvTimerResult = findViewById(R.id.tvTimerResult);

        btnStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null) return;
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Do something after timer
                        // Updating UI with result from timer
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvTimerResult.setText(x + " ");
                                x++;
                            }
                        });
                    }
                },0, 1000);
            }
        });

        btnPauseTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
            }
        });

        btnStopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                x = 0;
                tvTimerResult.setText(x + "");
            }
        });
    }
}