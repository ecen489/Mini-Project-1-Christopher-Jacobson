package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

public class DailyBudget extends AppCompatActivity {
    private TextView tvDB;
    private ImageView ivFood;

    Float dailyBudget = 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_budget);
        dailyBudget = getIntent().getFloatExtra("dailyBudget",dailyBudget);
        dailyBudget = round(dailyBudget,2);
        ivFood = (ImageView)findViewById(R.id.ivFood);
        if (dailyBudget > 10.0f){
            ivFood.setImageResource(R.drawable.ribs);
        }else if (dailyBudget > 5.0f){
            ivFood.setImageResource(R.drawable.hotpocket);
        }else{
            ivFood.setImageResource(R.drawable.ramen);
        }
        tvDB = (TextView) findViewById(R.id.tvDB);
        String string = "You have a daily budget of $" + Float.toString(dailyBudget);
        tvDB.setText(string);
    }
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}


