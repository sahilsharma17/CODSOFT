package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView problemTv, solutionTv;
    MaterialButton btnClear, btnOpenBracket, btnCloseBracket, btnDivide, btnMultiply, btnAdd, btnMinus, btnEquals, btnAllClear, btnDecimal;
    MaterialButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        problemTv = findViewById(R.id.problem_tv);
        solutionTv = findViewById(R.id.solution_tv);
        assignBtnID(btn0, R.id.btn_0);
        assignBtnID(btn1 ,R.id.btn_1);
        assignBtnID(btn2 ,R.id.btn_2);
        assignBtnID(btn3 ,R.id.btn_3);
        assignBtnID(btn4 ,R.id.btn_4);
        assignBtnID(btn5 ,R.id.btn_5);
        assignBtnID(btn6 ,R.id.btn_6);
        assignBtnID(btn7 ,R.id.btn_7);
        assignBtnID(btn8 ,R.id.btn_8);
        assignBtnID(btn9 ,R.id.btn_9);
        assignBtnID(btnClear ,R.id.btn_c);
        assignBtnID(btnAllClear ,R.id.btn_ac);
        assignBtnID(btnOpenBracket ,R.id.btn_open_bracket);
        assignBtnID(btnCloseBracket ,R.id.btn_close_bracket);
        assignBtnID(btnDivide ,R.id.btn_divide);
        assignBtnID(btnMultiply ,R.id.btn_multiply);
        assignBtnID(btnMinus ,R.id.btn_minus);
        assignBtnID(btnAdd ,R.id.btn_add);
        assignBtnID(btnDecimal ,R.id.btn_decimal);
        assignBtnID(btnEquals ,R.id.btn_equals);
    }

    private void assignBtnID(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        MaterialButton Button = (MaterialButton) view;
        String btnText = Button.getText().toString();
        solutionTv.setText(btnText);
    }
}