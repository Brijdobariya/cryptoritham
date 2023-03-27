package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HillCipher extends AppCompatActivity {
EditText editText1,editText2;
Button button;
TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hill_cipher);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        //editText3=findViewById(R.id.editText3);
        button=findViewById(R.id.button);
        textView1=findViewById(R.id.Text1);
        textView2=findViewById(R.id.Text2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Scanner console = new Scanner(System.in);
               System.out.println("Enter a text key in lower case");
             //  String keyText = console.nextLine();
               String keyText = editText1.getText().toString();
               OneTimePad algo = new OneTimePad(keyText);
               algo.GenereatePad();
               System.out.println("Enter the plain text");
               String plainText = editText2.getText().toString();
               String cipherText = algo.encrypt(plainText);
               System.out.println("The encrypted text is "+cipherText);
               textView1.setText("The encrypted text is "+cipherText);
               plainText = algo.decrypt(cipherText);
               System.out.println("The decrypted text is "+plainText);
               textView2.setText("The decrypted text is "+plainText);

           }
       });

    }
    public class OneTimePad
    {
        char vignereTable[][]= new char[26][26];
        public void GenereatePad() {

            char alpharray[] = new char[26];
            char c = 'a';
            for(int x=0;x<26;x++){
                alpharray[x] = c;
                c++;
            }
            int i,j,k;
            i = 0;
            while(i < 26)
            {
                k = i;
                for (j=0;j < 26;j++)
                {
                    if (k >= 26)
                        k = 0;
                    vignereTable[i][j] = alpharray[k++];
                }
                i++;
            }
        }
        private String key;
        public OneTimePad(String k)
        {
            key = k;
        }
        public String encrypt(String plainText)
        {
            char[] plainTextArr = plainText.toCharArray();
            while(key.length() < plainText.length())
            {
                key += key;
            }
            key = key.substring(0,plainText.length());
            System.out.println(key);
            char [] keyArray = key.toCharArray();
            String cipherText = "";
            for(int i=0; i < plainText.length();i++)
            {
                int rowpos = keyArray[i]-'a';
                int colpos = plainTextArr[i]-'a';
                cipherText += vignereTable[rowpos][colpos];
            }
            return cipherText;

        }
        public String decrypt(String cipherText)
        {
            String plainText = "";
            char[] cipherTextArr = cipherText.toCharArray();
            char [] keyArray = key.toCharArray();
            char [] plainTextArr = new char[keyArray.length];
            for(int i=0; i < keyArray.length; i++)
            {
                int rowpos = keyArray[i] - 'a';
                int cipherpos = new String(vignereTable[rowpos]).indexOf(cipherTextArr[i]);
                plainTextArr[i] = vignereTable[0][cipherpos];
            }
            plainText = new String(plainTextArr);
            return plainText;
        }


    }

}