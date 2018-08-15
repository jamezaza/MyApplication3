package com.example.a10305_5.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private RadioGroup radioGroup;
    private String strTemperature ,strTem = "Celsius", strAnswer;
    private double douAnswer;
    private MyAlertDialog myAlertDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);



        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    strTemperature = editText.getText().toString().trim();

                    if (strTemperature.equals("")) {
                        Log.d("Supawadee", "Have space in blank");
                        myAlertDialog = new MyAlertDialog();
                        myAlertDialog.HavespaceDialog(MainActivity.this);

                    }
                    else if (strTem=="Celsius"){

                        calculateAnswer();

                        Log.d("Supawadee", "No space =" + strTemperature);
                        Log.d("Supawadee1", "Unit = " + strTem);
                        Log.d("Supawadee3", "Answer = " + strAnswer);

                        myAlertDialog = new MyAlertDialog();
                        myAlertDialog.ShowAnwer(MainActivity.this, strTemperature, strAnswer, strTem);

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }

                    else if (strTem=="Fahrenheit") {

                        calculateAnswer1();

                        Log.d("Supawadee", "No space =" + strTemperature);
                        Log.d("Supawadee1", "Unit = " + strTem);
                        Log.d("Supawadee3", "Answer = " + strAnswer);

                        myAlertDialog = new MyAlertDialog();
                        myAlertDialog.ShowAnwer(MainActivity.this,strTemperature,strAnswer,strTem);

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }
                    else if (strTem=="Kelvin") {

                        calculateAnswer2();
                        Log.d("Supawadee", "No space =" + strTemperature);
                        Log.d("Supawadee1", "Unit = " + strTem);
                        Log.d("Supawadee3", "Answer = " + strAnswer);

                        myAlertDialog = new MyAlertDialog();
                        myAlertDialog.ShowAnwer(MainActivity.this,strTemperature,strAnswer,strTem);

                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }

                       /* Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);*/



                }

                catch (Exception e) {

                }
                //ทำการลิ้งไปอีกเพจ Intent to ResultActivity
                //   Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                //   startActivity(intent);

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.Celsius:
                        strTem = "Celsius";
                        break;
                    case R.id.Fahrenheit:
                        strTem = "Fahrenheit";
                        break;
                    case R.id.Kelvin:
                        strTem = "Kelvin";
                        break;

                }
            }
        });


    }



    private void calculateAnswer() {
        douAnswer = Double.parseDouble(strTemperature);
        strAnswer = Double.toString(douAnswer);
    }//end of calculateAnswer

    private void calculateAnswer1() {
        douAnswer = Double.parseDouble(strTemperature)*1.8+32;
        strAnswer = Double.toString(douAnswer);
    }//end of calculateAnswer
    private void calculateAnswer2() {
        douAnswer = Double.parseDouble(strTemperature)+273.15;
        strAnswer = Double.toString(douAnswer);
    }//end of calculateAnswer



}
