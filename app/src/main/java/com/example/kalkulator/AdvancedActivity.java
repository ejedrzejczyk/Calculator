package com.example.kalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class AdvancedActivity extends AppCompatActivity {


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
    private Button sin;
    private Button cos;
    private Button tg;
    private Button log;
    private Button ln;
    private Button reverse;
    private Button sqrt;
    private Button pow2;
    private Button pow;
    private Button percent;




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
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tg = findViewById(R.id.tg);
        log = findViewById(R.id.log);
        ln = findViewById(R.id.ln);
        reverse = findViewById(R.id.reverse);
        sqrt = findViewById(R.id.sqrt);
        pow2 = findViewById(R.id.pow2);
        pow = findViewById(R.id.pow);
        percent = findViewById(R.id.percent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

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

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0){
                    text = number.getText().toString();
                    double num = Math.sin(degreesToRadians(Double.parseDouble(text)));
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    double num = Math.cos(Math.toRadians(Double.parseDouble(text)));
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
            }
        });

        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    double num = Math.tan(Math.toRadians(Double.parseDouble(text)));
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    if(Double.parseDouble(text) > 0){
                        double num = Math.log10(Double.parseDouble(text));
                        number.setText(String.valueOf(num));
                    }
                    else{
                        popUp("Logarithm of negative number does not exist.");
                        illegalEquation = true;
                    }
                }
                newEquation = true;
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    if(Double.parseDouble(text) > 0){
                        double num = Math.log(Double.parseDouble(text));
                        number.setText(String.valueOf(num));
                    }
                    else{
                        popUp("Logarithm of negative number does not exist.");
                        illegalEquation = true;
                    }
                }
                newEquation = true;
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    if(Double.parseDouble(text) >= 0){
                        double num = Math.sqrt(Double.parseDouble(text));
                        number.setText(String.valueOf(num));
                    }
                    else{
                        popUp("Square root of negative number does not exist.");
                        illegalEquation = true;
                    }
                }
                newEquation = true;
            }
        });

        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0){
                    text = number.getText().toString();
                    double num = 1/(Double.parseDouble(text));
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
            }
        });

        pow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0) {
                    text = number.getText().toString();
                    double num = Math.pow(Double.parseDouble(text), 2);
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!illegalEquation){
                    operationClicked("^");
                }
                newEquation = true;
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equation.length() == 0 && number.length() != 0){
                    text = number.getText().toString();
                    double num = Double.parseDouble(text) / 100.0;
                    number.setText(String.valueOf(num));
                }
                newEquation = true;
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
                    popUp("Cannot divide by 0.");
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
        //outState.putDouble("RESULT", result);
        //outState.putInt("COUNTER", counter);
        //outState.putBoolean("NEW_EQUATION", newEquation);

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

    public double degreesToRadians(double degrees){
        return (degrees * Math.PI) / 180;
    }

    public boolean calculation(){
        DoubleEvaluator doubleEvaluator = new DoubleEvaluator();

        result = doubleEvaluator.evaluate(expression);
        if(result.isInfinite()){
            popUp("Cannot divide by 0.");
            newEquation = true;
            illegalEquation = true;
        }
        return illegalEquation;
    }

}
