package com.example.homework03;

import java.io.Serializable;

public class Employee implements Serializable
{



    private String uName;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String age;

    public Employee()
    {

    }

     public Employee(String u, String f, String l, String e, String p, String a)
     {
         uName = u;
         fName = f;
         lName = l;
         email = e;
         password = p;
         age = a;

     }


    public String getuName() {
        return uName;
    }

    public void setuName(String u) {
        uName = u;
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String f) {
        fName = f;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String l) {
        lName = l;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String a) {
        age = a;
    }




}
