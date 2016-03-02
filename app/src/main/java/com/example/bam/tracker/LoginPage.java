package com.example.bam.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginPage extends ActionBarActivity implements View.OnClickListener {
    Button Sub;
    public EditText user,pass;
    datatbasehandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user=(EditText)findViewById(R.id.PhoneNo);
        pass=(EditText)findViewById(R.id.PassWord);
        Sub=(Button)findViewById(R.id.Login);
        handler= new datatbasehandler(this,null,null,1);
        Sub.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.Login:
                String phoneno=user.getText().toString();
                String password=pass.getText().toString();
                if(phoneno.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Your PhoneNo",Toast.LENGTH_LONG).show();

                }
                if (password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter Your password",Toast.LENGTH_LONG).show();

                }
                else {
                    ArrayList<String> al = new ArrayList<>();
                    al.add("");
                    al.add(password);
                    al.add("");
                    al.add(phoneno);
                    al.add("1");
                    new MyAsync(this).execute(al);

                }
                break;
        }
    }
}
