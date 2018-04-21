package com.example.xuebaopeng.aspectjxtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.aspectjaop.DebugTrace;

public class MainActivity extends AppCompatActivity {


    @DebugTrace
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @DebugTrace
    @Override
    protected void onStart() {
        super.onStart();
    }

    @DebugTrace
    @Override
    protected void onPause() {
        super.onPause();
    }

    @DebugTrace
    @Override
    protected void onStop() {
        super.onStop();
    }

    @DebugTrace
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @DebugTrace
    @Override
    protected void onResume() {
        super.onResume();
    }

    @DebugTrace
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
