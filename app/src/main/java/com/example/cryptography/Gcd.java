package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Gcd extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcd);
        editText1 =findViewById(R.id.editTextTextPersonName);
        editText2 =findViewById(R.id.editTextTextPersonName2);
        button =findViewById(R.id.button);
        textView=findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1=Integer.parseInt(editText1.getText().toString());;
                int num2=Integer.parseInt(editText2.getText().toString());;
                System.out.print("Enter the first number: ");
                //int num1 = sc.nextInt();

                System.out.print("Enter the second number: ");
                // int num2 = sc.nextInt();

                int gcd = findGCD(num1, num2);

                System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd);
                //TextView tv_data=(TextView)findViewById(R.id.tv_result);
                textView.setText("your Ans is :- "+gcd);
            }
        });

    }
    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}