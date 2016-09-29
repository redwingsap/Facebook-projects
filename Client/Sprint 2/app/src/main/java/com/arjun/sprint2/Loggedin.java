package com.arjun.sprint2;

import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

public class Loggedin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        View view =getSupportActionBar().getCustomView();
    }
}
