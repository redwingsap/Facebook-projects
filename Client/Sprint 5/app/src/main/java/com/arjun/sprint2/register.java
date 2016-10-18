package com.arjun.sprint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    public static final String REGISTER_URL ="http://services.trainees.baabtra.com/BM-41769/register.php";
    public static final String FNAME    = "firstname";
    public static final String SNAME    = "secondname";
    public static final String EMAIL    = "email";
    public static final String GENDER   = "gender";
    public static final String BDAY     = "bday";
    public static final String BMONTH   = "bmonth";
    public static final String BYEAR    = "byear";
    public static final String PASSWORD = "password";

    EditText fnm,snm,em,bd,bm,by,pwd;
    TextView log;
    Spinner spin;
    Button reg;
    private String fname,sname,email,bday,bmonth,byear,pass,item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fnm = (EditText) findViewById(R.id.editText5);
        snm = (EditText) findViewById(R.id.editText6);
        em  = (EditText) findViewById(R.id.editText7);
        bd  = (EditText) findViewById(R.id.editText4);
        bm  = (EditText) findViewById(R.id.editText8);
        by  = (EditText) findViewById(R.id.editText9);
        pwd = (EditText) findViewById(R.id.editText10);

        log = (TextView) findViewById(R.id.textView6);

        spin = (Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = spin.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        reg = (Button) findViewById(R.id.button5);

        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                UserLogin();
            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(register.this,Login.class);
                startActivity(i);
            }
        });
    }

    private void UserLogin(){

        fname   = fnm.getText().toString();
        sname   = snm.getText().toString();
        email   = em.getText().toString();
        bday    = bd.getText().toString();
        bmonth  = bm.getText().toString();
        byear   = by.getText().toString();
        pass    = pwd.getText().toString();

        StringRequest streq = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.contains("200")&&response.contains("Success"))
                {
                    openLogin();
                }
                else
                {
                    Toast.makeText(register.this, response, Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(register.this,error.toString(),Toast.LENGTH_LONG).show();
            }

        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                      Map<String, String> map = new HashMap<String, String>();

                map.put(FNAME, fname);
                map.put(SNAME, sname);
                map.put(EMAIL, email);
                map.put(GENDER, item);
                map.put(BDAY, bday);
                map.put(BMONTH, bmonth);
                map.put(BYEAR, byear);
                map.put(PASSWORD, pass);
                return map;
            }
        };

        RequestQueue req = Volley.newRequestQueue(this);
        req.add(streq);

    }

    private void openLogin(){

        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
