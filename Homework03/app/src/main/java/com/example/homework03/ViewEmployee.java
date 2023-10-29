package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewEmployee extends AppCompatActivity {

    TextView tv_j_view_fullName;
    TextView tv_j_view_username;
    TextView tv_j_view_email;
    TextView tv_j_view_password;
    TextView tv_j_view_age;
    Button btn_j_view_update;
    Button btn_j_view_back;
    Intent mainActivity;
    Intent updateEmployee;
    Employee employeePassed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);



        tv_j_view_fullName = findViewById(R.id.tv_v_view_fullName);
        tv_j_view_username = findViewById(R.id.tv_v_view_username);
        tv_j_view_email = findViewById(R.id.tv_v_view_email);
        tv_j_view_password = findViewById(R.id.tv_v_view_password);
        tv_j_view_age = findViewById(R.id.tv_v_view_age);
        btn_j_view_update = findViewById(R.id.btn_v_view_update);
        btn_j_view_back = findViewById(R.id.btn_v_view_back);

        mainActivity = new Intent(ViewEmployee.this, MainActivity.class);
        updateEmployee = new Intent(ViewEmployee.this, UpdateEmployee.class);

        Intent cameFrom = getIntent();

        employeePassed = (Employee) cameFrom.getSerializableExtra("Employee");

        tv_j_view_fullName.setText(employeePassed.getlName() + ", " + employeePassed.getfName());
        tv_j_view_username.setText(employeePassed.getuName());
        tv_j_view_email.setText(employeePassed.getEmail());
        tv_j_view_password.setText(employeePassed.getPassword());
        tv_j_view_age.setText(employeePassed.getAge());

        returnToMainEventHandler();
        goToUpdateEventHandler();

    }

    public void returnToMainEventHandler()
    {

        btn_j_view_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                startActivity(mainActivity);

            }
        });



    }

    public void goToUpdateEventHandler()
    {

        btn_j_view_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //  give update the employee, and start UpdateEmployee.java
                updateEmployee.putExtra("Employee", employeePassed);
                startActivity(updateEmployee);

            }
        });

    }


}