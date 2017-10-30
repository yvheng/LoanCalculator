package com.example.taruc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewTotalInterest,textViewTotalLoan,textViewMonthPayment,textViewStatus;
    EditText editTextVehiclePrice,editTextDownpayment,editTextInterestRate,editTextRepayment,editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTotalInterest = (TextView)findViewById(R.id.totalInterest);
        textViewTotalLoan = (TextView)findViewById(R.id.totalLoan);
        textViewMonthPayment = (TextView)findViewById(R.id.monthPayment);
        textViewStatus = (TextView)findViewById(R.id.status);
        editTextVehiclePrice = (EditText)findViewById(R.id.vehiclePrice);
        editTextDownpayment = (EditText)findViewById(R.id.downPayment);
        editTextInterestRate = (EditText)findViewById(R.id.interestRate);
        editTextRepayment = (EditText)findViewById(R.id.repayment);
        editTextSalary = (EditText)findViewById(R.id.salary);
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

        totalInterest = (rpayment/12.0)*(price-dpayment)*interestRate;
        totalLoan = (price-dpayment)+totalInterest;
        monthPayment = totalLoan/rpayment;

        textViewMonthPayment.setText(""+monthPayment);
        textViewTotalInterest.setText(""+totalInterest);
        textViewTotalLoan.setText(""+totalLoan);

        if(monthPayment>salary*0.3){
            textViewStatus.setText("Your loan application will be accepted!");
        }else{
            textViewStatus.setText("Your loan application will be rejected!");
        }
    }

    public void reset(View v){
        editTextVehiclePrice.setText("");
        editTextRepayment.setText("");
        editTextDownpayment.setText("");
        editTextSalary.setText("");
        editTextInterestRate.setText("");
        textViewStatus.setText("Please enter details and calculate again.");
        textViewMonthPayment.setText("Month Payment");
        textViewTotalLoan.setText("Total Loan");
        textViewTotalInterest.setText("Total Interest");
    }
}
