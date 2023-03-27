package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
          CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              cardView1 =findViewById(R.id.gcdnumbar);
              cardView2 =findViewById(R.id.CaesarCipher);
              cardView3=findViewById(R.id.monoalphabetic);
              cardView4=findViewById(R.id.Playfair);
              cardView5=findViewById(R.id.HillCipher);
              cardView6=findViewById(R.id.vigenere);
              cardView7=findViewById(R.id.des);
              cardView8=findViewById(R.id.aes);
              cardView1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(MainActivity.this,Gcd.class);
                      startActivity(intent);
                  }
              });
              cardView2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent =new Intent(MainActivity.this,Caesar_Cipher.class);
                      startActivity(intent);
                  }
              });
              cardView3.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(MainActivity.this,monoalphabetic.class);
                      startActivity(intent);
                  }
              });
              cardView4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(MainActivity.this,Playfair.class);
                      startActivity(intent);
                  }
              });
              cardView5.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent =new Intent(MainActivity.this,HillCipher.class);
                      startActivity(intent);
                  }
              });
              cardView6.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent=new Intent(MainActivity.this,vigenere.class);
                      startActivity(intent);
                  }
              });
              cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,vigenere.class);
                startActivity(intent);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,aes.class);
                startActivity(intent);
            }
        });

    }
}