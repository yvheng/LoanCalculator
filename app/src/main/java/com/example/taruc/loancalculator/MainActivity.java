package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextVehiclePrice,editTextDownpayment,editTextInterestRate,editTextRepayment,editTextSalary;
    public static final String PAYMENT = "MainActivity.PAYMENT";
    public static final String INTEREST = "MainActivity.INTEREST";
    public static final String LOAN = "MainActivity.LOAN";
    public static final String STATUS = "MainActivity.STATUS";
    public static final String APPROVE = "Your loan application will be accepted!";
    public static final String REJECT = "Your loan application will be rejected!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextVehiclePrice = (EditText)findViewById(R.id.vehiclePrice);
        editTextDownpayment = (EditText)findViewById(R.id.downPayment);
        editTextInterestRate = (EditText)findViewById(R.id.interestRate);
        editTextRepayment = (EditText)findViewById(R.id.repayment);
        editTextSalary = (EditText)findViewById(R.id.salary);
    }

    public void calculate(View v){
        String priceS,dpaymentS,interestRateS,rpaymentS,salaryS,status;
        int price,dpayment,interestRate,rpayment,salary;
        double totalInterest,totalLoan,monthPayment;

        priceS = editTextVehiclePrice.getText().toString();
        dpaymentS = editTextDownpayment.getText().toString();
        interestRateS = editTextInterestRate.getText().toString();
        rpaymentS = editTextRepayment.getText().toString();
        salaryS = editTextSalary.getText().toString();

        price = Integer.parseInt(priceS);
        dpayment = Integer.parseInt(dpaymentS);
        interestRate = Integer.parseInt(interestRateS);
        rpayment = Integer.parseInt(rpaymentS);
        salary = Integer.parseInt(salaryS);

        totalInterest = (price-dpayment)*(interestRate/100)*(rpayment/12.0);
        totalLoan = (price-dpayment)+totalInterest;
        monthPayment = totalLoan/rpayment;

        if(monthPayment<salary*0.3){
            status = APPROVE;
        }else{
            status = REJECT;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(INTEREST,totalInterest);
        intent.putExtra(LOAN,totalLoan);
        intent.putExtra(PAYMENT,monthPayment);
        intent.putExtra(STATUS,status);
        startActivity(intent);
    }

    public void reset(View v){
        editTextVehiclePrice.setText("");
        editTextRepayment.setText("");
        editTextDownpayment.setText("");
        editTextSalary.setText("");
        editTextInterestRate.setText("");
    }
}
