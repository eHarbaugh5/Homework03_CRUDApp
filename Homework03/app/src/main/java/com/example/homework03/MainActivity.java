//  =========================================
//  Evan Harbaugh
//  10/28/23
//  Employee CRUD application for an admin
//  =========================================
package com.example.homework03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn_j_addEmployee;
    ListView lv_j_listEmployees;
    ArrayList<Employee> listOfEmployees;
    EmployeeListAdapter adapter;
    Intent addEmployeeIntent;
    Intent viewEmployeeIntent;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_j_addEmployee = findViewById(R.id.btn_v_addEmployee);
        lv_j_listEmployees = findViewById(R.id.lv_v_listEmployees);


        dbHelper = new DatabaseHelper(this);
        dbHelper.initializeDB();


        //  MUST ESTABLISH THAT the list IS an arraylist of employee
        listOfEmployees = new ArrayList<Employee>();

        //  This is what gets all of the db data and puts it into listOfEmployees
        listOfEmployees = dbHelper.getAllRows();

        //  AddEmployee.java, and ViewEmployee.java references
        addEmployeeIntent = new Intent(MainActivity.this, AddEmployee.class);
        viewEmployeeIntent = new Intent(MainActivity.this, ViewEmployee.class);


        viewEmployeeEventHandler();
        addEmployeeEventHandler();
        deleteEmployeeEventHandler();
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

    public void viewEmployeeEventHandler()
    {

        lv_j_listEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                viewEmployeeIntent.putExtra("Employee", listOfEmployees.get(i));

                startActivity(viewEmployeeIntent);

            }
        });


    }
    public void deleteEmployeeEventHandler()
    {

        lv_j_listEmployees.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //  get username of long clicked employee to delete
                dbHelper.deleteEmployee( listOfEmployees.get(i).getuName());
                //  remove from active listOfEmployees array at pos i
                listOfEmployees.remove(i);
                //  update list view
                adapter.notifyDataSetChanged();

                return false;
            }
        });

    }

    public void fillListView()
    {

        adapter = new EmployeeListAdapter(this, listOfEmployees);
        lv_j_listEmployees.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }



}