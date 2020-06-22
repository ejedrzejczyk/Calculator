package com.example.kalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class SimpleActivity extends AppCompatActivity {

    private TextView equation;
    private TextView number;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button dot;
    private Button equal;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button opposite;
    private Button c;
    private Button ac;

    private String expression = "";
    private String text;
    private Double result;
    private int counter = 0;
    private boolean newEquation = true;
    private boolean illegalEquation = false;


    public void buttonInit(){
        equation = findViewById(R.id.equation);
        number = findViewById(R.id.number);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        opposite = findViewById(R.id.opposite);
        c = findViewById(R.id.c);
        ac = findViewById(R.id.ac);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        buttonInit();
        number.setText("");
        equation.setText("");

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newEquation){
                    number.setText("");
                    newEquation = false;
                }
                number.append("9");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter == 0 && number.length() != 0 && !newEquation){
                    number.append(".");
                    counter++;
                }

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText("");
                equation.setText("");
                counter = 0;
                expression = "";
                newEquation = true;
                illegalEquation = false;
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = number.getText().toString();

                if(text.length()>0){

                    if(text.endsWith(".")){
                        counter = 0;
                    }
                    String newText=text.substring(0,text.length()-1);

                    number.setText(newText);
                }

            }
        });

        opposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && Double.parseDouble(number.getText().toString()) != 0){
                    text = number.getText().toString();
                    if(text.length() != 0){

                        char[] tab = text.toCharArray();

                        if(tab[0] != '-'){
                            number.setText("-" + text);
                        }
                        else{
                            number.setText(text.substring(1));
                        }
                    }
                }

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!illegalEquation){
                    operationClicked("/");
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!illegalEquation){
                    operationClicked("*");
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!illegalEquation){
                    operationClicked("+");
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!illegalEquation){
                    operationClicked("-");
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DoubleEvaluator doubleEvaluator = new DoubleEvaluator();

                if(number.length() != 0){
                    expression = equation.getText().toString() + number.getText().toString();
                }

                if(expression.length() == 0){
                    expression="0.0";
                }

                result = doubleEvaluator.evaluate(expression);
                if(result.isInfinite()){
                    popUp("Cannot divide by 0");
                    newEquation = true;
                    illegalEquation = true;
                }
                else{
                    number.setText(result.toString());
                    newEquation = true;
                    illegalEquation = false;
                    equation.setText("");
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("EQUATION", equation.getText().toString());
        outState.putString("NUMBER", number.getText().toString());
        outState.putString("EXPRESSION", expression);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        equation.setText(savedInstanceState.getString("EQUATION"));
        number.setText(savedInstanceState.getString("NUMBER"));
        expression = savedInstanceState.getString("EXPRESSION");
    }

    public void operationClicked(String op){

        if(number.length() != 0){
            text = number.getText().toString();
            if(Double.parseDouble(text) < 0){
                equation.append("(" + text + ")" + op);
            }
            else{
                equation.append(text + op);
            }
            number.setText("");
            counter = 0;
        }
        else{
            if(equation.length() != 0){
                text = equation.getText().toString();
                String newText = text.substring(0, text.length()-1) + op;
                equation.setText(newText);
            }
        }
    }

    public void popUp(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }


}

