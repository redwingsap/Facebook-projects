package com.arjun.sprint2;

import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Post extends AppCompatActivity {
    public static final String LOCATION_URL = "http://services.trainees.baabtra.com/BM-41769/location.php";
    public static final String STATUS = "stat";
    String s;
    TextView t1;
    Button cancel, post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action2);
        View view = getSupportActionBar().getCustomView();
        Toolbar parent = (Toolbar) view.getParent();
        parent.setPadding(0, 0, 0, 0);
        parent.setContentInsetsAbsolute(0, 0);


        t1 = (TextView) findViewById(R.id.textView11);
        Intent txt = getIntent();
        s = txt.getStringExtra("addr");
        t1.setText(s);


        cancel = (Button) findViewById(R.id.button9);
        post = (Button) findViewById(R.id.button11);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Post.this, Loggedin.class);
                startActivity(i);
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStatus();
            }
        });

    }

    private void setStatus() {


        StringRequest streq = new StringRequest(Request.Method.POST, LOCATION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.contains("200") && response.contains("Success")) {
                    postStatus();
                }
                else {
                    Toast.makeText(Post.this, response, Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Post.this, error.toString(), Toast.LENGTH_LONG).show();
            }

        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(STATUS, s);
                return map;
            }
        };

        RequestQueue req = Volley.newRequestQueue(this);
        req.add(streq);
    }

    private void postStatus(){

        Intent p = new Intent(Post.this, Loggedin.class);
        p.putExtra("addr", s);
        startActivity(p);
    }
}
