package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn_j_adduser;
    ListView lv_j_listEmployees;
    ArrayList<Employee> listOfEmployees;
    EmployeeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_adduser = findViewById(R.id.btn_v_addUser);
        lv_j_listEmployees = findViewById(R.id.lv_v_listEmployees);



        addUserEventHandler();
        //fillListView();
    }

    public void addUserEventHandler()
    {

        btn_j_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {



            }
        });

    }

    public void fillListView()
    {

        adapter = new EmployeeListAdapter(this, listOfEmployees);
        lv_j_listEmployees.setAdapter(adapter);


    }



}