package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {

    private EditText avaliableBalance;
    private TextView lastDayOfSchool;
    private Button start;
    private ImageButton cal;
    private TextView avaBal;
    private TextView daysLeft;

    float balance = 0.0f;
    Integer numOfDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    Integer totalDays = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avaliableBalance = (EditText)findViewById(R.id.etAB);
        lastDayOfSchool = (TextView)findViewById(R.id.tvLDoS);
        start = (Button)findViewById(R.id.btnStart);
        cal = (ImageButton)findViewById(R.id.iBCal);
        avaBal = (TextView)findViewById(R.id.tvAvaBal);
        daysLeft = (TextView)findViewById(R.id.tvDaysLeft);
        String date = getIntent().getStringExtra("date");
        balance = getIntent().getFloatExtra("balance",0.0f);
        final Integer lastDay = getIntent().getIntExtra("dayOfMonth", 0);
        final Integer lastMonth = getIntent().getIntExtra("month", 0);
        Calendar calendar = Calendar.getInstance();
        //int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int today = calendar.get(Calendar.DAY_OF_MONTH);
        /*
        Integer month = calendar.MONTH;
        Integer today = calendar.DAY_OF_MONTH;
        */



        if(balance!=0.0f){
            //String sBalance = Float.toString(balance);
            avaliableBalance.setText(""+balance);
        }

        if(date!=null) {
            start.setClickable(true);
            if(lastMonth > month){
                totalDays = (numOfDays[month] - today);
                totalDays = totalDays + lastDay;
            }else{
                totalDays = lastDay - today;
            }
            for (Integer i = month+1; i < lastMonth; i++){
                totalDays = totalDays + numOfDays[i];
            };
            String daysLeftString =  Integer.toString(totalDays) + " Days Left";
            daysLeft.setText(daysLeftString);
            //daysLeft.setText(today + "/" + (month + 1);
            String newDate = "Last Day of School: " + date;
            lastDayOfSchool.setText(newDate);
        }

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalDays = 0;
                float balance = Float.parseFloat(avaliableBalance.getText().toString());
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                if(balance!=0.0f){
                    intent.putExtra("balance",balance);
                }else{
                    balance = 0.0f;
                    intent.putExtra("balance",balance);}
                startActivity(intent);

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent sintent = new Intent(MainActivity.this, ExpensesAndIncome.class);


               sintent.putExtra("balance", balance);

               sintent.putExtra("month",month);
               sintent.putExtra("today",today);
               sintent.putExtra("lastMonth",lastMonth);
               sintent.putExtra("lastDay",lastDay);


               startActivity(sintent);
            }
        });

    }

}

