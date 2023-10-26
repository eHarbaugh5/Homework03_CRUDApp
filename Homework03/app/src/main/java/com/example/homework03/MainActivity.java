package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn_j_addEmployee;
    ListView lv_j_listEmployees;
    ArrayList<Employee> listOfEmployees;
    EmployeeListAdapter adapter;
    Intent addEmployeeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addEmployee = findViewById(R.id.btn_v_addEmployee);
        lv_j_listEmployees = findViewById(R.id.lv_v_listEmployees);

        //  MUST ESTABLISH THAT the list IS an arraylist of employee
        listOfEmployees = new ArrayList<Employee>();

        //  temp employee data
        Employee newEmployee = new Employee();
        newEmployee.setuName("BSmith");
        newEmployee.setfName("Bob");
        newEmployee.setlName("Smith");

        listOfEmployees.add(newEmployee);

        //  ---------------------------------------------------------

        addEmployeeIntent = new Intent(MainActivity.this, AddEmployee.class);



        addEmployeeEventHandler();
        fillListView();
    }

    public void addEmployeeEventHandler()
    {

        btn_j_addEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                startActivity(addEmployeeIntent);

            }
        });

    }

    public void fillListView()
    {

        adapter = new EmployeeListAdapter(this, listOfEmployees);
        lv_j_listEmployees.setAdapter(adapter);

    }



}