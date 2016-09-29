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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    public static final String LOGIN_URL ="http://api.baabtra.com/BM-41769/login.php";
    public static final String EMAIL     = "uname";
    public static final String PASSWORD  = "pwd";

    Button createAc,fpass,log;
    EditText em,pass;


    private  String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        em = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        fpass = (Button) findViewById(R.id.button3);
        log = (Button) findViewById(R.id.button);
        createAc = (Button) findViewById(R.id.button2);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLogin();
            }
        });

        createAc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, register.class);
                startActivity(i);
            }
        });
    }
        private void UserLogin(){

        email    = em.getText().toString();
        password = pass.getText().toString();

        StringRequest streq = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {

                    if (response.contains("200")&& response.contains("Success")) {
                        openLogedin();
                    } else {
                        Toast.makeText(Login.this,response, Toast.LENGTH_LONG).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG).show();
                }
            })

            {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put(EMAIL, email);
                    map.put(PASSWORD, password);
                    return map;
                }
            };


            RequestQueue req = Volley.newRequestQueue(this);
            req.add(streq);

    }

    private void openLogedin(){

        Intent intent = new Intent(Login.this,Loggedin.class);
        startActivity(intent);
    }
}
