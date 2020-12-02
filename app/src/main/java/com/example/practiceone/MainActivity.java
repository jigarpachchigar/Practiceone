package com.example.practiceone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etmsal,etasal,ettxrate,ettxamt,etntamt,etweek;
    Button btncalc;

    double monthsal,annualsal,taxrate,netamt,weeksal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmsal = (EditText) findViewById(R.id.etmonthsal);
        etasal = (EditText) findViewById(R.id.etannualsal);
        ettxrate = (EditText) findViewById(R.id.ettaxrate);
        ettxamt = (EditText) findViewById(R.id.ettaxamt);
        etntamt = (EditText) findViewById(R.id.etnetamt);
        etweek = (EditText) findViewById(R.id.etweek);

        btncalc = (Button) findViewById(R.id.btncalc);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etmsal.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please Enter Monthly Salary",
                    Toast.LENGTH_LONG).show();
                }
                else {
                    calculate();
                }
            }

        });

    }

    private void calculate() {


            monthsal = Double.valueOf(etmsal.getText().toString());

            annualsal = monthsal * 12;

            etasal.setText(String.valueOf(annualsal));

            if (annualsal <= 50000)
            {
                ettxrate.setText("0%");
                taxrate = annualsal * 0;
                ettxamt.setText(String.format("%.2f",taxrate));
                netamt = annualsal - taxrate;
                etntamt.setText(String.format("%.2f",netamt));
                weeksal = netamt / 26;
                etweek.setText(String.format("%.2f",weeksal));

            }

            else if (annualsal>=50000 && annualsal<=70000 )
            {
                ettxrate.setText("17%");
                taxrate = annualsal * 0.17;
                ettxamt.setText(String.format("%.2f",taxrate));
                netamt = annualsal - taxrate;
                etntamt.setText(String.format("%.2f",netamt));
                weeksal = netamt / 26;
                etweek.setText(String.format("%.2f",weeksal));

            }
            else if (annualsal>=70000 && annualsal<=90000 )
            {
                ettxrate.setText("23%");
                taxrate = annualsal * 0.23;
                ettxamt.setText(String.format("%.2f",taxrate));
                netamt = annualsal - taxrate;
                etntamt.setText(String.format("%.2f",netamt));
                weeksal = netamt / 26;
                etweek.setText(String.format("%.2f",weeksal));
            }
            else
            {
                ettxrate.setText("27%");
                taxrate = annualsal * 0.27;
                ettxamt.setText(String.format("%.2f",taxrate));
                netamt = annualsal - taxrate;
                etntamt.setText(String.format("%.2f",netamt));
                weeksal = netamt / 26;
                etweek.setText(String.format("%.2f",weeksal));

            }

        }


    @Override
    public void onClick(View v) {

    }
}