package com.example.lab01_mob403_ps10375;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class Bai02_Check_Login_Server extends AppCompatActivity {

    EditText username, password;
    String user,pass;
    Button signin;
    String URL = "http://192.168.1.6/Mob403_Server/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai02_check_login_server);

        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        signin = findViewById(R.id.btnSignIn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = username.getText().toString().trim();
                pass= password.getText().toString().trim();

                if (!user.equals("") && !pass.equals("")){
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Login Successfully.")) {
                                Toast.makeText(getApplicationContext(), "Login Successfully.", Toast.LENGTH_SHORT).show();
                            } else if (response.equals("Login failed, try again!")) {
                                Toast.makeText(getApplicationContext(), "Login failed, try again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });


    }
}