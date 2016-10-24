package com.arjun.sqliteregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login,signup;
    EditText email,pass;
    dbhelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new dbhelper(this);


        login = (Button) findViewById(R.id.button);
        signup = (Button) findViewById(R.id.button2);
        email = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String UName = email.getText().toString();
                String PSwrd = pass.getText().toString();
                String DBpwd = mydb.login(UName);
                if (PSwrd.equals(DBpwd))
                {
                    Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Loggedin.class);
                    startActivity(i);

                }
                else
                    {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_SHORT).show();

                    }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Register.class);
                startActivity(i);

            }
        });
    }
}
