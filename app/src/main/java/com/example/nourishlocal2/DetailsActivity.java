package com.example.nourishlocal2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = DetailsActivity.class.getSimpleName();
    private String friendName,type;
    private ImageView typeImageView;
    private TextView tvTitle, tvDesc;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        friendName = getIntent().getStringExtra(getString(R.string.friend_Name));
        type   = getIntent().getStringExtra(getString(R.string.Key_type));
        typeImageView = findViewById(R.id.typeImageView);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnShare = (Button) findViewById(R.id.btnShare);
     //   Log.d(TAG,friendName);
       // Log.d(TAG,type );

       typeImageView.setImageResource(setImagetype(type));
       tvTitle.setText(type);
       tvDesc.setText(setDesc(type));
       btnShare.setText(String.format("%s %s", getString(R.string.btnShare), friendName));

       btnShare.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent shareIntent = new Intent();
               shareIntent.setAction(Intent.ACTION_SEND);
               shareIntent.setType("text/plain");
               String Msg = String.format("%s %s" , friendName, setDesc(type));
               shareIntent.putExtra(Intent.EXTRA_TEXT, Msg);//Extra_Text is the Key which other apps could use to get info from our Intent
               startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name))); //CreatChooser will Prepare a window to choose which app we want to share with
           }
       });
    }

    private int setImagetype(String type){
        if(type.equals(getString(R.string.btnMake))){
              return R.drawable.make;
        }else if(type.equals(getString(R.string.btnEat))){
            return R.drawable.eat;
        }else if(type.equals(getString(R.string.btnGrow))){
            return R.drawable.grow;
        }else if(type.equals(getString(R.string.btnShop))){
            return R.drawable.shop;
        }else {
            return R.drawable.cook;
        }
    }

    private String setDesc(String type){
        if(type.equals(getString(R.string.btnMake))){
           return getString(R.string.make_description);
        }else if(type.equals(getString(R.string.btnEat))){
            return getString(R.string.eat_description);
        }else if(type.equals(getString(R.string.btnGrow))){
            return getString(R.string.grow_description);
        }else if(type.equals(getString(R.string.btnShop))){
            return getString(R.string.shop_description);
        }else {
            return    getString(R.string.cook_description);
        }
    }
}