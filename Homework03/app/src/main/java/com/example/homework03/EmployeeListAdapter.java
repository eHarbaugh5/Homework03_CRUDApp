package com.example.homework03;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeListAdapter extends BaseAdapter
{

    Context context;
    ArrayList<Employee> listOfEmployees;




    public EmployeeListAdapter(Context c, ArrayList<Employee> ls)
    {

    context = c;
    listOfEmployees = ls;

    }

    @Override
    public int getCount() {
        return listOfEmployees.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfEmployees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        if (view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        TextView tv_j_fName_lName = view.findViewById(R.id.tv_v_fName_lName);
        TextView tv_j_uName = view.findViewById(R.id.tv_v_uName);


        //  get employee passed to me
        Employee employee = listOfEmployees.get(i);
        tv_j_fName_lName.setText(employee.getfName() + " " + employee.getlName());
        tv_j_uName.setText(employee.getuName());


        return view;
    }
}
