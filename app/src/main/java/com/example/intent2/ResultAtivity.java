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

public class ResultAtivity extends AppCompatActivity {
//Khai bao bien
    EditText edtNghiem;
    Button btnBack;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_ativity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Anh xa toi view
        edtNghiem = findViewById(R.id.edtNghiem);
        btnBack = findViewById(R.id.btnBack);
        //Boc lop goi intent
        myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("packet");
        int a = myBundle.getInt("soa");
        int b = myBundle.getInt("sob");
        String nghiem = "";
        //Thuat toan
        if(a==0 && b==0){
            nghiem = "Phương trình vô số nghiệm";
        } else if (a==0 && b!=0) {
            nghiem = "Phương trình vô nghiệm";
        }else {
            nghiem = "Nghiệm PT: "+ (-1.0)*b/a;
        }
        edtNghiem.setText(nghiem);
       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
    }
}