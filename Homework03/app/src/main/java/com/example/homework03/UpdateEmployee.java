package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateEmployee extends AppCompatActivity {


    TextView tv_j_update_username;
    EditText et_j_update_fname;
    EditText et_j_update_lname;
    EditText et_j_update_email;
    EditText et_j_update_password;
    EditText et_j_update_age;
    Button btn_j_update_update;
    Intent viewEmployeeIntent;
    DatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);



        tv_j_update_username = findViewById(R.id.tv_j_update_username);
        et_j_update_fname = findViewById(R.id.et_v_update_fname);
        et_j_update_lname = findViewById(R.id.et_v_update_lname);
        et_j_update_email = findViewById(R.id.et_v_update_email);
        et_j_update_password = findViewById(R.id.et_v_update_password);
        et_j_update_age = findViewById(R.id.et_v_update_age);
        btn_j_update_update = findViewById(R.id.btn_v_update_update);

        viewEmployeeIntent = new Intent(UpdateEmployee.this, ViewEmployee.class);

        dbHelper = new DatabaseHelper(this);

        Intent cameFrom = getIntent();

        Employee employeePassed = (Employee) cameFrom.getSerializableExtra("Employee");


        tv_j_update_username.setText(employeePassed.getuName());
        et_j_update_fname.setText(employeePassed.getfName());
        et_j_update_lname.setText(employeePassed.getlName());
        et_j_update_email.setText(employeePassed.getEmail());
        et_j_update_password.setText(employeePassed.getPassword());
        et_j_update_age.setText(employeePassed.getAge());

        updateEmployeeInfoEventHandler();

    }

    //  If they get here, just update the data, no need to check if it has changed yet
    public void updateEmployeeInfoEventHandler()
    {

        btn_j_update_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                //  take all imputed information and pass the new Employee back to view
                Employee updatedEmployee = new Employee(tv_j_update_username.getText().toString(),et_j_update_fname.getText().toString(), et_j_update_lname.getText().toString(),et_j_update_email.getText().toString(),et_j_update_password.getText().toString(),et_j_update_age.getText().toString());

                dbHelper.updateExistingEmployee(updatedEmployee);

                viewEmployeeIntent.putExtra("Employee", updatedEmployee);

                startActivity(viewEmployeeIntent);

            }
        });

    }



}