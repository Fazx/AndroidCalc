package com.example.calc3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_clear,btn_backspace,btn_divide,btn_multi,btn_sub,btn_plus,btn_dot,btn_equal;
    private TextView text_result;
    private HashMap<Integer, String> btMap;
    private String result = "";
    private DoCalc doCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initButtons();
        doCalc = new DoCalc();
    }
    private void initViews(){
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_backspace = (Button) findViewById(R.id.btn_backspace);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_equal = (Button) findViewById(R.id.btn_equal);

        text_result = (TextView) findViewById(R.id.text_result);
//        text_result.setMovementMethod(ScrollingMovementMethod.getInstance());
        //显示位置
//        text_result.setGravity(Gravity.BOTTOM | Gravity.RIGHT);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_backspace.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    private void initButtons(){
        btMap = new HashMap<Integer, String>();
        btMap.put(R.id.btn_0, "0");
        btMap.put(R.id.btn_1, "1");
        btMap.put(R.id.btn_2, "2");
        btMap.put(R.id.btn_3, "3");
        btMap.put(R.id.btn_4, "4");
        btMap.put(R.id.btn_5, "5");
        btMap.put(R.id.btn_6, "6");
        btMap.put(R.id.btn_7, "7");
        btMap.put(R.id.btn_8, "8");
        btMap.put(R.id.btn_9, "9");
        btMap.put(R.id.btn_clear, "C");
        btMap.put(R.id.btn_backspace, "B");
        btMap.put(R.id.btn_divide, "÷");
        btMap.put(R.id.btn_multi, "×");
        btMap.put(R.id.btn_sub, "-");
        btMap.put(R.id.btn_plus, "+");
        btMap.put(R.id.btn_dot, ".");
        btMap.put(R.id.btn_equal, "=");
    }

    private void Clear(){
        result = "";
    }
    private void BackSpace(){
        if(!"".equals(result)) {
            result = result.substring(0, result.length() - 1);
        }
    }
    private void Equal(){
        try{
            result = doCalc.GetResult(result);
        }catch (Exception e){
            result =  "Invalid Operation!";
        }

        //result = doCalc.GetResult(result);
    }


    private void Default(String input) {
        result += input;
        System.out.print(input);
    }

    @Override
    public void onClick(View v){
        String input = btMap.get(v.getId());
        switch(input){
            case "C":
                Clear();
                break;
            case "B":
                BackSpace();
                break;
            case "=":
                Equal();
                break;
                default:
                    Default(input);
        }
        text_result.setText(result);
    }
}
