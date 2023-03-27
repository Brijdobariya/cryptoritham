package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;

public class des extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;

    //  public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        textView1=findViewById(R.id.Text1);
        textView2=findViewById(R.id.Text2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the plain text: ");
                //String plainText = scanner.nextLine();
                String plainText = editText1.getText().toString();
                System.out.print("Enter the key (must be 8 characters): ");
                String keyString = scanner.nextLine();
                byte[] keyBytes = keyString.getBytes();
                SecretKeyFactory factory = null;
                try {
                    factory = SecretKeyFactory.getInstance("DES");
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                SecretKey key = null;
                try {
                    key = factory.generateSecret(new DESKeySpec(keyBytes));
                } catch (InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeyException e) {
                    throw new RuntimeException(e);
                }

                // Encryption
                byte[] encryptedBytes = new byte[0];
                try {
                    encryptedBytes = encrypt(plainText.getBytes(), key);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                String encryptedText = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
                }
                System.out.println("Encrypted Text: " + encryptedText);
                // Decryption
                byte[] decryptedBytes = new byte[0];
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        decryptedBytes = decrypt(Base64.getDecoder().decode(encryptedText), key);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                String decryptedText = new String(decryptedBytes);
                System.out.println("Decrypted Text: " + decryptedText);
            }
        });
    }
    private static byte[] encrypt(byte[] plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plaintext);
    }
    private static byte[] decrypt(byte[] ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(ciphertext);
    }
}