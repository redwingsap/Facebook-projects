package com.arjun.sprint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkedin extends AppCompatActivity {
    Button notnow,cntn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkedin);

        notnow = (Button)findViewById(R.id.button7);
        cntn = (Button)findViewById(R.id.button8);
        notnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nn = new Intent(checkedin.this,Loggedin.class);
                startActivity(nn);

            }
        });
        cntn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cn = new Intent(checkedin.this,list.class);
                startActivity(cn);

            }
        });

    }
}
