package com.lzro.feedmatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btLoginDo;
    private TextView tvLoginNoAccount;
    private TextView tvLoginForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLoginDo = (Button) findViewById(R.id.btLoginDo);
        tvLoginNoAccount = (TextView) findViewById(R.id.tvLoginNoAccount);
        tvLoginForgotPass = (TextView) findViewById(R.id.tvLoginForgotPass);

        btLoginDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, PetListActivity.class);
                startActivity(i);
            }
        });

        tvLoginNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, InstructionActivity.class);
                startActivity(i);
            }
        });

        tvLoginForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TO-DO
            }
        });
    }
}
