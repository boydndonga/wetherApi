package com.example.ndonga.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.buttonLogin)
    Button mButtonlogin;
    @BindView(R.id.textViewUserEmail)
    TextView mTextViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @ButterKnife.bind(this);
    }
}
