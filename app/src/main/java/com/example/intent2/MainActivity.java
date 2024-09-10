package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//Khai bao bien
    EditText edtA, edtB;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Anh xa toi view
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnKQ = findViewById(R.id.btnKQ);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khoi tao intent
                Intent myIntent = new Intent(MainActivity.this, ResultAtivity.class);
                //Lay gia tri a va b
                int a = Integer.parseInt(edtA.getText().toString());
                int b= Integer.parseInt(edtB.getText().toString());
                //Khoi tao Bundle de dong goi du lieu
                Bundle myBundle = new Bundle();
                myBundle.putInt("soa",a);
                myBundle.putInt("sob",b);
                // dua myBundle vao intern
                myIntent.putExtra("packet",myBundle);
                startActivity(myIntent);
            }
        });
    }
}