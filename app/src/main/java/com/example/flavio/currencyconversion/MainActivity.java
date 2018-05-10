package com.example.flavio.currencyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double usd;
    double rate;
    double outcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Make Objects
        final EditText input = (EditText)findViewById(R.id.txtDollar);
        final RadioButton euro = (RadioButton)findViewById(R.id.radEuro);
        final RadioButton peso = (RadioButton)findViewById(R.id.radPeso);
        final RadioButton cad = (RadioButton)findViewById(R.id.radCAD);
        final TextView result = (TextView)findViewById(R.id.txtResult);

        //make code for button listener and event
        Button convert = (Button)findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               usd=Double.parseDouble(input.getText().toString());
               if(usd<=100000){
                   //If usd <= 100000 is true
                   if(euro.isChecked()){
                       rate=.8128;
                   }
                   if(peso.isChecked()){
                       rate=18.6984;
                   }
                   if(cad.isChecked()){
                       rate=1.3058;
                   }

                   outcome=rate*usd;
                   DecimalFormat money= new DecimalFormat("$#,###,###.##");
                   result.setText("Converted currency is: "+money.format(outcome));
               }
               else{
                   //if usd <= 100000 is false
                   Toast.makeText(MainActivity.this,"USD must be less then 100,000",
                           Toast.LENGTH_LONG).show();
               }
            }
        });

    }
}
