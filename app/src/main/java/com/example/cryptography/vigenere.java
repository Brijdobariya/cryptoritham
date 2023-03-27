package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class vigenere extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;

  //  public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        textView1=findViewById(R.id.Text1);
        textView2=findViewById(R.id.Text2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Str = editText1.getText().toString();
                String Keyword = editText2.getText().toString();

                String str = LowerToUpper(Str);
                String keyword = LowerToUpper(Keyword);

                String key = generateKey(str, keyword);
                String cipher_text = cipherText(str, key);

                textView1.setText("Ciphertext : " + cipher_text + "\n");

                textView2.setText("Original/Decrypted Text : " + originalText(cipher_text, key));
            }
        });
    }
    static String LowerToUpper(String s)
    {
        StringBuffer str =new StringBuffer(s);
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLowerCase(s.charAt(i)))
            {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }
    static String originalText(String cipher_text, String key)
    {
        String orig_text="";

        for (int i = 0 ; i < cipher_text.length() &&
                i < key.length(); i++)
        {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }
    static String generateKey(String str, String key)
    {
        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }
    static String cipherText(String str, String key)
    {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++)
        {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

}