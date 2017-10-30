package com.example.taruc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewTotalInterest,textViewTotalLoan,textViewMonthPayment;
    EditText editTextVehiclePrice,editTextDownpayment,editTextInterestRate,editTextRepayment,editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewTotalInterest = (TextView)findViewById(R.id.totalInterest);
        TextView textViewTotalLoan = (TextView)findViewById(R.id.totalLoan);
        TextView textViewMonthPayment = (TextView)findViewById(R.id.monthPayment);
        EditText editTextVehiclePrice = (EditText)findViewById(R.id.vehiclePrice);
        EditText editTextDownpayment = (EditText)findViewById(R.id.downPayment);
        EditText editTextInterestRate = (EditText)findViewById(R.id.interestRate);
        EditText editTextRepayment = (EditText)findViewById(R.id.repayment);
        EditText editTextSalary = (EditText)findViewById(R.id.salary);
    }

    public void calculate(View v){
        String priceS,dpaymentS,interestRateS,rpaymentS,salaryS;
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

        totalInterest = (price-dpayment)*interestRate*(rpayment/12);
        totalLoan = (price-dpayment)+totalInterest;
        monthPayment = totalLoan/rpayment;

        textViewMonthPayment.setText(""+monthPayment);
        textViewTotalInterest.setText(""+totalInterest);
        textViewTotalLoan.setText(""+totalLoan);

        if(monthPayment>salary){

        }else{

        }
    }

    public void reset(View v){
        editTextVehiclePrice.setText("");
        editTextRepayment.setText("");
        editTextDownpayment.setText("");
        editTextSalary.setText("");
        editTextInterestRate.setText("");
        textViewMonthPayment.setText("");
        textViewTotalLoan.setText("");
        textViewTotalInterest.setText("");
    }
}
