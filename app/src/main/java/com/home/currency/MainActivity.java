package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float usExchangeRate = 30.9f;
    float jpExchangeRate = 0.28f;
    private EditText edNtd;
    private TextView tvJP;
    private TextView tvUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        edNtd = findViewById(R.id.ntd);
        tvJP = findViewById(R.id.jp);
        tvUS = findViewById(R.id.us);
    }

    public void exchange(View view) {
        if (edNtd.getText().toString().trim().length() == 0) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.warn_message)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        } else {
            float ntdValue = Float.parseFloat(edNtd.getText().toString());
            float usdValue = ntdValue / usExchangeRate;
            float jpValue = ntdValue / jpExchangeRate;
            Log.d("MainActivity", "USD: " + usdValue);

            tvUS.setText(String.valueOf(usdValue));
            tvJP.setText(String.valueOf(jpValue));

            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + usdValue)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
