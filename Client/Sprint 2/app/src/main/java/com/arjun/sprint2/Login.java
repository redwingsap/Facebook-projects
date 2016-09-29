package com.arjun.sprint2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login, reg;
    EditText email, pwd;
    TextView msg;
    DBhelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new DBhelper(this);

        login = (Button) findViewById(R.id.button);
        reg = (Button) findViewById(R.id.button2);
        email = (EditText) findViewById(R.id.editText);
        pwd = (EditText) findViewById(R.id.editText2);
        msg= (TextView) findViewById(R.id.textView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UName = email.getText().toString();
                String PSwrd = pwd.getText().toString();
                String DBpwd = mydb.fblogin(UName);
                if (PSwrd.equals(DBpwd)) {
                    Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, Loggedin.class);
                    startActivity(i);

                } else {
                    msg.setText("User Name or Password does not match");
                   // Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }

            }
        });
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View view) {
//                String inserted = mydb.insertData();
//                Cursor res = mydb.getAllData();
//                if (res.getCount() == 0) {
//                    ShowAllData("Error", "No data inserted");
//                    return;
//                }
//                StringBuffer str = new StringBuffer();
//                while (res.moveToNext()) {
//                    str.append("id:" + res.getString(0) + "\n");
//                    str.append("uname:" + res.getString(1) + "\n");
//                    str.append("pwd:" + res.getString(2) + "\n");
//                }
//
//                ShowAllData("Success", str.toString());
//            }
//        });
//    }


//    public void ShowAllData(String title, String message) {
//        AlertDialog.Builder alertMsg = new AlertDialog.Builder(this);
//        alertMsg.setCancelable(true);
//        alertMsg.setTitle(title);
//        alertMsg.setMessage(message);
//        alertMsg.show();

    }

}
