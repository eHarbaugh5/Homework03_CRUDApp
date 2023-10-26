package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEmployee extends AppCompatActivity {

    EditText et_j_add_uName;
    EditText et_j_add_fName;
    EditText et_j_add_lName;
    EditText et_j_add_age;
    EditText et_j_add_email;
    EditText et_j_add_password;
    Button btn_j_add_back;
    Button btn_j_add_add;
    Intent mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        et_j_add_uName = findViewById(R.id.et_v_add_uName);
        et_j_add_fName = findViewById(R.id.et_v_add_fName);
        et_j_add_lName = findViewById(R.id.et_v_add_lName);
        et_j_add_age = findViewById(R.id.et_v_add_age);
        et_j_add_email = findViewById(R.id.et_v_add_email);
        et_j_add_password = findViewById(R.id.et_v_add_password);
        btn_j_add_back = findViewById(R.id.btn_v_add_back);
        btn_j_add_add = findViewById(R.id.btn_v_add_add);

        mainActivity = new Intent(AddEmployee.this, MainActivity.class);

        backButtonEventHandler();

    }



    public void backButtonEventHandler()
    {

        btn_j_add_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                startActivity(mainActivity);

            }
        });

    }



}