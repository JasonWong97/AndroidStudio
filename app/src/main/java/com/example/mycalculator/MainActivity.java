package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    float ParseFloat(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Float.parseFloat(strNumber);
            } catch(Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        }
        else return 0;
    }

    private RadioGroup arithmeticRG;
    private EditText num1;
    private EditText num2;
    private TextView result;
    //private Button


    //有两种情况，算术结果会改变：1.数字变动时，需要设置监听器   2.RadioButton变动时，需要设置监听器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arithmeticRG=findViewById(R.id.radioGrouparithmetic);
        num1=findViewById(R.id.editTextNumber1);
        num2=findViewById(R.id.editTextNumber2);
        result=findViewById(R.id.textViewResult);


        arithmeticRG.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        String Snum1=num1.getText().toString().trim();
        String Snum2=num2.getText().toString().trim();
        float fnum1=ParseFloat(Snum1);
        float fnum2=ParseFloat(Snum2);
        float fresult;
        String Sresult;

        switch (checkedId){
            case R.id.radioButtonAdd:
                fresult=fnum1+fnum2;
                Sresult=Float.toString(fresult);
                result.setText(Sresult);
                break;
            case R.id.radioButtonSub:
                fresult=fnum1-fnum2;
                Sresult=Float.toString(fresult);
                result.setText(Sresult);
                break;
            case R.id.radioButtonMul:
                fresult=fnum1*fnum2;
                Sresult=Float.toString(fresult);
                result.setText(Sresult);
                break;
            case R.id.radioButtonDiv:
                fresult=fnum1/fnum2;
                Sresult=Float.toString(fresult);
                result.setText(Sresult);
                break;

        }
    }
}
