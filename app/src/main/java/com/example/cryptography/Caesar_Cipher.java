package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cryptography.R.id;

public class Caesar_Cipher extends AppCompatActivity {
    EditText editText1;
    Button button;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    TextView textView1,textView2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_cipher);
            editText1 =findViewById(R.id.editTextc);
            button=findViewById(R.id.button);
            textView1=findViewById(id.Text1);
            textView2=findViewById(id.Text2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String inputStr = editText1.getText().toString();
                    int shiftKey = 3;
                    textView1.setText("Encrypted Data:-"+encryptData(inputStr, shiftKey));
                    textView2.setText("Decrypted Data:-"+decryptData(encryptData(inputStr, shiftKey), shiftKey));

                    //Toast.makeText(Caesar_Cipher.this, "encryptData(inputStr, shiftKey))", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Caesar_Cipher.this, "+decryptData(encryptData(inputStr, shiftKey), shiftKey))", Toast.LENGTH_SHORT).show();

                }
            });




    }
   // public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // create encryptData() method for encrypting user input string with given shift key
    public static String encryptData(String inputStr, int shiftKey)
    {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();

        // encryptStr to store encrypted data
        String encryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++)
        {
            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));

            // get encrypted char for each char of inputStr
            int encryptPos = (shiftKey + pos) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);

            // add encrypted char to encrypted string
            encryptStr += encryptChar;
        }

        // return encrypted string
        return encryptStr;
    }

    // create decryptData() method for decrypting user input string with given shift key
    public static String decryptData(String inputStr, int shiftKey)
    {
        // convert inputStr into lower case
        inputStr = inputStr.toLowerCase();

        // decryptStr to store decrypted data
        String decryptStr = "";

        // use for loop for traversing each character of the input string
        for (int i = 0; i < inputStr.length(); i++)
        {

            // get position of each character of inputStr in ALPHABET
            int pos = ALPHABET.indexOf(inputStr.charAt(i));

            // get decrypted char for each char of inputStr
            int decryptPos = (pos - shiftKey) % 26;

            // if decryptPos is negative
            if (decryptPos < 0){
                decryptPos = ALPHABET.length() + decryptPos;
            }
            char decryptChar = ALPHABET.charAt(decryptPos);

            // add decrypted char to decrypted string
            decryptStr += decryptChar;
        }
        // return decrypted string
        return decryptStr;
    }


}