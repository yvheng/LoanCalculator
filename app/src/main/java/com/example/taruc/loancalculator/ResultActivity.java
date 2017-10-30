package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewTotalInterest,textViewTotalLoan,textViewMonthPayment,textViewStatus;
    public static final String PAYMENT = "MainActivity.PAYMENT";
    public static final String INTEREST = "MainActivity.INTEREST";
    public static final String LOAN = "MainActivity.LOAN";
    public static final String STATUS = "MainActivity.STATUS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewTotalInterest = (TextView)findViewById(R.id.totalInterest);
        textViewTotalLoan = (TextView)findViewById(R.id.totalLoan);
        textViewMonthPayment = (TextView)findViewById(R.id.monthPayment);
        textViewStatus = (TextView)findViewById(R.id.status);

        Intent intent = getIntent();

        double totalInterest = intent.getDoubleExtra(INTEREST,0);
        double totalLoan = intent.getDoubleExtra(LOAN,0);
        double monthPayment = intent.getDoubleExtra(PAYMENT,0);
        String status = intent.getStringExtra(STATUS);

        textViewMonthPayment.setText("Monthly payment : "+monthPayment);
        textViewTotalInterest.setText("Total Interest : "+totalInterest);
        textViewTotalLoan.setText("Total Loan : "+totalLoan);
        textViewStatus.setText(status);
    }

    public void closeActivity(View v){
        finish();
    }
}
