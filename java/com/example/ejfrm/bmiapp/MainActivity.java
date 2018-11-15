package com.example.ejfrm.bmiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);

        class BMI {
            private double he,we;
            private String res;
            private double a;

            final public void cal() {
                  a = (we/((he-100)*0.9))*100;

                if(a<90) {
                    res = "저체중";
                }else if(a>=90 && a<110 ){
                    res = "정상";
                }else if(a>=110&& a<150) {
                    res = "과체중";
                }else if(a>=150) {
                    res = "고도비만";
                }
            }

            public double getA() {
                return a;
            }

            public String getRes() {
                return res;
            }

            public void setRes(String res) {
                this.res = res;
            }



            public double getHe() {

                return he;
            }

            public void setHe(double he) {
                this.he = he;
            }

            public double getWe() {
                return we;
            }

            public void setWe(double we) {
                this.we = we;
            }
        }

        findViewById(R.id.resBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMI bmi = new BMI();

                bmi.setHe(Double.parseDouble(height.getText().toString()));
                bmi.setWe(Double.parseDouble(weight.getText().toString()));
                bmi.cal();
                result.setText("당신은 " +bmi.getRes()+"이고 " + "\n비만도는  "+ String.format("%.1f",bmi.getA())+ "%");

            }
        });
    }
}
