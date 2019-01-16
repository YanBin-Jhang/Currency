package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float exchangeRate = 30.9f;
    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ntd);
    }

    public void exchange(View view) {
        if (edNtd.getText().toString().trim().length() == 0) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            float ntdValue = Float.parseFloat(edNtd.getText().toString());
            float usdValue = ntdValue / exchangeRate;
            Log.d("MainActivity", "USD: " + usdValue);

            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + usdValue)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
