package com.akhil_infinity.akhil.analyzin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akhil_infinity.akhil.analyzin.CustomViews.AuthenticationDialog;
import com.akhil_infinity.akhil.analyzin.interfaces.AuthenticationListener;

public class MainActivity extends AppCompatActivity implements AuthenticationListener{
    private AuthenticationDialog auth_dialog;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                after_click_login();
            }
        });
    }

    @Override
    public void onCodeReceived(String auth_token) {
        if (auth_token == null)
            return;
    }

    public void after_click_login(){
        auth_dialog = new AuthenticationDialog(this,this);
        auth_dialog.setCancelable(true);
        auth_dialog.show();
    }
}
