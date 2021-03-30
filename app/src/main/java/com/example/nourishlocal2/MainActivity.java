package com.example.nourishlocal2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   // public static final String tag = MainActivity.class.getSimpleName();
    private Button btnMake,btnEat,btnGrow,btnShop, btnCook ;
    private EditText etfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//To Display app only in portrait position (Could be from Manifes tFile)

        etfName = (EditText) findViewById(R.id.etfName);
        btnCook = (Button) findViewById(R.id.btnCook);
        btnEat = (Button) findViewById(R.id.btnEat);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShop = (Button) findViewById(R.id.btnShop);
        btnMake = (Button) findViewById(R.id.btnMake);


        btnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeatails(btnMake.getText().toString());
            }
        });

        btnCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeatails(btnCook.getText().toString());
            }
        });
        btnEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeatails(btnEat.getText().toString());
            }
        });
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeatails(btnShop.getText().toString());
            }
        });
        btnGrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeatails(btnGrow.getText().toString());

            }
        });


    }

    private void openDeatails(String type){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
          intent.putExtra(getString(R.string.friend_Name) , etfName.getText().toString());
          intent.putExtra(getString(R.string.Key_type), type);
        startActivity(intent);
    }
}