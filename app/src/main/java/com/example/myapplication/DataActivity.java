package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDataBinding;

public class DataActivity extends AppCompatActivity {
    private final static String TAG = "SecondActivity";
    private ActivityDataBinding binding;

    private TextView tvName;
    private TextView tvAge;
    private TextView tvAddress;
    private Button buttonYes;
    private Button buttonNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tvName = findViewById(R.id.textName);
        tvAge = findViewById(R.id.textAge);
        tvAddress = findViewById(R.id.textAddress);
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String name = (String) bundle.get("name");
        Integer age = (Integer) bundle.get("age");
        String address = (String) bundle.get("address");

        tvName.setText(getString(R.string.labelName) + " " + name);
        tvAge.setText(getString(R.string.labelAge) + " " + age);
        tvAddress.setText(getString(R.string.labelAddress) + " " + address);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DataActivity.this, MainActivity.class);

                Toast.makeText(DataActivity.this, getString(R.string.messageSuccess),
                        Toast.LENGTH_SHORT).show();

//                i.putExtra("clearFields", true);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(i);
                finish();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DataActivity.this, MainActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                i.putExtra("name", name);
                i.putExtra("age", age);
                i.putExtra("address", address);

//                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy");
    }
}