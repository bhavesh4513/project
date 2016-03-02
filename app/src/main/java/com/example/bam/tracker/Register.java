package com.example.bam.tracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends ActionBarActivity implements View.OnClickListener {
        EditText User,pass,email,phone,passcheck,otpinput;
        String userName,passCode,email_id,phoneNumber;
        Button bsubmit,otp;

    ArrayList<String> al;


        int rand,random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        User= (EditText) findViewById(R.id.editText);
        pass= (EditText) findViewById(R.id.editText2);
        email= (EditText) findViewById(R.id.editText3);
        phone= (EditText) findViewById(R.id.editText4);
        passcheck=(EditText)findViewById(R.id.PasswordCheck);
        bsubmit=(Button)findViewById(R.id.button);
        otp=(Button)findViewById(R.id.OTPGene);
        otpinput=(EditText)findViewById(R.id.OTP);
        bsubmit.setOnClickListener(this);
        otp.setOnClickListener(this);
        otpinput.setVisibility(View.INVISIBLE);







    }
    public void check(int ran) {
String pattern="[a-zA-Z]+([0-9])+(@)?[a-zA-Z]+(\\.com)?";

         userName = User.getText().toString();
         passCode = pass.getText().toString();
        email_id = email.getText().toString();
        phoneNumber = phone.getText().toString();
        random = ran;
        int tem = Integer.parseInt(otpinput.getText().toString());
        Toast.makeText(getApplicationContext(),"Email Validation"+email_id.matches(pattern),Toast.LENGTH_SHORT).show();
        if (!userName.equals("") && passCode.equals(passcheck.getText().toString()) && !phoneNumber.equals("") && tem == random && email_id.matches(pattern)) {
            Toast.makeText(getApplicationContext(), "Everthing Is Fine", Toast.LENGTH_LONG).show();
            al= new ArrayList<>();
            al.add(userName);
            al.add(passCode);
            al.add(email_id);
            al.add(phoneNumber);
            al.add("0");
           new MyAsync(this).execute(al);




                
            } else {
                Toast.makeText(getApplicationContext(), "Incomplete Details Fill Everthing properly", Toast.LENGTH_LONG).show();

            }

        }




    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.OTPGene:
                phoneNumber=phone.getText().toString();
                rand=(int)(Math.random()*9000)+1000;
                String pin =String.valueOf(rand);
                otp.setVisibility(View.INVISIBLE);
                otpinput.setVisibility(View.VISIBLE);
                //SmsManager manager = SmsManager.getDefault();
                //manager.sendTextMessage(no,null,pin,null,null);
                Toast.makeText(getApplicationContext(),"Value of random"+rand,Toast.LENGTH_LONG).show();
                break;
            case R.id.button:
                Toast.makeText(getApplicationContext(),"Value of Rand"+rand,Toast.LENGTH_LONG).show();
                check(rand);
                break;

        }

    }
}
